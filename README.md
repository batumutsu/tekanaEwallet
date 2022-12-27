# tekanaEwallet
Tekana Ewallet RSSB was implemented using Spring Boot Framework with MYSQL 
for database storage(configurations for MYSQL database are located in application.yaml file)

STRATEGY:

First, we will gather requirements from the business team and the product owner to understand the goals and objectives of the new back-end solution for Tekana-ewallet. This will help us to create a clear scope and plan for the project.

Next, we will perform a technical analysis of the existing legacy platform to understand its current architecture, technology stack, and any potential challenges or risks that may impact the development of the new solution.

Based on the requirements and technical analysis, we will design a new technology stack and architecture for the back-end solution. This will involve choosing appropriate technologies and frameworks, such as Spring Boot, that are scalable, reliable, and maintainable.

We will then begin development of the back-end solution, following agile development principles such as Scrum or Kanban. We will use test-driven development (TDD) to ensure that the code is well-tested and of high quality.

As we develop the back-end solution, we will work closely with the front-end team to ensure that the APIs and other integration points are properly designed and implemented. We will also work with the UX team to ensure that the solution is intuitive and user-friendly.

Once the back-end solution is complete, we will perform thorough testing and debugging to ensure that it is ready for deployment.

Finally, each of the features will be implemented as a separate service in a microservice architecture, The microservices will communicate with each other using message-based communication, such as using a message broker like Apache Kafka.

All services will be deployed in a pilot containerized environment such as Docker to test its performance and gather feedback from a small group of users. 

If the pilot is successful, we will roll out the solution to the full user base in a production containerized environment such as Docker, and it will be horizontally scalable to handle high levels of traffic.


BACK-END SOLUTIONS WAS IMPLEMENTED USING SPRING BOOT FRAMEWORK:

The following are minimum required features included in the solution:

Customer Registration: This service will handle the creation and management of customer accounts. It will provide APIs for registering new customers, as well as retrieving and updating existing customer information.

Wallet Management: This service will handle the creation and management of customer wallets. It will provide APIs for creating new wallets, as well as retrieving and updating existing wallet information.

Transaction Management: This service will handle the creation and management of transactions. It will provide APIs for creating new transactions, as well as retrieving and updating existing transaction information.

Each of these features will be implemented as a separate Spring Boot microservice, with a set of REST APIs exposed for front-end developers to interact with.
