package com.SpringBootProgram.Important.Service;

import com.SpringBootProgram.Important.Entity.User;
import com.SpringBootProgram.Important.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // hum log user ko load kr rhe hai through loadUserByUsername
        User user = userRepository.findByUserName(username); // finding username

        // now below making UserDetails
        if (user != null) {
            UserDetails userDetails= org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0]))//iski wajah se role based authentication, username se detail fetch krega
                    // we took list of roles converted it to array which has String datatype
                    .build();
            return  userDetails;
        }

        throw new UsernameNotFoundException(
                "User not found with username: " + username);//provided by spring security
    }
}