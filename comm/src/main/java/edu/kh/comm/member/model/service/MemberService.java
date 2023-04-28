package edu.kh.comm.member.model.service;

import edu.kh.comm.member.model.vo.Member;

/* Service Interface를 사용하는 이유
 * 
 * 1. 프로젝트에 규칙성을 부여하기 위해서
 * 
 * 2. Spring AOP를 위해서 필요
 * 
 * 3. 클래스간의 결합도를 약화시키기 위해서 -> 유지보수성 향상에 도움
 * 
 * */
public interface MemberService {
	
	// 인터페이스 특징!
	// 모든 메서드가 추상 메서드 (묵시적으로 public abstract)
	// 모든 필드는 상수 (묵시적으로 public static final)
	

	// 로그인 서비스, 파람:inputMember, 리턴:loginMember
	public abstract Member login(Member inputMember);

	// 이메일 중복 검사, 파람:memberEmail, 리턴:result
	public abstract int emailDupCheck(String memberEmail);

	// 닉네임 중복 검사
	public abstract int nicknameDupCheck(String memberNickname);

	// 회원 가입, 풀이랑 동일
	public abstract int signUp(Member inputMember);
	
	
	
}
