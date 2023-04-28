package edu.kh.comm.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.comm.member.model.vo.Member;

@Repository // 영속성(지속가능한 성질을 가짐)을 가지는 DB파일과 연결되는 클래스임을 명시 + bean등록
public class MemberDAO {
	
	// DAO는 DB랑 연결하기 위한 Connection이 공통적으로 필요
	// -> 필드에 선언
	// + Mybatis 영속성 프레임워크를 이용하려면 Connection을 이용해 만들어진 객체
	// SqlSessionTemplate을 사용

	@Autowired // root-context.xml 에서 생성된 SqlSessionTemplate bean을 의존성 주입(DI)
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(MemberDAO.class);
	
	public Member login(Member inputMember) {
		
		// 1행 조회(파라미터가 없는경우) 방법
		//int count = sqlSession.selectOne("namespace값.id값");
		
		//int count = sqlSession.selectOne("memberMapper.test1");
		
		//logger.debug(count + ""); // 문자열로 해야 debug가 먹혀서 + ""해주는 거!
		
		// 1행 조회(파라미터 O) 방법
		// String memberNickname = sqlSession.selectOne("memberMapper.test2", inputMember.getMemberEmail());
		// logger.debug(memberNickname + "");
		
		// 1행 조회(파라미터가 VO인 경우)
		// 전화번호니까 string
		// String memberTel = sqlSession.selectOne("memberMapper.test3", inputMember); // inputMember안에는 memberEmail, memberPw있음
		
		// logger.debug(memberTel);
		
		// 1행 조회(파라미터가 VO, 반환되는 결과도 VO)
		Member loginMember = sqlSession.selectOne("memberMapper.login", inputMember);
		
		return loginMember;
	}

	// 이메일 중복검사 DAO, 파람:emberEmail, 리턴:result
	public int emailDupCheck(String memberEmail) {
		return sqlSession.selectOne("memberMapper.emailDupCheck", memberEmail);
	}

	// 닉네임 중복검사 DAO
	public int nicknameDupCheck(String memberNickname) {
		return sqlSession.selectOne("memberMapper.nicknameDupCheck", memberNickname);
	}

	// 회원 가입
//	public int signUp(Member inputMember) {
//		return sqlSession.insert("memberMapper.signUp", inputMember);
//	}
	
	// 회원 가입 풀이 DAO
	public int signUp(Member inputMember) {
		
		// INSERT, UPDATE, DELETE 수행하기 위한 메서드 존재.
		
		// * insert() / update() / delete() 메서드의 반환값은 int 고정
		// - mapper에서도 resultType이 항상 _int 로 고정
		// -> resultType 생략 가능 (묵시적으로 _int)
		
		return sqlSession.insert("memberMapper.signUp", inputMember);
	}
	
}
