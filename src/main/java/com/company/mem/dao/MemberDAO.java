package com.company.mem.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.mem.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public int mbJoin(MemberDTO member) {
		System.out.println("[3] service >> DAO : member = " + member);
		
	// 실행할 sql문 타입, Namespace값, id값을 설정하고 정보와 함께 mapper로 넘기기
	// mapper 에는 총 4개의 데이터가 전달
		
		return sql.insert("Member.mbJoin", member);
	// return sql.타입("Namespace.id", data);
		
	// return sql.타입("Namespace.id", data);로 db에서 실행된 값이
	// 성공 시 '1 행이 삽입되었습니다' 여기서 생긴 1행의 1 값을 result에 담을 것.
	// 실패 시 '0 행이 삽입되었습니다'
	// 즉, db에 데이터 삽입 시 result = 1이 됨. 	
		
	}

	public List<MemberDTO> mList() {
		System.out.println("[3] service >> dto");
		return sql.selectList("Member.mList");
	//  return sql.sql문타입("nanespace값.ld값");
	}

	public MemberDTO mView(String mbId) {
		System.out.println("[3] service >> DAO");
		
		return sql.selectOne("Member.mView", mbId);
	}

	public int mModify(MemberDTO member) {
		return sql.update("Member.mModify", member);
	
	}
	
	public int mDelete(String mbId) {
		return sql.delete("Member.mDelete", mbId);
		
	}

	public String mLogin(MemberDTO member) {
		return sql.selectOne("Member.mLogin", member);
	}
	
	
	

}
