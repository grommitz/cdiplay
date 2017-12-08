# cdiplay

Simple java web app for experimenting with events, interceptors etc.

Captures metrics in a dropwizard metrics registry. Metrics servlet not working yet tho.

Usage with payara-micro:

    mvn clean install
    java -jar payara-micro-4.1.2.172.jar --deploy target/cdi-play-1.0-SNAPSHOT.war
  
  

