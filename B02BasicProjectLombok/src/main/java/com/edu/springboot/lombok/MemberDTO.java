package com.edu.springboot.lombok;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Setter;
//import lombok.Getter;

@Data
//@AllArgsConstructor
//@Getter
//@Setter
public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String regidate;
}
