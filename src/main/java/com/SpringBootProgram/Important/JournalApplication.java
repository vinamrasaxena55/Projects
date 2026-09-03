package com.SpringBootProgram.Important;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JournalApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(JournalApplication.class, args);
		ConfigurableEnvironment environment= context.getEnvironment();
		System.out.println(environment.getActiveProfiles());
		//getactive profile is array,bcz can give multiple profiles

	}

	@Bean//MongoDatabaseFactory helps to form connection b/w database
	public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);//iske bina no transaction
	}

}
//Platform Transactional Manager implements Mongo transaction Manager