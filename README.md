# REST API Automation with Rest Assured (Java)


Below are the required steps in order to setup the project 

## Table of Contents
1. [Setup process](#setup)
2. [Running the project](#running)

# Setup process

1. Install Java on the system, currently I am using Java 11 

2. Install Maven or Gradle on the system, I am using Maven where it can be downloaded from https://maven.apache.org/download.cgi

3. Setup a project, open your Java IDE and choose a Maven Project 

4. Open pom.xml file and put these dependencies 

'''
    <dependencies>

        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.2.0</version>

        </dependency>

        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-path</artifactId>
            <version>4.2.0</version>

        </dependency>


        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>xml-path</artifactId>
            <version>4.2.0</version>

        </dependency>


        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-schema-validator</artifactId>
            <version>4.2.0</version>

        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.6.1</version>
            <scope>test</scope>
        </dependency>

        <!-- junit 5, unit test -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.3.1</version>
            <scope>test</scope>
        </dependency>


    </dependencies>
'''

5. Create a Java class under the test/java directory to write down test cases

# Running the project

1. Open up a terminal or command prompt and navigate to the project directory

2. Run the following command

'''
mvn -Dtest=APIAutomation test
'''

3. The results will be shown inside the terminal



