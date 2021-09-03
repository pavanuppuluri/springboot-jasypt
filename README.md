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







