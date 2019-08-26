Log Analyzer: 

Table of content
a) Introduction
b) Technologies
c) Set up
d) Version
e) Author


Introduction :
Our custom-build server logs different events to a file named logfile.txt. Every event has 2 entries in the file - one
entry when the event was started and another when the event was finished. The entries in the file have no specific
order (a finish event could occur before a start event for a given id)
Every line in the file is a JSON object containing the following event data:
• id - the unique event identifier
• state - whether the event was started or finished (can have values "STARTED" or "FINISHED"
• timestamp - the timestamp of the event in milliseconds
Application Server logs also have the following additional attributes:
• type - type of log
• host - hostname

Technologies:

a) Java 8
b) Gradle
c) jUnit
d) Hibernate
e) HSQLDB database


Set Up:

Add all database related configuration in "hibernate.cfg.xml" file. If you are using HSQLDB then run server
locally on port 9001 and Database "demodb".


To compile and run these programs, you only need JDK 8 & Gradle installed.

To compile and run everything, the command is:

"gradle clean"
"gradle build"
"gradle fatjar"

To execute program, use below command

java -jar LogAnalyzer-all-1.0-SNAPSHOT.jar {filepath}

Ex-
java -jar LogAnalyzer-all-1.0-SNAPSHOT.jar src/main/resources/logfile.txt

Version:
1.0-SNAPSHOT

Author :
Harish Deore
