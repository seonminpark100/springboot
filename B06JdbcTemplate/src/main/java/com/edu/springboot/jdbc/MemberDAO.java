package com.edu.springboot.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements IMemberService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MemberDTO> select() {
		String sql = "select * from member order by regidate desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}

	@Override
	public int insert(MemberDTO memberDTO) {
		int result = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into member (id,pass,name) values(?,?,?)";
				
				PreparedStatement psmt = con.prepareStatement(sql);
				
				psmt.setString(1, memberDTO.getId());
				psmt.setString(2, memberDTO.getPass());
				psmt.setString(3, memberDTO.getName());
				return psmt;
			}
		});
		return result;
	}

	@Override
	public MemberDTO selectOne(MemberDTO memberDTO) {
		String sql = "select * from member where id=?";
		memberDTO = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class), new Object[] {memberDTO.getId()});
		
		return memberDTO;
	}

	@Override
	public int update(MemberDTO memberDTO) {
		String sql = "update member set pass=?, name=? where id=?";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, memberDTO.getPass());
				ps.setString(2, memberDTO.getName());
				ps.setString(3, memberDTO.getId());
			}
		});
		return result;
	}
	@Override
	public int delete(MemberDTO memberDTO) {
		String sql = "Delete FROM member WHERE id=?";
		int result = jdbcTemplate.update(sql, new Object[] {memberDTO.getId()});
		return result;
	}
}
