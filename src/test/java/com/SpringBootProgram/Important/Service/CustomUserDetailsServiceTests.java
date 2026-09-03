package com.SpringBootProgram.Important.Service;

import com.SpringBootProgram.Important.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoBeans;

import  static  org.mockito.Mockito.*;

//@ActiveProfiles("dev")  iska matlab hai dev hai to dev wali chalengi nhi to prod vali chlengi
public class CustomUserDetailsServiceTests {
    //like in custom user detail service there are lot of loading time
    //to load username which is unnecessary for testing phase
    //like its components setRole setPassword etc we need to test
    //we mock customuserdetailservice so we dont get loading time
    //we use an app mockito for this purpose
   @InjectMocks//we mock dependency inside it
    private  CustomUserDetailServiceImpl  customUserDetailService;
   //instead of autowire we use this to inject the mocked dependencies
    //injectmocks create its instance automatically

   @Mock//since we need to associate with spring which use mean  so we use this instead of Mockito
   //if Autowired then MockitoBean else mock
   private UserRepository userRepository;

   @BeforeEach
    void setUp(){
       MockitoAnnotations.initMocks(this);
       //above means initialize all mocks in this class
   }



//
//   @Test           // in this test builder doesnt work as lombok not working in our project
//    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn
//
//        ;
//                //when ram then only return  or can use ArgumentMatchers.toString()
//                //now the actual repository not run ionstead mock runs
//       UserDetails user= customUserDetailService.loadUserByUsername("ram");
  //  Assertions.assertNotNull(user);
//    }
}
