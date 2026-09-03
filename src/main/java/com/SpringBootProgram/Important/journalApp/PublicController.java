package com.SpringBootProgram.Important.journalApp;


import com.SpringBootProgram.Important.Entity.User;
import com.SpringBootProgram.Important.Service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/public")//this is un authenticated controller
public class PublicController {
    @Autowired
    private UserEntryService userEntryService;

    @PostMapping("/create-user")
    public  boolean createUser(@RequestBody User user){
        userEntryService.SaveNewUser(user);
        return  true;
    }
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/db-check")
    public String check() {
        return mongoTemplate.getDb().getName();
    }

    @Autowired
    private Environment env;
    @GetMapping("/mongo-props")
    public String props() {
        return "uri=" + env.getProperty("spring.data.mongodb.uri")
                + "\ndatabase=" + env.getProperty("spring.data.mongodb.database");
    }
    @GetMapping("/mongo-info")
    public String mongoInfo() {
        return mongoTemplate.getDb().toString();
    }
    @GetMapping("/mongo-details")
    public String mongoDetails() {
        return "DB=" + mongoTemplate.getDb().getName()
                + "\nCollection=" + mongoTemplate.getCollectionName(com.SpringBootProgram.Important.Entity.User.class);
    }
    @GetMapping("/profiles")
    public String profiles() {
        return Arrays.toString(env.getActiveProfiles());
    }
    @GetMapping("/mongo-debug")
    public String mongoDebug() {
        return "db=" + mongoTemplate.getDb().getName()
                + "\nuri=" + env.getProperty("spring.data.mongodb.uri")
                + "\ndatabase=" + env.getProperty("spring.data.mongodb.database");
    }
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @GetMapping("/mongo-uri")
    public String mongoUri() {
        return mongoUri;
    }

}
