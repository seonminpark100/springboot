package com.edu.springboot.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
		if (memberDTO.getRegidate() == null) {
			memberDTO.setRegidate(LocalDateTime.now());
		}

		int result = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into member (id,pass,name,regidate) values(?,?,?,?)";
				
				PreparedStatement psmt = con.prepareStatement(sql);
				
				psmt.setString(1, memberDTO.getId());
				psmt.setString(2, memberDTO.getPass());
				psmt.setString(3, memberDTO.getName());
				psmt.setObject(4, memberDTO.getRegidate());
				return psmt;
			}
		});
		return result;
	}

	@Override
	public MemberDTO selectOne(MemberDTO memberDTO) {
		String sql = "select id, pass, name, regidate from member where id=?";
		try {
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class),
					memberDTO.getId());
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No member found with ID: " + memberDTO.getId());
			return null;
		}
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

	@Override
	public List<MemberDTO> searchMembers(MemberDTO memberDTO) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT id, pass, name, regidate FROM member");
		List<Object> params = new ArrayList<>(); // PreparedStatement에 바인딩할 파라미터들을 저장할 리스트

		String searchField = memberDTO.getSearchField();
		String searchKeyword = memberDTO.getSearchKeyword();

		// 검색어가 유효할 경우에만 WHERE 절 추가
		if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
			sqlBuilder.append(" WHERE ");

			// 검색 필드에 따라 조건 동적 추가
			switch (searchField) {
			case "id":
				sqlBuilder.append("id LIKE ?");
				params.add("%" + searchKeyword + "%");
				break;
			case "name":
				sqlBuilder.append("name LIKE ?");
				params.add("%" + searchKeyword + "%");
				break;
			
			default:
				// searchField가 유효하지 않거나 명시되지 않은 경우, id와 name 모두 검색
				sqlBuilder.append("id LIKE ? OR name LIKE ?");
				params.add("%" + searchKeyword + "%");
				params.add("%" + searchKeyword + "%");
				break;
			}
		}

		// 결과 정렬 (선택 사항)
		sqlBuilder.append(" ORDER BY regidate DESC");

		// 최종 SQL 쿼리 실행. params.toArray()는 List를 Object[]로 변환하여 PreparedStatement에 바인딩
		return jdbcTemplate.query(sqlBuilder.toString(), new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class),
				params.toArray());
	}
}

