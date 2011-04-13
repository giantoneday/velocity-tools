<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <artifactId>velocity-tools-parent</artifactId>
    <groupId>org.apache.velocity</groupId>
    <version>2.1.0-SNAPSHOT</version>
  </parent>
  <groupId>org.apache.velocity</groupId>
  <artifactId>velocity-tools-generic</artifactId>
  <version>2.1.0-SNAPSHOT</version>
  <name>Apache Velocity Tools - Generic tools</name>
  <description>Generic tools that can be used in any context.</description>
  <dependencies>
  	<dependency>
                <groupId>org.apache.velocity</groupId>
  		<artifactId>velocity-engine-servlet-logger</artifactId>
  		<version>2.0.0-SNAPSHOT</version>
  	</dependency>
  	<dependency>
  		<groupId>commons-beanutils</groupId>
  		<artifactId>commons-beanutils</artifactId>
  		<version>1.8.3</version>
  	</dependency>
  	<dependency>
  		<groupId>commons-digester</groupId>
  		<artifactId>commons-digester</artifactId>
  		<version>1.8.1</version>
  	</dependency>
  	<dependency>
  		<groupId>junit</groupId>
  		<artifactId>junit</artifactId>
  		<version>4.8.1</version>
  		<scope>test</scope>
  	</dependency>
  </dependencies>
</project>