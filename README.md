Project Title:
Handling webview and javascript in android webview with google push notification.

Prerequisites

Node js
Android Studio and android device with Android Jelly Bean and higher and active internet connection.

Installing :
Web : 
Install following libraries

"body-parser": "^1.18.1",
"bootstrap": "^3.3.7",--for responsive UI
"express": "^4.16.2",
"jsonfile": "^4.0.0",--for handling json data
"node-gcm": "^0.14.9"--for android push notification

Android : 
Install following in app gradle

implementation 'com.google.firebase:firebase-messaging:11.8.0'-- for push notification
implementation 'com.squareup.retrofit2:retrofit:2.3.0' -- REST client for android
implementation 'com.squareup.retrofit2:converter-gson:2.3.0' -- parsing JSON data
Thought Process

Android - 
Webview loads the url.
Submit button clicked inside webview.
Javascript on web calls android function with input text.
Android calls push notification API with device id and text.
Push notification sent to Firebase.
Firebase FCM send it to the device.
Device receives notification and calls the javascript function.
Javascript function clears the input box.
Implementation

Web - 
a. Create a web page with one text input and one button.(under templates/home.html) b. Create an api that implements google push notification.(under routes/apiroutes)

Android - 
a. Create InstaceId servive that implements FirebaseInstanceIdService to get the deviceId. b. Create Message service that implements FirebaseMessagingService to build custom notification on push notification received. c. Include services in manifest file. d. Create one activity with webview and load your url. e. Create Web Interface so that javascript on your web can interact with your android function(WebInterface class).

Note:
you can host your api and web app on AWS and use the url(suggested) or you can use localhost(10.0.2.2)

Deployment: 
Run the apk file on any device and keep the web application running in the background.

Authors: 
Dhiraj Nayak

Acknowledgments: 
https://stackoverflow.com 
https://developer.android.com
