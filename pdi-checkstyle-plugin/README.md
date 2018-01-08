# PDI Maven CheckStyle

This is a sample project based on our other Marketplace [Sample PDI Step Code Coverage](https://github.com/pentaho-es/marketplace-samples/tree/master/pdi-step-code-coverage).  From that starting point, in this project we have added support for the [Maven Checkstyle Plugin](https://maven.apache.org/plugins/maven-checkstyle-plugin/).

This is the companion code to the best practices document, "Pentaho PDI Plugins -- 
Using the Checkstyle Plugin" (forthcoming).

#### Pre-requisites for building the project:
* Maven, version 3+
* Java JDK 1.8
* This [settings.xml](https://github.com/pentaho/maven-parent-poms/blob/master/maven-support-files/settings.xml) in your <user-home>/.m2 directory


__IntelliJ__

* Don't use IntelliJ's built-in maven. Make it use the same one you use from the commandline.
  * Project Preferences -> Build, Execution, Deployment -> Build Tools -> Maven ==> Maven home directory