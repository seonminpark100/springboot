package com.edu.springboot.jdbc;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private LocalDateTime regidate;
	
	private String searchField;
	private String searchKeyword;
}
