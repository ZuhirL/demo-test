# demo-test

DOCUMENTATION

In zip you can find a .sql file where there is the database structure.

You can run the project as a spring boot application (DemoApplication class) or for testing APIs (JUnitControllerTest class).
APIs are two:
/health or /health/ will check if the application is running
/demo/message where you can send the stake of a user. After check the sent body, it will be saved in db. The json body to send is: { “accountId”: accountId, “stake”: stake}. You can find the body in Message class.

Then there is a websocket controller at (StakeController class) and his configuration (WebSocketConfig).
When you run the application at /swagger-ui.html you can find the swagger with APIs, while at /index.html you can find a web page to test API.
In the webpage you need to click on connect to retrieve connection with websocket, it used for receive messages of notification.
Under it, you can insert userId, his stake and send button. This will call the api and insert data in db, if there are errors will appear an alert at top of page.
When stake of an user is more than 100 in the last hour, in stockInfo will appear a message with userId, total stake in last hour and timestamp of the event, these data will be saved in db.
