package com.company.mem.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.company.mem.dao.MemberDAO;
import com.company.mem.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav = new ModelAndView();

	public ModelAndView mbJoin(MemberDTO member) {
		System.out.println("[2] controller >> service : member = " + member);
		
// 2. dao에서 만들 메소드의 데이터 타입 정하기
	// (1) insert, update, delete의 경우 int 타입
		// ex) int result
		
	// (2) 상세보기 : dto 타입
		// ex) MemberDTO  member
		
	// (3) 목록보기 : List<dto> 타입
		// ex) List<MemberDTO> memberList
		
// 3. dao로 정보 넘기기
	int result = mdao.mbJoin(member);
	
	if(result>0) {
		// 입력에 성공하면 result = 1이므로
		
		// 성공 했을 경우 이동할 주소 선언
		mav.setViewName("index");
	// mav에 setViewName("index")을 담았다.
	} else {
		// 입력에 실패하면 result = 0이므로
		
		// 실패 했을 경우 이동할 주소 선언
		mav.setViewName("MBJoin");
	// mav에 setViewName("MBJoin")을 담았다.
	}

// 1. return 값을 mav로 바꾸기
		return mav;
	// 성공, 실패 여부 따라 다르게 담긴 주소로 이동.
	}

	public ModelAndView mList() {
		System.out.println("[2] controller >> service");
		List<MemberDTO> memberList = mdao.mList();
//		mdao >> MemberDAO 파일 전체를 의미, mList() >> mList() 메소드를 의미
//		mdao에서 mList라는 애를 가지고 오겠다.
		System.out.println("[4] dao >> service : memberList" + memberList);
		
		mav.setViewName("MBList"); // View
		mav.addObject("memberList", memberList); // Model
//		mav.addObject("jsp에서사용할이름", jsp로보낼정보);
		
		return mav;
	}
	
	public ModelAndView mView(String mbId) {
		System.out.println("[2] controller >> service");
		MemberDTO member = mdao.mView(mbId);		
//		mdao >> MemberDAO 파일 전체를 의미, mList() >> mList() 메소드를 의미
//		mdao에서 mView라는 애를 가지고 오겠다.
//		System.out.println("[4] dao >> service member: " + member);
		
// MemberDTO 클래스를 member라고 선언하고 mbId데이터를 넣은 MemberDAO 클래스의 mView()메소드를 전송
// 정답 : = 을 기준으로는 오른쪽부터 이해할 것.
// 		DAO에 있는 mView메소드에 mbId 값을 보낸다.
//		이렇게 계산 후 return된 값을 member라는 변수에 담겠다.
// 
		
	// model, view 데이터를 담는 공간이라고 생각하면 됨. 
	// model : 이동할 jsp에서 사용할 데이터의 이름과 값을 정한다.
	// view : 이동할 jsp를 정한다. 
	// MBView.jsp로 member에 저장된 내용을 view라는 이름으로 사용한다. 
		
		mav.setViewName("MBView"); //View
		mav.addObject("view", member); // Model
//		mav.addObject("jsp에서사용할이름", jsp로보낼정보);
		
		return mav;
	}

	public ModelAndView mModiForm(String mbId) {

	// 수정할 사람의 정보를 미리 만들어 놓은 mView메소드를 통해 가져올 수 있음.
		MemberDTO member = mdao.mView(mbId);
		
		mav.addObject("modify", member);
		mav.setViewName("MBModify");
				
	// MBModify.jsp 에서 수정할 회원의 정보(member)를 modify라는 이름으로 사용하겠다.
		
		return mav;
	}

	public ModelAndView mModify(MemberDTO member) {
		int result = mdao.mModify(member);
		
		if(result>0) {
			// 입력에 성공하면 result = 1이므로
			
			// 성공 했을 경우 이동할 주소 선언
	// redirect : url을 jsp가 아닌 controller에 있는
			// RequestMapping value로 이동
	// 수정 성공 시 : 회원 상세보기로 이동.
			mav.setViewName("redirect:/mView?mbId= " + member.getMbId());
			
			
			
			
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		} else {
			// 입력에 실패하면 result = 0이므로
			
			// 실패 했을 경우 이동할 주소 선언 >> 회원목록 페이지로 이동(.jsp 아닌 controller의 mList)
			mav.setViewName("redirect:/mList");
		}

	// 1. return 값을 mav로 바꾸기
			return mav;
		// 성공, 실패 여부 따라 다르게 담긴 주소로 이동.
	}

	public ModelAndView mDelete(String mbId) {
	
		int result = mdao.mDelete(mbId);
		
		if(result>0) {
			mav.setViewName("redirect:/mList");
		} else {
			mav.setViewName("index");
		}
		
/*
	
 mav : model, view
 model에는 아무 것도 없어 view는 mList로 보내줌.
	
	
*/		
		return mav;
	}

	public ModelAndView mLogin(MemberDTO member) {
		System.out.println("[2] controller >> service");
		
		String loginId = mdao.mLogin(member);
		
	// session 추가 : 브라우저가 종료되기 전까지 정보를 담고 있는다.
	// db에서 가져온 loginId 정보를 "loginId"라는 이름으로 session을 씌운다.
		session.setAttribute("loginId", loginId);
		
		mav.setViewName("index");
		
		return mav;
	}
	
	
}
