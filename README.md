# sample-maven-java-webapp
This is a simple java application. This can be used for testing CICD processes as well.
 
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
