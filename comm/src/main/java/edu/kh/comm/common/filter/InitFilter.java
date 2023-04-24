package edu.kh.comm.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger; // 스프링에서 기본제공
import org.slf4j.LoggerFactory;


@WebFilter(filterName="initFilter", urlPatterns = "/*")
public class InitFilter extends HttpFilter implements Filter {
	
	// print 구문을 사용하다 걸리면 바보.. -> Logger 사용
	
	// Logger 객체 생성 (해당 클래스에 대한 log를 출력하는 객체)
	// 필드에 작성할거니까 private
	private Logger logger = LoggerFactory.getLogger(InitFilter.class);
	
	// 필터가 생성될 때 실행
	public void init(FilterConfig fConfig) throws ServletException {
		// logger를 이용해서 출력하는 방법
		// trace - debug - info - warn - error (log를 어디까지 잡을것인지 범위)
		
		// debug : 개발의 흐름 파악 / 이게 실행이 되었는지, 파라미터가 현재 무엇인지 확인할 때
		//         (변수의 값이 언제 어떻게 들어왔고 언제 변했나 이런거)
		// info : 메소드 실행
		
		// 이 필터가 생성이 되었다 라는 정보를 출력하고 싶다! info가 제일 적절
		logger.info("초기화 필터 생성");
	}
       
	// 필터가 파괴될 때 실행 (서버는 켜져있는데 백엔드 코드가 수정되었을 때)
	public void destroy() {
		logger.info("초기화 필터 파괴");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// application 내장 객체 얻어오기
	    ServletContext application = request.getServletContext();
	      
	    //최상위 주소 얻어오기
	    String contextPath = ((HttpServletRequest)request).getContextPath(); // 다운캐스팅
	      
	    // 세팅
	    application.setAttribute("contextPath", contextPath);
	      
	    // 연결된 다음 필터 수행(없으면 Servlet 수행)
		chain.doFilter(request, response);
	}
}
