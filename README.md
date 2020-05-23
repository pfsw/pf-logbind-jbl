# Programmer's Friend Log Binding for JBoss Logging (JBL)

The Programmer's Friend (PF) libraries are all logging against their own logging API provided by component _pf-logging_.  
That has the advantage of not having a fixed dependency to any of the multiple logging frameworks in the Java world.

However, when using PF libraries in any application, the logging of the PF libraries should be routed to loggers of the
logging framework the application is using.

Therefore PF provides binding libraries for the most prominent logging frameworks.

This component is providing the binding to the [JBoss Logging API (JBL)](https://github.com/jboss-logging).  
It is compiled with __Java 6__.

## Usage

In order to route all PF logging to _JBoss Logging_, put _pf-logbind-jbl-x.x.x.jar_ on the classpath and activate it with
the following system property:

> -Dorg.pfsw.logging.binding=JBL

Alternatively you can activate the log binding programmatically by executing (very early at startup!) the following:

```java
org.pfsw.logging.LoggerFactoryProvider.setDefaultFactoryName("JBL")
```

## Dependency Management

You can find this library in [Programmer's Friend maven repository](http://pfsw.org/maven/repo/).
or on [jcenter](https://jcenter.bintray.com/org/pfsw/).

The library itself has _runtime_ dependencies to __org.pfsw:pf-logging:3.1.0__ and __org.jboss.logging:jboss-logging:3.3.1.Final__.


Include the library into your project:

__Gradle:__

```
runtime group: 'org.pfsw', name: 'pf-logbind-jbl', version: '1.0.0'
```

__Maven:__

```
<dependency>
    <groupId>org.pfsw</groupId>
    <artifactId>pf-logbind-jbl</artifactId>
    <version>1.0.0</version>
    <scope>runtime</scope>
</dependency>
```


## Build

The library can be build with its associated gradle wrapper:

``./gradlew clean build``

