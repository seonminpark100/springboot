package com.edu.springboot.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface IMemberService {
	public List<MemberDTO> select();
	public int insert(MemberDTO memberDTO);
	public MemberDTO selectOne(MemberDTO memberDTO);
	public int update(MemberDTO memberDTO);
	public int delete(MemberDTO memberDTO);

    
    public List<MemberDTO> searchMembers(MemberDTO memberDTO);
}
