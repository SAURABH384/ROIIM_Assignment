# Assignment
ROIIM Assignment 

Previously it was hosted on "http://18.222.211.178:8080/"
But since Ip has been changed, now it is hosted on "http://3.17.55.77:8080/"

1. Used Java Springboot with Maven build tool for creating REST API's.
2. Used MySQL as an data base.
3. Used Spring Data JPA and Hibernate for accessing the tables in the databases.

Requiremnts for running this project

1. Java JDK 15 should be installed
2. MySQL server should be installed
3. Maven Should be installed

How to run:

1. Open terminal
2. type - git clone "https://github.com/SunnyKhandare/Assignment"
3. type - cd /Path_to_downloaded_folder/Assignment
4. create mysql user with username "root1" and password "root1@pass"
5. create database "Payment" under "root1"
5. type - mvn clean install
6. type - nohup java -jar target/Assignment-0.0.1-SNAPSHOT.jar
7. go to localhost:8080 and you will see it running.
