To-do List

The application is developed using Spring MVC, to incorporate a web interface. The views are implemented using JSP. This was used as JSP provides an easy bridge between front-end and back-end (Java), using JSTL tags.
The database used is an in-memory database using HSQL, i.e. there is a schema and a SQL file which run at application start-up, loading the values into the database. These files are run at every new start-up, i.e. The previously stored tables are dropped and new tables are created each time the project restarts, so at the start of the project we always have the same test dataset. The user details are stored using HttpSession object, which helps in maintaining the user credentials. This means that the user is logged-in even if the user changes tabs on the browser. 

![alt text](https://raw.githubusercontent.com/adarshbhat2811/TodoList/master/Capture.JPG)

The above diagram shows the flow of control and the components of the application.
The views are made up of JSP files. The controller is responsible for assessing the request and forward it to the corresponding service. The business logic resides in the service layer. The data access layer is used to communicate between the application and the database. 
The design patter implemented, as shown in the above figure is MVC design pattern. 

The application in its current state is very simple. Given more time, some of the other things that can be added to it are: 

•	Implementing JUnit test cases, so that the code is tested before deployment. 

•	Using a persistent database such as MySQL or Oracle.

•	Improving the UI, by adding validations for input fields. 

•	Improving the security of the application by using Spring security. 
 
