package com.sample.simplewebapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sample.simplewebapp.entity.Person;

@Path("/service")
public class SampleApp {
		
	private static SessionFactory sessionFactory = null;
	
	private static final Logger LOGGER = Logger.getLogger(SampleApp.class.getName());
	  
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Hello: " + msg;
 
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/persons")
	public Response getPersons() {
 
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String output = "";
		List persons = session.createQuery("FROM Person").list();
		for (Iterator iter = persons.iterator(); iter.hasNext(); ) {
			Person person = (Person) iter.next();
			output += person.getFirstName() + " " + person.getLastName() + "\n"; 
		}
		
		tx.commit();
		session.close();
		
		return Response.status(200).entity(output).build();
	}
	
	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			java.util.Properties properties = new Properties();
		    try {
				properties.load(new FileInputStream("/etc/db.props"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			Configuration configuration = new Configuration().mergeProperties(properties).configure();
			
			for(String key : properties.stringPropertyNames()) {
				System.out.println("PRINTING PROPERTY!!!!!!!");
				  String value = properties.getProperty(key);
				  LOGGER.log(Level.INFO, "Prop value: " + value );
			}
			
			LOGGER.log(Level.INFO, "Property Values(url)", properties.get("url"));
			
		    ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();
		    serviceRegistryBuilder.applySettings(configuration.getProperties());
		    ServiceRegistry registry = serviceRegistryBuilder.buildServiceRegistry();
		    
		    sessionFactory = configuration.buildSessionFactory(registry);
		}
		
		return sessionFactory;
	}
}
