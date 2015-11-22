This is an archetype for a Java EE 7 application running on Wildfly 9.0.1.
The main purpose of this archetype is to let its users focus on developing the presentation
layer with Java Server Faces. The EJB module is  provided with entities and session beans.
In order to get it up and running, make sure that your application server has a datasource
with java:/MySqlDS as a jndi name and that it is manageable on the 19990 port.

To deploy the application run: "mvn clean install" on the parent project
To undeploy the application run: "mvn wildfly:undeploy" on the ear module