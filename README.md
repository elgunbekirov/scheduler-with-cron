# scheduler-service
## Goal

Please create a simple Spring Boot application for an imaginary action execution.
Application should contain a scheduler service that runs at the time(s) specified in Spring Boot configuration file (evey minute by default but can be changed).

## Setup
- Install Maven
- Run "mvn clean install" to download dependencies
- Implement functionality described in "Assignments" below

Feel free to use any external libraries you want, just add them to the .pom file.

## Assignments
Create a CSV file containing 2 columns:

1) time - a time in the HH:MI format specifying time when the action shoud be executed
2) bitmask - a bitmask specified in numeric format. Bitmask will be representing days of the week when the action should be made. For example value 1 (0x01) means that action should be made on Monday, value 5 (0x5) means Monday and Wednesady.

In each scheduler run cycle application should load data from the file, parse it and determine should the action be done at the current time in Lagos, Nigeria.

Please use java.time library and java.time.DayOfWeek enum when checking the current day/time against the data from the file.

