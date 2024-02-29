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
