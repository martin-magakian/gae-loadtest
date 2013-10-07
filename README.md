Google App Engine sample

How to use
=======

1- Run locally
------

Compile the project:

	$ mvn clean install

Run locally

	$ mvn appengine:devserver

Open your browser to https://localhost:8800
<br />

(Optional) Create project to import in Eclipse:

	$ mvn eclipse:clean eclipse:eclipse


2- Push to production
------
* Login and [create a new app](https://appengine.google.com/start/createapp) on App Engine.

* Edit your "path" to add App Engine tools for the command line.
On Mac OS X simply edit ~/.profile and add:

	PATH=$PATH:~/.m2/repository/com/google/appengine/appengine-java-sdk/1.8.2/appengine-java-sdk/appengine-java-sdk-1.8.2/bin

Double check the path to AppEngine-sdk bin exist.
If it doesn't exist you might have forgoten to run the previous command (see above)

	$ mvn appengine:devserver

* Push to production using
	
	appcfg.sh update target/gaeloadtest-1.0-SNAPSHOT/


3- Try
------

Simple connect to http://YOUR-APP-NAME.appspot.com/LoadTest to run the app.