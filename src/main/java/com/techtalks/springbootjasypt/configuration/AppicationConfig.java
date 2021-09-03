package com.techtalks.springbootjasypt.configuration;


import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
public class AppicationConfig {

    @Value("${db.unsecurepassword}")
    String unsecurepassword;

    @Value("${db.securepassword}")
    String securepassword;
}
