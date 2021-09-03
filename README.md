**Securing configurations using Spring Boot Jasypt Integration**

In most of the spring boot application we do have sensitive information (Ex. database passwords) to store in application.properties
This information is required for the application to connect to database and for other validation purposes

In dev environment, we can simply store the password (though this is also not correct practice) like
spring.datasource.password=Welcome

But in UAT and Prod environments, we can't do that as it can be exploited.
Then what is the way to secure this sensitive information?

One way is to use Jasypt.
Using Jasypt we can encrypt the sensitive information like database passwords using Secret Key
and save that encrypted string in application.properties instead of in plain text format

This way we can secure the sensitive information

Now question is, how does the decryption happens in application?
For this, add a parameter when starting the Java program: -Djasypt.encryptor.password=secreyKey, so you won’t put the key in the code.

**Steps to test this application**

1. Clone this repo https://github.com/pavanuppuluri/springboot-jasypt.git
2. Pass JVM parameter as -Djasypt.encryptor.password=supersecretz (or) 
   If you are trying to run this application from IDE like Intellij then pass the Environment variable as JASYPT_ENCRYPTOR_PASSWORD=supersecretz
3. Now hit the endpoint http://localhost:8080/config/unsecuredpassword/ (It returns unsecured plain text password)
4. Now hit the endpoint http://localhost:8080/config/securedpassword/ (It returns secured password after decryption)

**Point to note**
In application.properties we stored below information for demo purpose

**db.unsecurepassword**=Welcome!23

**db.securepassword**=**ENC**(CBeERvkAJMT/DpvacDGCudKQNiEIfOC+)

Now anybody who has access to this properties file can find out the value of property db.unsecurepassword
But the value of db.securepassword is stored in encrypted format which can be decrypted using the Secret Key.
Point here is, we are **NOT storing the Secret Key in application.properties** file. We are passing it while launching the application.
This way we are making our sensitive information secure.

Happy Coding!!!




