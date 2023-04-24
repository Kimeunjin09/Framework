package edu.kh.comm.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.comm.member.model.service.MemberService;
import edu.kh.comm.member.model.vo.Member;

// POJO 기반 프레임워크 : 외부 라이브러리 상속 X

// class : 객체를 만들기위한 설계도(붕어빵 기계...?)
// -> 객체로 생성 되어야 기능 수행이 가능함(new연산자 사용)
// --> IOC(제어의 역전, 객체 생명주기를 스피링이 관리)를 이용하여 객체 생성
// ** 이 때, 스프링이 생성한 객체를 bean 이라고 한다 **

// bean 등록 == 스프링이 객체로 만들어서 가지고 있어라

// @Component // 해당 클래스를 bean으로 등록하라고 스프링 프로그램에게 알려주는 주석 (Annotation)
// 역할을 부여받지 않고 그냥 객체역할한테 주는게 Component

@Controller // 생성된 bean이 Controller임을 명시 + bean 등록
@RequestMapping("/member") // localhost:8080/comm/member 이하의 요청을 처리하는 컨트롤러
// 원래는 Controller가 엄청 많았는데 RequestMapping을 이용해 member이하의 요청을 다 처리 할거임
// ex) localhost:8080/comm/member
//	   localhost:8080/comm/member/login
//     localhost:8080/comm/member/singUp 등등 다 처리 한다는 말~

public class MemberController {
	
	// 필드에 로거 만들기
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 자바의 특징 중 다형성 적용 (Impl이자식 MemberService가 부모인데 부모가 자식안에 있는 격...)
	// private MemberService service = new MemberServiceImpl();
	// IOC (제어의 역전) : new 연산자를 통해서 개발자가 직접 객체 생성하지 않는다. 밑에방식으로 이용,,,,
	
	@Autowired // bean으로 등록된 객체중 타입이 같거나, 상속관계인 bean을 주입해주는 역할
	private MemberService service; // ->  DI(의존성 주입)
	
	// Controller : 요청/응답을 제어하는 역할을 하는 클래스
	
	/* @RequestMapping : 클라이언트 요청(url)에 맞는 클래스 or 메서드를 연결 시켜주는 어노테이션
	 * 
	 * [ 위치에 따른 해석 ]
	 * - 클래스 레벨 : 공통 주소
	 * - 메서드 레벨 : 공통 주소 외 나머지 주소
	 * 
	 * 단, 클래스레벨에 @RequestMapping이 존재하지 않는다면
	 * - 메서드 레벨 : 단독 요청 처리 주소
	 * 
	 * [ 작성법에 따른 해석 ]
	 * 
	 * 1) @RequestMapping("url")
	 * --> 요청 방식(GET/POST) 관계 없이 url이 일치하는 요청을 처리
	 * 
	 * 2) @RequestMapping(value = "url", method = RequestMethod.GET | POST)
	 * --> 요청 방식에 따라 요청 처리함
	 * 근데 너무 길고 쓰기 귀찮으니까 밑에 방식 주로 사용
	 * 
	 * ** 메서드 레벨에서 GET/POST 방식을 구분하여 매핑할 경우 **
	 * @GetMapping("url")  /  @PostMapping("url") 사용하는 것이 일반적
	 * (메서드 레벨에서만 작성 가능!)
	 * */
	
	// 로그인
	// 요청 시 파라미터를 얻어오는 방법 1
	// -> HttpServletRequest 이용
	
	/*@RequestMapping("/login") // 메서드 레벨 : 공통 주소 외 나머지 주소 localhost:8080/comm/member/login
	// 클래스 레벨에 없다면 단독 요청처리 주소 localhost:8080/comm/login
	public String login(HttpServletRequest req) {
		logger.info("로그인 요청됨");
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		logger.debug("inputEmail : " + inputEmail);
		logger.debug("inputPw : " + inputPw);
		
		return "redirect:/"; // sendRedirect 안써도 됨! 이게 리다이렉트 구문!
	}*/
	
	
	
	// 요청 시 파라미터를 얻어오는 방법 2
	// -> @RequestParam 어노테이션 사용
	
	// @RequestParam("name속성값") 자료형 변수명
	// - 클라이언트 요청 시 같이 전달된 파라미터를 변수에 저장
	// --> 어떤 파라미터를 변수에 저장할지는 "name속성값"을 이용해 지정
	
	// 매개변수 지정 시 데이터 타입 파싱을 자유롭게 진행할 수 있음 ex) String -> int로 변환
	
	// [속성]
	// value : input 태그의 name 속성값
	
	// required : 입력된 name 속성값이 필수적으로 파라미터에 포함되어야 하는지 지정
	//			  required=true / false (기본값 true)
	
	// defaultValue : required 가 false인 상태에서 파라미터가 존재하지 않을 경우의 값을 지정
	
	/*@RequestMapping("/login")
	public String login(@RequestParam("inputEmail") String inputEmail, // inputEmail을 얻어와서 inputEmail변수명으로 쓰곘다는 뜻
					    @RequestParam("inputPw") String inputPw,
					    @RequestParam(value="inputName", required = false, defaultValue = "홍길동") String inputName
					    // name은 없는 input값인데도 속성을 지정하니까 오류없이 log에 뜸
			) {
		
		logger.debug("email : " + inputEmail);
		logger.debug("pw : " + inputPw);
		logger.debug("inputName : " + inputName);
		
		// email을 숫자만 입력받는다고 가정
		// logger.debug(inputEmail + 100); --> inputEmail의 변수타입을 int로 바꿔주면 됨
		// String일때의 경우 logger.debug(inputEmail + 100 + ""); 이런식으로 뭘 더 해줘야함 문자 + 숫자는 계산이 안되니까!
		
		return "redirect:/";
	}*/
	
	
	
	// 요청 시 파라미터를 얻어오는 방법 3 ---> 이거 때문에 index.jsp inputEmail,inputPw를 vo생성 및 memberEmail,memberPw로 수
	// -> @ModelAttribute 어노테이션 사용
	// vo랑 jsp의 값이 같으면 자동으로 맵핑? 해서 찾아와줌 == 바로 밑에 설명
	
	// @ModelAttribute VO타입 변수명
	// -> 파라미터 중 name 속성값이 VO의 필드와 일치하면
	//    해당 VO 객체의 필드에 값을 세팅
	
	// *** @ModelAttribute를 이용해서 객체에 값을 직접 담는 경우에 대한 주의 사항 ***
	// -- 반드시 필요한 내용
	// - VO 기본 생성자
	// - VO 필드에 대한 Setter
	
	@PostMapping("/login")
	public String login(@ModelAttribute Member inputMember) {
		
		logger.info("로그인 기능 수행됨");
		
		// 아이디, 비밀번호가 일치하는 회원 정보를 조회하는 Service 호출 후 결과 반환 받기
		Member loginMember = service.login(inputMember);
		
		return "redirect:/";
	}
	
	
	// 회원 가입 화면 전환
	@GetMapping("/signUp")   // Get방식 : /comm/member/signUp 요
	public String signUp() {
		
		return "member/signUp";
	}
	
}