Student Result Fetching System

The Student Result Fetching System is a web-based application designed to allow students to retrieve their academic results from a database. The system ensures secure access to student records and provides an efficient way to display results using a simple and user-friendly interface.

Installation & Setup Prerequisites Ensure you have the following installed:

  1. Java JDK (Version 8 or later)

  2. Download Apache tomcat9 from the link:
     https://tomcat.apache.org/download-90.cgi

     ![F1](https://github.com/user-attachments/assets/f90112be-7841-451c-999f-7e0451fe3746)


  3. After downloading you have to change only “server port” and “connector port”

• follow the steps to change port number’s tomcat9 ---> conf ---> service.xml ---> server port = "8000" & connector port = "9090"

![F2](https://github.com/user-attachments/assets/694d021d-83f8-4fba-a66a-fb234ea36379)


![F3](https://github.com/user-attachments/assets/34f30d84-3115-4f7c-8fa2-455be819967d)


  4. Add MySQL jar connecter 8.3.0 file in tomcat9/lib folder.

• Download MySQL jar connector file from the link:
  https://downloads.mysql.com/archives/c-j/

![F4](https://github.com/user-attachments/assets/f50d0335-a72a-4426-8817-03c983a4f9ff)


• Setup MySQL Database
Open MySQL Workbench and create a database:
  CREATE DATABASE studentresult;

![F5](https://github.com/user-attachments/assets/3d7e094d-e645-410d-a2dc-bcc959ed4693)

• User Table (user):
This table stores student login credentials and basic information.
CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

![F6](https://github.com/user-attachments/assets/14d69036-67ff-4e2c-a24c-6cf00e3d6e72)

• Result Table (result):
Stores student results, including marks for three subjects and overall status.
CREATE TABLE result (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    subject1 INT NOT NULL,
    subject2 INT NOT NULL,
    subject3 INT NOT NULL,
    status VARCHAR(20) NOT NULL
);

Import all files to any of the IDE. For example, Eclipse • Open Eclipse IDE. • Select File → Import → Existing Projects into Workspace. • Browse and select the project directory. • Click Finish to import.

Run the Project • Right-click on the project. • Select Run on Server → Choose Apache Tomcat 9. • Start the server.

Access the Application • Once the server is running, open any web browser and enter the following URL: Endpoint :
     http://localhost:9090/StudentResult/Signup.html
Enter login credentials and fetch student results.

Features:
* User authentication (Login & Signup)
* Fetch student results from the database
* Uses Apache Tomcat as the web server
* Simple and easy-to-use interface

Screenshots:The following images demonstrate the various pages and functionalities to fetch student result.

-> Signup Page:
Users enter their information to register.

![FI1](https://github.com/user-attachments/assets/fe8e4ae5-edba-46e3-8204-7567a00bef8a)


-> Login Page:
Users enter their credentials to log in.

![FI2](https://github.com/user-attachments/assets/23231a54-d760-4cbd-8372-d3c92284bd9f)

-> Fetch Result Page:
Enter the Student ID to fetch the result.

![FI3](https://github.com/user-attachments/assets/70167865-d983-4b8f-bd30-6e080e6f0f15)

-> Display Result Page:
The student's marks and status are displayed.

![FI4](https://github.com/user-attachments/assets/e37423ce-b2dc-470b-bc4e-38dd0caf211a)
