package com.SpringBootProgram.Important.journalApp;


import com.SpringBootProgram.Important.Entity.User;
import com.SpringBootProgram.Important.Service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")//admin pe auth hai
public class AdminController {

    @Autowired
    private UserEntryService userEntryService;

     @GetMapping("/all-users")//sare users aa jayenge
    public ResponseEntity<?> getAllUsers(){
      List<User> all= userEntryService.getAll();//from repository
        if(all !=null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);//404
    }
    @PostMapping("/create-admin-user")
    public  void createUser(@RequestBody User user){
         userEntryService.SaveAdmin(user);
    }
    //ek manually postman mein admin bnana padega kyunki auth hai to baki controller not accessible
}
