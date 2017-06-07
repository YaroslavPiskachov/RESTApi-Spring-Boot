package com.yaroslav;

import com.yaroslav.model.User;
import com.yaroslav.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(UserDao userDao) {
		return (args) -> {
			userDao.save(new User("Yaroslav","09582735782"));
			userDao.save(new User("Fedor","09346135782"));
			userDao.save(new User("Nastya","06781035782"));
			userDao.save(new User("Alex","05082965782"));
		};
	}


}
