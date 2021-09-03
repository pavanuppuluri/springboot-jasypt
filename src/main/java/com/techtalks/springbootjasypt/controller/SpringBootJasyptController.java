package com.techtalks.springbootjasypt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootJasyptController {

    @Value("${db.unsecurepassword}")
    String unsecurepassword;

    @Value("${db.securepassword}")
    String securepassword;


    @GetMapping("/config/unsecuredpassword")
    public String getUnsecuredPassword()
    {
        return "Unsecured password = "+unsecurepassword;
    }

    @GetMapping("/config/securedpassword")
    public String getSecuredPassword()
    {
        return "Secured password = "+securepassword;
    }
}
