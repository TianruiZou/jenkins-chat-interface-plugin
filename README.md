Chat Interface Plugin
This is a Jenkins plugin developed as a sample project for Google Summer of Code (GSoC) 2025, specifically for the "AI-Powered Chatbot for Jenkins Documentation and Community Resources" project idea.

Features
Simple interactive chat interface

Access control based on Jenkins' built-in permission system

Responsive design suitable for various screen sizes

Development Requirements
Java 11

Maven 3.6+

Jenkins 2.440.1

Build Instructions
Clone the repository

Run:

bash
Copy
Edit
mvn clean package
The resulting .hpi file will be located at:
target/chat-interface-plugin.hpi

Installation Guide
Go to Manage Jenkins > Manage Plugins

Click on the Advanced tab

Under the Upload Plugin section, upload the generated .hpi file

Restart Jenkins to apply changes

How to Use
Once installed, you will find a "Chat Interface" option in the Jenkins main sidebar.
Click it to open a basic interactive chat screen integrated into the Jenkins UI.

License
MIT License
