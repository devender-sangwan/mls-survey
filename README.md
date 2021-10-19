# mls-survey

Survey Application:

1. Description:

Survey Application is desgined using microservices architecture to allow any user to conduct a survey and respond to the survey.
Application consists of three microservices:
a) Survey-Discovery
b) Survey-Conduct-Service
c) Survey-Submission-Service

2. Technology:

- Java 11
- SpringBoot 2.5
- H2
- Spring Cloud


3. Checkout and Run:

3.1 checkout the repository 
git clone https://github.com/devender-sangwan/mls-survey.git
this will create a folder 'mls-survey' and checkout the code inside this folder.

3.2 First run Survey-Discovery
To run,  Open cmd -> go inside mls-survey/survey-discovery folder and run it as a spring boot standalone app.

you can access it on http://localhost:8761/

3.3 Next run Survey-Conduct-Service
To run,  Open cmd -> go inside mls-survey/survey-conduct-service folder and run it as a spring boot standalone app.

you can access

-  database on http://localhost:8182/h2

	jdbc url: jdbc:h2:mem:surveydb
	username: sa
	empty password

-  swagger on http://localhost:8182/swagger-ui/

3.4 Next run Survey-Submission-Service
To run,  Open cmd -> go inside mls-survey/survey-submission-service folder and run it as a spring boot standalone app.

you can access

-  database on http://localhost:8183/h2

	jdbc url: jdbc:h2:mem:survey_submission_db
	username: sa
	empty password

-  swagger on http://localhost:8183/swagger-ui/



4. Survey-Conduct-Service:

4.1 Description

This service is responsible for survey creation to add/update/delete questions with their answers/options.
It is a client of the service registry.

This service provides endpoints to:
- Create a survey
- Get all survey
- Get a survey
- Get all questions of a survey
- Get a question of a survey
- Add questions with their answers/options of a survey
- Modify already added questions with their answers/options of a survey
- Delete a Survey: cascading deletion upto answers/options
- Delete a Question: cascading deletion upto answers/options

4.2 API Endpoints covers:

- Validation
- Centralized exception handling
- Http Status codes in response with message
- Swagger integration


4.3 Database tables

- survey : stores survey basic details
- question: stores question basic details along with survey id
- option: store option basic details along with question id


5. Survey-Submission-Service:

5.1 Description

This service respond to the survey submission . It stores submitted answers by a user.
It is a client of the service registry.

This service provides a single endpoint to Capture survey responses.

5.2 Database tables
- survey_submission: stores survey, quesiton and their responses submitted by user.


Note: 
Both services have their own database.
Sample data has been created that will initialize on each service start-up


6. ToDo in both services:

Unit and Integration testing
Java Documentation
Swagger Documentation
Both service’s instances and Service Discovery instance can be run via docker-swarm
Orchestration communication between services
