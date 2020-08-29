# CyberTechElite Documentation
This repository contains the assets required to build & run our project and know more about us. We're glad that you want us to contribute!

## SOS GENERATING WEBSITE
This website is designed to serve our people at times of emergency. It features some of the advance features that we've added to levitate systems approach, these include a person in need can send SOS or a voice message directly to the a particular email address, a phone number and to the control office (government permissions required). Through this the user even in a panic state can find help eaisly by direct contact with the control officer so to trace their location and send help immediately. It also features voice recording, picture and video capturing, if the user sees a mishap they can send images and videos, this lets the government officials have knowledge about it so that immediate action can be taken upon. The images and voice recordings regarding users important information are stored separately. This serves as a Platform as well to resolve issues regarding the help people need without relaying on any social media platforms, this strengthens the police and public relations.

## ABOUT THE TEAM 
Our goal is to promote government services with redefined efficiency, upgradation in system's approach to provide maximum quality output thereby is adaptable to the system and the users, without using any external resources. Our Team’s sole Purpose is to render enhanced and versatile solutions for common problems that eases ones life and raises our standard of living with amending strategies. Our Vision lies in working for Smart India, to build our nation with efficient and logical thinking for the upcoming decade, marching ahead we’ll lead the Developed nations bringing Pride to our Motherland.

## TECH STACK USED

Django Stack: Django, python and MySQL as Database

## INSTALLATION
1. Install python for respective OS: [Click here]( https://www.python.org/downloads/)

2. Install pip for respective OS: [Click here]( https://www.makeuseof.com/tag/install-pip-for-python/)

3. Install Django for respective OS: [Click here](https://www.thecrazyprogrammer.com/2018/09/how-to-install-django.html)

## DO CHANGES IN CODE

1. Navigate to project folder where settings.py present and do following changes in code (present at the end of settings.py file)

   *Enter your email and password of gmail account from which mail has to be send*
   ```
   EMAIL_HOST_USER = 'your_email@gmail.com'
   EMAIL_HOST_PASSWORD = 'your_password'
   ```
   
   Note : 
   
   a.) Allow EMAIL_HOST_USER to allow *less secure apps* to send mail(gmail account), since this website is on localhost now. You won't        have to allow  *less secure apps* to access EMAIL_HOST_USER once we have SSL certificate enabled for this website. 
   
   b.) Since we're running website on local server therefore we haven't enabled SSL certificate for this website yet.


## STARTING LOCAL DEVELOPMENT SERVER

1. Open command prompt

2. Navigate to project folder where manage.py present 

3. Run following command 

  ```
   python manage.py runserver  

  ```

## RUN THE WEBSITE AS FOLLOWS

1. Open a browser.

2. Search for: [127.0.0.1:8000/enterphone](127.0.0.1:8000/enterphone)

*You now have website running on your browser*

## BENEFITS:-

1. Usability Iterative approach to design Design patterns and usability testing (User Experience Working Group)

2. Mobile friendly responsive design Adapts to different screen sizes and device capabilities Touchscreen support Optimized for performance Building support for device-based mobile applications

3. Reduces costs Drives down research and development costs Avoids duplication of effort Produces better quality results

4. Collaborative approach Encourages the free flow of ideas, dialogue and innovation, including the sharing of challenges and ideas External contributions are invited Code submissions Patternmaking Problems and Suggestions Documentation Reviews Multi-level review process for contributions to ensure code integrity (combination of automated and manual reviews)
