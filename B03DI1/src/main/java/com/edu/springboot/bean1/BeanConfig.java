package com.edu.springboot.bean1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	@Bean
	public Person person1() {
		Person person = new Person();
		person.setName("카리나");
		person.setAge(26);
		person.setNotebook(new Notebook("레노버"));
		
		return person;
	}
	
	@Bean(name="person2")
	public Person ptemp() {
		Person person = new Person("알파고", 20, new Notebook("엘지그램"));
		return person;
	}
}
