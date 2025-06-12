package com.edu.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
		
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@Value("${test.key1}")
	private String testkey1;
	@Value("${test.key2}")
	private String testkey2;
	
	@RequestMapping("/link1")
	public String link1(Model model, @Value("${test.key3}") List<String> testkey3) {
		System.out.println("testkey1=" + testkey1);
		System.out.println("testkey2=" + testkey2);
		System.out.println("testkey3=" + testkey3);
		
		model.addAttribute("testkey1", testkey1);
		model.addAttribute("testkey2", testkey2);
		model.addAttribute("testkey3", testkey3);
		
		return "link1";
	}
	@Value("#{myprops['my.id']}")
	private String myId;
	@Value("#{myprops['my.pass']}")
	private String myPass;
	@Value("#{myprops['my.address']}")
	private String myAddress;
	@Value("#{myprops['my.age']}")
	private String myAge;
	
	@RequestMapping("/link2")
	public String link2(Model model) {
		System.out.println("myId=" + myId);
		System.out.println("myPass=" + myPass);
		System.out.println("myAddress=" + myAddress);
		System.out.println("myAge=" + myAge);
		
		model.addAttribute("myId", myId);
		model.addAttribute("myPass", myPass);
		model.addAttribute("myAddress", myAddress);
		model.addAttribute("myAge", myAge);
		
		return "link2";
	}
}
