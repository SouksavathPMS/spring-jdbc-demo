package com.kyedev.springJDBCDemo;

import com.kyedev.springJDBCDemo.model.Alien;
import com.kyedev.springJDBCDemo.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {
	public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

        Alien alien = context.getBean(Alien.class);
        alien.setId(111);
        alien.setName("Alien");
        alien.setTech("Java");

        AlienRepo alienRepo = (AlienRepo) context.getBean(AlienRepo.class);
        alienRepo.save(alien);

        System.out.println(alienRepo.findAll());
	}
}
