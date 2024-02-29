## Links to all repos
https://github.com/haggau15/greasyfood/

https://github.com/haggau15/react-frontend

https://github.com/haggau15/python-datacollector/tree/main

https://github.com/haggau15/filter


## How to run the project:

### Springboot project:
Java 17 is necessary for it to work.
````
1. in resources, Make a .env file and add DB="mongodb+srv://123:123@menu.hmcvdtv.mongodb.net/" 
2. mvn install 
````
Run project from DemoprojectApplication.java

### React project: 
Run order:
````
1. npm install 
2. in package.json manually run start script
````
### python-filter:
Use python 3.6.0. Run `pip install flask-cors.` The rest should suggest being installed automatically. If not, `pip install -U Flask`.
I start it by clicking run on the `filter.py ` file

python-datacollector (called python project):
A queue called queue needs to be added in rabbitmq which is can be done at `http://localhost:15672/`. 
To be able to access rabbitmq in the browser, the command `rabbitmq-plugins enable rabbitmq_management` needs to be run in the console. Only `receive.py` is run for this project so `pip install pika` needs to be run for that file.
Python 3.12.1 was used for this project.
And rabbitmq needs to be running for this script to work.

## Setup order
It should work to start these in any order but the safest is ;
````
1. springboot 
2. receive.py 
3. python.filter 
4. react.
````





## Overview of the project:
The point of the project is to not only be able to find fast food places from the ones that get a high score by users but also see what's at the other end, and from what people say in the reviews.
It consists of 4 services, one in react, one in springboot and two in python.

The springboot project acts a central untit. It fetches data from the db which the frontend can get. 
The asnynchronous call the frontend can make for more data to the datacollector script `receive.py` goes via an endpoint in this project.

The react project is pure frontend. All data and it displays is get from the springboot project and then can be sorted by the python-filter project. It's one page where the content changes using state. 
The content from the db is placed in in a variable (json) that is never changed but when one of the sorting buttons is pressed, its data is sent to the sorting service and the return value updates the state of a displayobject (places). The user can send as many requests as they want to the datacollector but it just prints out the message in `receive.py`

Python-filter recevies data and can currently sort them in 4 different ways. Both ascending descending by google maps score by users, and the number of negative words in 5 of its reviews.

python-datacollector has a script `comments.py` that fed the db with its data. Due to to token needed for these calls costing money if used too much, its not available to be run but `receive.py` can be called from the frontend thus letting the user asking for data from a specific location needs only a few lines of additional code. Right now it receives the request and prints it out in the console.
`comments.py` makes a call to the google maps api to get all resturants with takeaway as an option in a radius around given coordinates. 



## User stories:

- I want to be able to find places with bad food when I’m, out drinking

- I want to be able to sort the resturants in various ways depending on what I want

- I want to be able to send a request for more locations covered






![Class diagram](https://github.com/haggau15/greasyfood/assets/18140390/29420148-4e79-44e8-97fe-7be342ba3ef5)

During the making of the project, I simply fell short on time and a lot had to be cut. I didn't have too may exectations going in but I was surprised at the level of attention to detail that was necessary. Most  of the time spent was getting the basics of what I planned up and running. Things I assumed wasn't too time consuming to do kept giving me surprises. For instance, figuring out I need CORS to make other programs be able to connect to it's endpoints, needing to run a script before being able to access rabbitmq in the browser. Figuring out what versions I needed for the libriaries I used  was also a big one. Getting eveything to communicate together was a new experience to me. Working with an existing and working API is a lot easier than making them all yourself from scratch.

I don't think I've deviated from the core architechture in the arbeidskrav but I probably underestimated at the time how many services I would need to implement everything I wanted to if I were to follow microservice principles.

