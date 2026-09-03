package com.SpringBootProgram.Important.journalApp;

import com.SpringBootProgram.Important.Entity.User;
import com.SpringBootProgram.Important.Repository.UserRepository;
import com.SpringBootProgram.Important.Service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEntryController {

    @Autowired
    private UserEntryService userEntryService;
    @Autowired
    private UserRepository userRepository;





    //jis user name aur password se api ko hit krenge wo idhar aa jayegi
    //it will come from security context holder
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){//this user comes from customUserdetailservice
        //meaning its been authenticated bcz it not coming from here
       Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
       //the above statement runs only if it got authenticated
        String userName=authentication.getName();

      User userInDb=userEntryService.findByUserName(user.getUserName());

          userInDb.setUserName(user.getUserName());
          userInDb.setPassword(user.getPassword());
          userEntryService.SaveNewUser(userInDb);//here encoded one only

      return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping

    public ResponseEntity<?> createUser(@RequestBody User user) {
        userEntryService.SaveNewUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delteByUserIdequestBody (){//this user comes from customUserdetailservice
        //meaning its been authenticated bcz it not coming from here
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        //the above statement runs only if it got authenticated
       userRepository.deleteByUserName(authentication.getName());//method of delete made in repository
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        return new ResponseEntity<>("Hi" + authentication.getName(),HttpStatus.OK);
    }



}


