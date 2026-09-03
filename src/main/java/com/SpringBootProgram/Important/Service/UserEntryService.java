package com.SpringBootProgram.Important.Service;

import com.SpringBootProgram.Important.Entity.User;
import com.SpringBootProgram.Important.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserEntryService {
    @Autowired
    private UserRepository userEntryRepository;//field of type JournalEntryRepository
    //injecting JournalEntryRepository in JournalEntryService class

    @Autowired
    private Environment environment;

    @PostConstruct//for checking if connected to database
    public void checkMongoUri() {
        System.out.println("Mongo URI = " +
                environment.getProperty("spring.data.mongodb.uri"));

        System.out.println("User Count = " +
                userEntryRepository.count());
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void checkDb() {
        System.out.println("Database = " + mongoTemplate.getDb().getName());
        System.out.println("Collections = " + mongoTemplate.getCollectionNames());

        System.out.println("URI = " + environment.getProperty("spring.data.mongodb.uri"));
        System.out.println("DB Property = " + environment.getProperty("spring.data.mongodb.database"));
    }

    // existing methods...
    private  static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    //creating instance of logger
    //slf4j
    private static final Logger logger= LoggerFactory.getLogger(UserEntryService.class);//jis class ke andar use kr rhe hain uski ka naam dein
    //the above statement means only 1 instance possible and cant be altered
 //instead of this we can import slf4j of lombok and instead of logger its used using log



    public boolean SaveNewUser(User user) {
        try {//gives exception when try to save same user
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userEntryRepository.save(user);
            return true;
        } catch (Exception e) {
            logger.info("ooo");
            logger.warn("aah");
            logger.error("Error occurred for {} :",user.getUserName(),e);
            logger.debug("kyyaaa");
            logger.trace("fuuuuu");

            return false;
        }

    }//agar encode krna hai to yeh nhi to neeche vala
    public  void SaveUser(User user){
        userEntryRepository.save(user);
    }
    public  void SaveAdmin(User user){

        user.setPassword( passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userEntryRepository.save(user);
    }

    public List<User> getAll() {

        return userEntryRepository.findAll();
        //we havent written anything inside repo but mongoRepo has them by default
    }

    public Optional<User> findById(ObjectId Id) {
        return userEntryRepository.findById(Id);//retrurns optional
    }

    public void deleteById(ObjectId Id) {
        userEntryRepository.deleteById(Id);
    }
    public User findByUserName(String userName){
        return userEntryRepository.findByUserName(userName);
    }
}