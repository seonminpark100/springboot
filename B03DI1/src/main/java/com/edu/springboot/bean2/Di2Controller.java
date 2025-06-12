package com.edu.springboot.bean2;

import com.edu.springboot.bean1.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Di2Controller {

    private final Person person1;
	@Autowired
	Student student;
	
	@Autowired
	@Qualifier("macbook")
	Computer computer;

    Di2Controller(Person person1) {
        this.person1 = person1;
    }
	
	@RequestMapping("/di2")
	@ResponseBody
	public String home() {
		System.out.println(student);
		return "Dependency Injection2 (의존주입2)";
	}
}
