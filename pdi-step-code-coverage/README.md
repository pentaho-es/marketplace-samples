# PDI Step Code Coverage Sample

This is a sample project based on the Pentaho [PDI Step Archetype](https://github.com/pentaho/maven-project-archetypes/tree/master/pentaho-pdi-step-plugin-archetype).  Beginning with that archetype, we have added support for using the Jacoco Code Coverage plugin.  This sample project is further documented in the best practices document, "Pentaho PDI Step Plugins -- Unit Test Code Coverage" (forthcoming).

#### Pre-requisites for building the project:
* Maven, version 3+
* Java JDK 1.8
* This [settings.xml](https://github.com/pentaho/maven-parent-poms/blob/master/maven-support-files/settings.xml) in your <user-home>/.m2 directory


__IntelliJ__

* Don't use IntelliJ's built-in maven. Make it use the same one you use from the commandline.
  * Project Preferences -> Build, Execution, Deployment -> Build Tools -> Maven ==> Maven home directory

### Note on Lifecycle and Coverage Ratio

Currently the Jacoco plugin is set so that the coverage threshold is lower than than we actually have, so we do not see a failure.  To see a failure, set a higher coverage ratio minimum, for example, 80%:

```
<limit>
    <counter>COMPLEXITY</counter>
    <value>COVEREDRATIO</value>
    <minimum>0.80</minimum>
</limit>
```

In addition, note that "mvn package" will not run the coverage check, because the Jacoco "check" goal binds to the verify lifecycle phase by default.  To enable the coverage check, use "mvn install".




 
