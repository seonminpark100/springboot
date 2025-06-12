package com.edu.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BoardValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		System.out.println("supports() 호출됨");
		return BoardDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BoardDTO boardDTO = (BoardDTO)target;
		
		String userid = boardDTO.getUserid();
		if (userid==null || userid.trim().isEmpty()) {
			System.out.println("아이디를 입력해주세요");
			errors.rejectValue("userid", "idError", "아이디 검증 실패");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "titleError", "제목 검증 실패");
		
		boolean contentValidate = myEmptyOrWhitespace(boardDTO.getContent());
		if (contentValidate==false) {
			System.out.println("내용을 입력해주세요");
			errors.rejectValue("content", "contentError", "내용 검증 실패");
		}
	}

	public boolean myEmptyOrWhitespace(String value) {
		if (value==null || value.trim().length()==0) {
			return false;
		} else {
			return true;
		}
	}		
}
