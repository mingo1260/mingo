package com.company.mem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.company.mem.dto.MemberDTO;
import com.company.mem.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService msvc;
	
	@Autowired
	private HttpSession session;
	
	// contrller에서 String 타입의 메소드는 페이지 이동을 의미한다.
	// String타입 메소드의 return값 jsp 파일을 실행한다.
	// RequestMapping value값이 "/"이면 프로젝트의 시작을 의미한다.
	// 따라서 페이지를 이동하는 메소드는 다 String 타입이다. 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		
		return "index";
	//	WEB-INF/VIEWS/index.jsp 파일이 실행
	//	servlet-context에서 설정했음.
	}
	
	// mJoinForm : 회원가입 페이지로 이동
	@RequestMapping(value = "mJoinForm", method = RequestMethod.GET)
	public String mJoinForm() {
				// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		
		return "MBJoin";
	}
	
	// mLoginForm : 로그인 페이지로 이동
	@RequestMapping(value = "mLoginForm", method = RequestMethod.GET)
	public String mLoginForm() {
				// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		
		return "MBLogin";
	}
	
	// mLogout : 로그아웃 페이지로 이동
	@RequestMapping(value = "mLogout", method = RequestMethod.GET)
	public String mLogout() {
		// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		
		session.invalidate(); // 모든 세션을 초기화하겠다.
		
		return "index";
	}
	
	
	// ModelAndView 객체 생성
	
	private ModelAndView mav = new ModelAndView();
		
	// mbJoin : 회원가입
	@RequestMapping(value = "mbJoin", method = RequestMethod.POST)
	public ModelAndView mbJoin(@ModelAttribute MemberDTO member) {
		// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		System.out.println("\n==== 회원가입 메소드 ====");
		System.out.println("[2] jsp >> controller : member = " + member);
			
		// mav객체에 service에서 만든 메소드의 return 값을 받아온다.
		// ( = 서비스로 정보를 전달한다.)
		mav = msvc.mbJoin(member);
		
		return mav;
			
	}
	
	// mList : 회원목록
	@RequestMapping(value = "mList", method = RequestMethod.GET)
	public ModelAndView mList() {
		// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		System.out.println("\n==== 회원목록 메소드 ====");
		System.out.println("[1] jsp >> controller");
		
		// mav객체에 service에서 만든 메소드의 return 값을 받아온다.
		// ( = 서비스로 정보를 전달한다.)
		mav = msvc.mList();
		System.out.println("[5] service >> controller");
		
		return mav;
		
	}
	
	// mView : 회원상세보기
	// id값 하나만 받을 때는 @RequestParam("mbId") String mbId 사용
	// 한 사람의 회원정보를 받아서 MBView.jsp에 출력하세요.
	@RequestMapping(value = "mView", method = RequestMethod.GET)
	public ModelAndView mView(@RequestParam("mbId") String mbId) {
		// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		System.out.println("\n==== 회원상세 보기 메소드 ====");
		System.out.println("[1] jsp >> controller");
		
		// mav객체에 service에서 만든 메소드의 return 값을 받아온다.
		// ( = 서비스로 정보를 전달한다.)
		mav = msvc.mView(mbId);
		System.out.println("[5] service >> controller");

		return mav;
		
	}
	
/*
  	회원의 ID 값으로 정보를 받아오는 방법.
  	@RequestMapping(value = "mView", method = RequestMethod.GET)
	public ModelAndView mView(@RequestParam("mbId") String mbId) {
		
		mav = msvc.mView(mbId);
		return mav;	
	} */
	
// mModiForm : 회원수정 페이지 요청
	@RequestMapping(value = "mModiForm", method = RequestMethod.GET)
	public ModelAndView mModiForm(@RequestParam("mbId") String mbId) {
		// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		System.out.println("\n==== 회원상세 보기 메소드 ====");
		System.out.println("[1] jsp >> controller");
		
		// mav객체에 service에서 만든 메소드의 return 값을 받아온다.
		// ( = 서비스로 정보를 전달한다.)
		mav = msvc.mModiForm(mbId);
		System.out.println("[5] service >> controller");

		return mav;
		
	}
	
	// mModify : 회원수정
	@RequestMapping(value = "mModify", method = RequestMethod.POST)
	public ModelAndView mModify(@ModelAttribute MemberDTO member) {
		// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		System.out.println("\n==== 회원가입 메소드 ====");
		System.out.println("[2] jsp >> controller : member = " + member);
			
		// mav객체에 service에서 만든 메소드의 return 값을 받아온다.
		// ( = 서비스로 정보를 전달한다.)
		mav = msvc.mModify(member);
		
		return mav;
			
	}
	
	// mDelete : 회원삭제 
	@RequestMapping(value = "mDelete", method = RequestMethod.GET)
	public ModelAndView mDelete(@RequestParam("mbId") String mbId) {
		// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		// String 후 이름은 상관없으나, 헷갈리지 말라고 같은 이름으로.
		System.out.println("\n==== 회원삭제 메소드 ====");
		System.out.println("[1] jsp >> controller : mbId = " + mbId);
			
		// mav객체에 service에서 만든 메소드의 return 값을 받아온다.
		// ( = 서비스로 정보를 전달한다.)
		mav = msvc.mDelete(mbId);
//		msvc : MemberService 전체를 의미
//		mDelete() : MemeberService의 mDelete() 메소드를 의미
//		mbId : MemberService의 mDelete() 메소드의 String mbId를 의미
		
		System.out.println("[5] service >> controller : mav = " + mav);
		
		return mav;
		
	}
	
	// mLogin : 로그인
	@RequestMapping(value = "mLogin", method = RequestMethod.POST)
	public ModelAndView mLogin(@ModelAttribute MemberDTO member) {
		// method 이름은 아무거나 상관없으나, 통일성을 위해 value와 같은 이름으로.
		System.out.println("\n==== 회원가입 메소드 ====");
		System.out.println("[1] jsp >> controller : loginId = " + member);
		
		// mav객체에 service에서 만든 메소드의 return 값을 받아온다.
		// ( = 서비스로 정보를 전달한다.)
		mav = msvc.mLogin(member);
		
		return mav;
			
	}
	
	
}
