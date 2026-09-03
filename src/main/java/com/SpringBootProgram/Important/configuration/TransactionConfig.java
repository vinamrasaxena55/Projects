//package com.SpringBootProgram.Important.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.MongoTransactionManager;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class TransactionConfig {
//
//    @Bean//MongoDatabaseFactory helps to form connection b/w database
//    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
//        return new MongoTransactionManager(dbFactory);//iske bina no transaction
//    }
//}
