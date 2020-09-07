# Fundamental Project

## Meals Planning and Budgeting

### Brief
The goal of this project was to create a CRUD web application; in which the user can Create, Read, Update and Delete objects. Moreover, the app needed to have a front-end connected to a database.

This application is a planning and budgeting tool that enables the user to keep track of what he/she is eating. The system is capable of storing information regarding the ingredients of a meal and their associated costs in each meal that the user inputs.

### Requirements
The application needs to utilise the technologies discussed during the training modules.
The tech stack required is the following:

Kanban Board: Jira
Database: GCP Managed SQL Server
Programming language: Java 
Front-end: HTML, CSS and JavaScript
Version Control: Git
CI Server: CircleCI
Cloud server: GCP virtual machine

### Design

#### Project Tracking

In order to deliver a project following the Agile Methodology, I used a Kanban Board to monitor and track the evolution of my project. 

As part of the visualisation process, I created a backlog of tasks to do, that I grouped into different categories called "Epics". Examples of epics are "Front-End", "Architecture", "GCP and CircleCi" and "presentation". These tags were used to get an instant overview of which part of the project the task to be carried out related to.

For time management purposes, I created a new "Sprint" every one-two days, in which I could store all the tasks I wanted to complete during this timeframe, in order to keep track of my process.

![Kanban](Kanban.png)

#### Entity Relationship Diagram

The database for this application was designed using Entity Relationship Diagrams. As is shown in the diagrams, my original plan was to create three entities: Days, Meals and Foods. There would have been a Many To Many relationship between Days and Meals, as well as between Meals and Foods. Unfortunately, the development of this idea would have required more time and expertise. This is why, at this stage, I decided to keep only two entities, Meals and Foods, having a One to Many relationship. 

![ERDs](https://user-images.githubusercontent.com/52075688/92330675-92e57e00-f068-11ea-9128-597a5071fd18.png)

### Creation

#### The Multi-Tiered Architecture
The most common example of multi-tier architecture is the three-tier architecture, which consists of:

1. Presentation Layer - The 'front-end', the part of the application seen by the user.
2. Business Layer - The 'back-end', this part of the application deals with applying business rules to any data received from or sent to the user.
3. Persistence/Data Layer - The 'database', persists data in order for the app to function.

##### Front-end: HTML and JavaScript
The front-end components of this application was created using HTML (HyperText Markup Language) as well as JavaScript.

##### Back-end: Java
The back-end of the application refers to the processing of data before the moving either to or from the database. This application follows a 

##### Database: GCP Managed SQL Server
A hosting system for this application was necessary to its creation. The Google Cloud Services server with the Ubuntu 18.04 Linux operating system was chosen for this purpose. H2 is a relational database management system written in Java. 

#### Version Control: GitHub
Github enables you to keep track of a repository that is used as a central source code management system, using a branching workflow model. The code become easily accessible as it is very easy to clone. 

#### Continuous Integration: Circle Ci
CircleCI is a continuous integration and delivery platform that is designed to automatically test and deploy source code as it is pushed into a code repository. CircleCI is a particularly user-friendly tool for CI/CD, allowing the user to get your automated tests up and running with minimal setup time required.

### Risk Assessement

Link to the complete risk assessment:
https://docs.google.com/spreadsheets/d/1zkykyqTN-Uv7JhmqB4F09KsH9naswYkpAZM02Vkr6a4/edit?usp=sharing

### Areas of improvements

#### Current bugs

- As part of the CRUD functionality, the Delete feature does not seem to work at the moment.

#### Future improvements
Google docs file linked to this with different potential risks, impacts and predicted level of occurrence

I would like to further develop the budgetting aspect of this app.

Implement a feature in which we can for 1 person how much of the unit of the ingredient is being used (eg: for a homemade soup, half a pack of frozen spinach is going to be used)
Implement a feature in which we can specify how many people are eating a meal, so we can specify how many portions of food to have (for the cost of ingredients) (eg: 1 person/ 2 people/ a household)
Implement an API that will essemtially get the price of ingredients automatically on a website (eg: on Sainsbury's website)
I would also like to change the way the Calendar page to a seven day calendar with the appropriate dates, be able to save previous weeks.

Finally, I would like to change the @OneToMany relationships between Days and Meals and Meals and Foods to @ManyToMany relationships, so that we could easily assign ingredients that have been placed into one meal more easily (and similarly with meals in days).

### Author:
Alessia Mele
