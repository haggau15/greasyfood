How to run project

Springboot project:
Running mvn install should get all dependencies. Java 17 is necessary for it to work.
Make a .env file in resources and add this: DB="mongodb+srv://123:123@menu.hmcvdtv.mongodb.net/" to it

I started it by running the class DemoprojectApplication

React project: 
Run npm and install and then run the project by clicking the run script in package.json

python-filter:
Use python 3.6.0. Run pip install flask-cors. The rest should suggest being installed automatically. If not, pip install -U Flask.
I start it by clicking run on the filter.py file

python-datacollector (called python project):
A queue called queue needs to be added in rabbitmq which is can be done at http://localhost:15672/. To be able to access rabbitmq in the browser, the command "rabbitmq-plugins enable rabbitmq_management" needs to be run in the console. Only receive.py is run for this project so pip install pika needs to be run for that file.
Python 3.12.1 was used for this project.

Overview of the project:
The point of the project is to not only be able to find fast food places from the ones that get a high score by users but also see what's at the other end, and from what people say in the reviews.
It consists of 4 services, one in react, one in springboot and two in python.

The springboot project acts a central untit. It fetches data from the db which the frontend can get. 
The asnynchronous call the frontend can make for more data to the datacollector script (receive.py) goes via an endpoint in this project.

The react project is pure frontend. All data and it displays is get from the springboot project and then can be sorted by the python-filter project. It's one page where the content changes using state. 
The content from the db is placed in in a variable (json) that is never changed but when one of the sorting buttons is pressed, its data is sent to the sorting service and the return value updates the state of a displayobject (places). The user can send as many requests as they want to the datacollector but it just prints out the message in receive.py

Python-filter recevies data and can currently sort them in 4 different ways. Both ascending descending by google maps score by users, and the number of negative words in 5 of its reviews.

python-datacollector has a script (comments.py) that fed the db with its data. Due to to token needed for these calls costing money if used too much, its not available to be run but receive.py can be called from the frontend thus letting the user asking for data from a specific location needs only a few lines of additional code. Right now it receives the request and prints it out in the console.
Comments.py makes a call to the google maps api to get all resturants with takeaway as an option in a radius around given coordinates. 



User stories:

From the arbeidskrav, only one is implemented
-I want to be able to find places with greasy food when I’m, out drinking
But I did implement this
-I want to be able to sort the resturants in various ways depending on what I want
