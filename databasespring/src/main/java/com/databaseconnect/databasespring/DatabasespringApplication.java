package com.databaseconnect.databasespring;

import com.databaseconnect.databasespring.dao.userrepo;
import com.databaseconnect.databasespring.models.entry;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
public class DatabasespringApplication {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(DatabasespringApplication.class, args);
		userrepo userRepository=context.getBean(userrepo.class);
		//ENTRY OF USER
		entry user=new entry();
		user.setId(11);
		user.setFirstname("Shaurya");
		user.setLastname("Singh");
		user.setMobile("123456789");

		entry user2=new entry();
		user.setId(11);
		user.setFirstname("Shaurya");
		user.setLastname("Singh");
		user.setMobile("123456789");

		List<entry> users = List.of(user, user2);
		userRepository.saveAll(users);

		//UPDATE IN DATABASE
		Optional<entry> optional = userRepository.findById(11);
		entry entry = optional.get();
		user2.setMobile("666666666");

		//GET DATA
		Iterable<entry> all = userRepository.findAll();
		all.forEach(new Consumer<entry>() {
			@Override
			public void accept(entry t) {
				System.out.println(t);
			}
		});

		//DELETE A DATA
		Iterable<entry> all1 = userRepository.findAll();
		all1.forEach(entry1->System.out.println(user));
		userRepository.deleteAll(all1);

		userRepository.deleteById(11);
		System.out.println("delete");


		entry user1 = userRepository.save(user);
		System.out.println(user1);
	}

}
