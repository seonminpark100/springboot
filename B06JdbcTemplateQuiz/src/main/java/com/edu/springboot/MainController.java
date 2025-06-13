package com.edu.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.springboot.jdbc.IMemberService;
import com.edu.springboot.jdbc.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
		
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@Autowired
	IMemberService dao;
	
	@RequestMapping("/list.do")
	public String member2(Model model, @RequestParam(value = "searchField", required = false) String searchField,
			@RequestParam(value = "searchKeyword", required = false) String searchKeyword) {
		List<MemberDTO> memberList;

		if (searchKeyword != null && !searchKeyword.trim().isEmpty()
				|| (searchField != null && !searchField.trim().isEmpty())) {
			MemberDTO searchDTO = new MemberDTO();
			searchDTO.setSearchField(searchField);
			searchDTO.setSearchKeyword(searchKeyword);
			memberList = dao.searchMembers(searchDTO);
		} else {
			memberList = dao.select();
		}

		model.addAttribute("memberList", memberList);
		return "list";
	}
//	@RequestMapping(value = "/regist.do", method = RequestMethod.GET)
	@GetMapping("/regist.do")
	public String member1() {
		return "regist";
	}
//	@RequestMapping(value="/regist.do", method=RequestMethod.POST)
	@PostMapping("/regist.do")
	public String member6(MemberDTO memberDTO) {
		int result = dao.insert(memberDTO);
		if (result==1) System.out.println("입력되었습니다");
		return "redirect:list.do";
	}
//	@RequestMapping(value = "/edit.do", method = RequestMethod.GET)
	@GetMapping("/edit.do")
	public String member3(MemberDTO memberDTO, Model model) {
		memberDTO = dao.selectOne(memberDTO);
		model.addAttribute("dto", memberDTO);
		return "edit";
	}
//	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@PostMapping("edit.do")
	public String member7(MemberDTO memberDTO) {
		int result = dao.update(memberDTO);
		if(result==1) System.out.println("수정되었습니다.");
		return "redirect:list.do";
	}
	@RequestMapping("/delete.do")
	public String member4(MemberDTO memberDTO) {
		int result = dao.delete(memberDTO);
		if(result==1) System.out.println("삭제되었습니다.");
		return "redirect:list.do";
	}
}
