package edu.kh.comm.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPageDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 회원 정보 수정 DAO
	// 파람 : 파람맵, 리턴 result
	public int updateInfo(Map<String, Object> paramMap) {

		return sqlSession.update("myPageMapper.updateInfo", paramMap);
	}

	// 현재 로그인한 회원의 암호화된 비밀번호를 조회 DAO
	public String selectEncPw(int memberNo) {
		
		return sqlSession.selectOne("myPageMapper.selectEncPw", memberNo);
	}
	
	// 비밀번호 변경 DAO
	// 파람:파람맵 , 리턴 : 리절트
	public int changePw(Map<String, Object> paramMap) {
		
		return sqlSession.update("myPageMapper.changePw", paramMap);
	}

	
	// 회원 탈퇴 DAO
	// 파람:멤버넘버, 리턴:리절트
	public int secession(int memberNo) {
		
		return sqlSession.update("myPageMapper.secession", memberNo);
	}
	
	// 프로필 이미지 수정
	public int updateProfile(Map<String, Object> map) {
		return sqlSession.update("myPageMapper.updateProfile", map);
	}

}
