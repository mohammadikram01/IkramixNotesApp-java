IkramixNotesApp

IkramixNotesApp is a Spring Boot web conversion of my original Java Swing Notes Application. This project was built to modernize the old desktop version into a clean, responsive, and cloud-ready web application. It includes login security, categorized notes, PDF export, Docker support, and AWS EC2 deployment. The UI is built using Bootstrap to provide a simple and user-friendly experience.

Personal Introduction

My name is Mohammad Ikram, and this Notes Application is one of my personal learning projects where I rebuilt my older Java Swing application into a modern Spring Boot web app. I created this project to improve my backend development skills, learn responsive UI design, and practice Docker and AWS EC2 deployment. This application reflects my interest in building clean, functional software and continuously improving my programming and DevOps skills.

Features

Login authentication (default password: 1234)

Add, edit, delete, and clear notes

Categories: Work, Study, Personal, Other

Export notes to PDF (all_notes.pdf)

Responsive UI built with Bootstrap 5

Notes stored in notes.txt in the application directory

Docker multi-stage build support

Fully deployable on AWS EC2

Tech Stack

Java 17

Spring Boot

Thymeleaf

Bootstrap 5

iTextPDF

Docker

AWS EC2

Run Locally

Build the application:

mvn clean package


Run the application:

java -jar target/IkramixNotesApp-0.0.1-SNAPSHOT.jar


Open the app:

http://localhost:8080

Run with Docker

Build the Docker image:

docker build -t ikramix-notes .


Run the container:

docker run -d -p 8080:8080 ikramix-notes

Deploy on AWS EC2

Install Java 17
Amazon Linux:

sudo yum install java-17-amazon-corretto -y


Ubuntu:

sudo apt install openjdk-17-jdk -y


Upload and run the JAR:

java -jar IkramixNotesApp-0.0.1-SNAPSHOT.jar


Optional production steps:

Setup systemd for automatic startup

Configure Nginx reverse proxy on port 80

Add HTTPS using Let’s Encrypt

Project Structure
IkramixNotesApp/
 ├── Dockerfile
 ├── README.md
 ├── pom.xml
 ├── notes.txt
 └── src/
     └── main/
         ├── java/com/ikramix/notes/
         │   ├── IkramixNotesAppApplication.java
         │   ├── controller/NotesController.java
         │   ├── model/Note.java
         │   └── service/NotesService.java
         └── resources/
             ├── application.properties
             └── templates/
                 ├── index.html
                 └── login.html

License

This project is intended for personal learning and portfolio use.

