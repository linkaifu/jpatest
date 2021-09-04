package com.jpa.test.jpatest.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@Api(value = "user",description = "username", tags = "sex")
public class UserController {
    @GetMapping("/createUser/{username}/{sex}")
    public String createUser(@PathVariable("username") String username, @PathVariable("sex") String sex){
        return username + "==" + sex;
    }
}
