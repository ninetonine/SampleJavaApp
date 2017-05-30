# sample-maven-java-webapp
This is a simple java application. This can be used for testing CICD processes as well.

#Making a change
#Making another change
 
<pre>
To specify the version, add the following to the command line '-Dminor-version=<version>'
To run the integration tests, add the following to the command line '-Dmy.location=<host>'
</pre>

<pre>
The properties file are loaded from /etc/db.props
The hibernate.properties file should be copied to this location, for the database portion to work
</pre>

# To build and package the application run the folllowing command
<pre>
  mvn clean package -Dminor.version=${version}
</pre>

# To test that app is working you can hit the following urls

http://{url}/sampleapp
http://{url}/sampleapp/rest/service/test
http://{url}/sampleapp/rest/service/persons
