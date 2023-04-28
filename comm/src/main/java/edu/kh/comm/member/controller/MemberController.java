package edu.kh.comm.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.comm.member.model.service.MemberService;
import edu.kh.comm.member.model.vo.Member;

// POJO 기반 프레임워크 : 외부 라이브러리 상속 X

// class : 객체를 만들기위한 설계도(붕어빵 기계...?)
// -> 객체로 생성 되어야 기능 수행이 가능함(new연산자 사용)
// --> IOC(제어의 역전, 객체 생명주기를 스프링이 관리)를 이용하여 객체 생성
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

@SessionAttributes({"loginMember"}) // Model에 추가된 값의 key와 어노테이션에 작성된 값이 같으면
											   // 해당 값을 session scope로 이동시키는 역할
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
	public String login(@ModelAttribute Member inputMember,
						Model model,
						RedirectAttributes ra,
						HttpServletResponse resp,
						HttpServletRequest req,
						@RequestParam(value="saveId", required=false) String saveId) {
		
		// 커맨드 객체
		// @ModelAttribute 생략된 상태에서 파라미터가 필드에 세팅된 객체
		
		
		logger.info("로그인 기능 수행됨");
		
		// 아이디, 비밀번호가 일치하는 회원 정보를 조회하는 Service 호출 후 결과 반환 받기
		Member loginMember = service.login(inputMember);
		
		/* Model : 데이터를 맵 형식(K:V) 형태로 담아 전달하는 용도의 객체
		 * -> request, session을 대체하는 객체
		 * 
		 * - 기본 scope : request
		 * - session scope로 변환하고 싶은 경우 클래스 레벨로 @SessionAttributes를 작성하면 된다.(저~~ 위에 작성함)
		 * 
		 * @SessionAttributes 미작성 -> request scope
		 * 
		 * */
		
		if(loginMember != null) { // 로그인 성공 
			model.addAttribute("loginMember", loginMember); // == req.setAttribute("loginMember", loginMember);
			
			// 로그인 성공 시 무조건 쿠키 생성
			// 단, 아이디 저장 체크 여부에 따라서 쿠키의 유지시간을 조정
			
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
			
			if(saveId != null) { // 아이디 저장 체크 되었을 때
				
				cookie.setMaxAge(60 * 60 * 24 * 365); // 초단위 지정(1년)
				
				
			} else { // 체크되지 않았을 때
				
				cookie.setMaxAge(0); // 0초 -> 생성되자마자 사라짐 == 쿠키삭제
				
			}
			
			// 쿠키가 적용될 범위(경로) 지정
			cookie.setPath(req.getContextPath()); // 얘 아래에서는 전부 쿠키를 적용시키겠다는 뜻..?
			// /comm이 프로젝트 아래는 다 지정하겠다는건데 프로젝트이름은 언제든 바뀔수 있으니까 그냥 최상위 경로를 지정해준것!
			
			// 쿠키를 응답 시 클라이언트에게 전달
			resp.addCookie(cookie);
			
		} else {
			// model.addAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다."); // footer.jsp에 message객체? 있음
			// 메세지는 일회성이니까 model사용보다 밑에방법으로!
			
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			// 이거 하고나면 메세지에 세션제거 어쩌구 지워도됨!
			// addFlashAttribute는 컨트롤러를 꼭 거쳐야 하기 때문에 jspforward가 필요함
			
			
			// redirect 시에도 request scope로 세팅된 데이터가 유지될 수 있도록 하는 방법을 Spring에서 제공해줌
			// -> RedirectAttributes 객체 (컨트롤러 매개변수에 작성하면 사용 가능)
		}

		return "redirect:/"; //세션스코프니까 아무리 리다이렉트해도 계속 유지됨(로그인정보가..), 리퀘스트면 날라감
	}
	
	// 로그아웃
	@GetMapping("/logout") // 멤버하위부터 작성
	public String logou(/*HttpSession session*/ SessionStatus status) {
		// 로그아웃 == 세션을 없애는 것
		
		// * @SessionAttributes을 이용해서 session scope에 배치된 데이터는
		//   SessionStatus라는 별도 객체를 이용해야만 없앨 수 있다.
		
		logger.info("로그아웃 수행됨");
		
		// session.invalidate(); 기존 세션 무효화 방식으로는 X
		
		status.setComplete(); // 세션이 할 일이 완료됨 -> 없앰
		
		return "redirect:/"; // 메인페이지 재요청
	}

	
	// 회원 가입 화면 전환
	@GetMapping("/signUp")   // Get방식 : /comm/member/signUp 요청
	public String signUp() {
		
		return "member/signUp";
	}
	
	
	// 이메일 중복 검사
	@ResponseBody // ajax 응답 시 사용!
	@GetMapping("/emailDupCheck") // member하위에 들어오는 애만 적으면 됨
	public int emailDupCheck( String memberEmail ) { // 파라미터 key값과 저장하려는 변수명이 같으면 ()안에 앞에 @RequestParam("memberEmail") 생략 가능!
		
		// int result = service.emailDupCheck(memberEmail); return에 작성
		
		// 컨트롤러에서 반환되는 값은 forward 또는 redirect를 위한 경로인 경우가 일반적
		// -> 반환되는 값은 경로로 인식됨
		
		// -> 이를 해결하기 위한 어노테이션 @ResponseBody 가 존재.
		
		// @ResponseBody : 반환되는 값을 응답의 몸통(body)에 추가하여 이전 요청 주소로 돌아감
		// -> 컨트롤러에서 반환되는 값이 경로가 아닌 "값 자체"로 인식됨.
		
		return service.emailDupCheck(memberEmail);
	}
	
	// 닉네임 중복 검사
	@ResponseBody
	@GetMapping("/nicknameDupCheck")
	public int nicknameDupCheck(String memberNickname) {
		return service.nicknameDupCheck(memberNickname);
	}
	
	// 회원 가입
//	@PostMapping("/signUp")
//	public String signUpPost(Member inputMember) {
//		int result = service.signUp(inputMember);
//		return "redirect:/";
//	}
	
	// 회원가입 풀이
	@PostMapping("/signUp") // requestMapping으로 member까지는 잡아주고 있으니까 /signUp만 작성
	public String signUp(Member inputMember, // 앞에 modelAttribute 생략
						 String[] memberAddress,
				         RedirectAttributes ra // 메세지 담을거라서 사용 redirect될때 잠깐 세션에 올렸다가 리다이렉트로 다시돌아옴
			) {
		
		// 커맨드 객체를 이용해서 입력된 회원 정보를 잘 받아옴
		// 단, 같은 name을 가진 주소가 하나의 문자열로 합쳐서 세팅되어 들어옴.
		// -> 도로명 주소에 "," 기호가 포함되는 경우가 있어 이를 구분자로 사용할 수 없다.
		
		inputMember.setMemberAddress(String.join(",,", memberAddress)); // 커맨드객체인 인풋멤버에 담아주기
		// String.join("구분자", 배열)
		// 배열을 하나의 문자열로 합치는 메서드
		// 값 중간중간에 구분자가 들어가서 하나의 문자열로 합쳐줌
		// [a,b,c] -> join진행 -> "a,,b,,c"
		
		
		// 주소값은 회원가입 시 필수값이 아니라 값이 없으면 ,, ,, 만 출력되므로 처리해주기
		if(inputMember.getMemberAddress().equals(",,,,")) { // 주소가 입력되지 않은 경우
			
			inputMember.setMemberAddress(null); // null로 변환
			
		}
		
		// 회원 가입 서비스 호출하기
		int result = service.signUp(inputMember);
		
		// 메세지랑 redirect할 페이지 다르게 해주기
		String message = null;
		String path = null;
		
		if(result > 0 ) { // 회원가입 성공
			message = "회원 가입 성공";
			path = "redirect:/"; // 메인페이지
			
		} else { // 실패
			message = "회원 가입 실패";
			path = "redirect:/member/signUp"; // 회원가입 페이지
		}
		
		ra.addFlashAttribute("message", message); // 이렇게 담아줘야함.....
		
		return path;
	}
	
	
	
	// 회원 1명 정보 조회(ajax)
	
	
	
	
	// 회원 목록 조회(ajax)
	
	
	
	
	
	
	
	/* 스프링 예외 처리 방법 (3가지, 중복 사용 가능)
	 * 
	 * 1 순위 : 메서드 별로 예외처리 (try-catch / throws)
	 * 
	 * 2 순위 : 하나의 컨트롤러에서 발생하는 예외를 모아서 처리, 보통 해당 컨트롤러 맨 아래 작성
	 * 			-> @ExceptionHandler (메서드에 작성)
	 * 
	 * 3 순위 : 전역(웹 애플리케이션)에서 발생하는 예외를 모아서 처리, 예외처리 컨트롤러를 만들어서 작성
	 * 			-> @ControllerAdvice (클래스에 작성)
	 * */
	
	// 회원 컨트롤러에서 발생하는 모든 예외를 모아서 처리(2순위)
//	@ExceptionHandler(Exception.class)
//	public String exceptionHandler(Exception e, Model model) { // Model == 데이터 전달용 객체
//		e.printStackTrace();
//		
//		model.addAttribute("errorMessage", "서비스 이용 중 문제가 발생했습니다.");
//		model.addAttribute("e", e);
//		
//		return "common/error";
//		
//	}
	
	
}
