package com.sample.simplewebapp;

import javax.ws.rs.core.Response;

import junit.framework.TestCase;

import org.junit.Test;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class SampleAppIntegrationTest extends TestCase {

	@Test
	public void testGetMsg() throws Exception {
                String url = System.getProperty("my.location");

                String api = url + "/simpleapp";

                System.out.println("This is url: " + api);

                HttpClient client = new HttpClient();

                GetMethod method = new GetMethod(api);

      		int statusCode = client.executeMethod(method);
                
                System.out.println("This is the status code: ");
                System.out.println( statusCode );

                String expectedValue = "Hello World! Test\n";

      		if (statusCode == HttpStatus.SC_OK) {
                      byte[] responseBody = method.getResponseBody();
                      assertEquals(expectedValue, new String(responseBody));
                }
                else {
 		      assertTrue(false); //this should fail
  		}
       
	}
}
