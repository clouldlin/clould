package com.lin.clould.module.login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lin.clould.common.framework.common.annotation.Controller;
import com.lin.clould.common.framework.common.annotation.RequestMapping;
import com.lin.clould.common.framework.common.util.session.SessionUtil;
import com.lin.clould.common.framework.common.util.string.StringUtil;
import com.lin.clould.common.framework.common.view.RequestView;
import com.lin.clould.common.framework.common.view.View;
import com.lin.clould.module.login.service.impl.LoginDao;
import com.lin.clould.module.login.service.impl.LoginVO;

@Controller("login")
public class LoginController {
	
	private LoginDao dao = LoginDao.getInstance();
	
	@RequestMapping("login")
	public View login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("module", "login");
		String view = null;
		try {
			if(SessionUtil.sessionCheck(request) ){
				return new RequestView(view, true);
			}else{
				String id = StringUtil.nvl(request.getParameter("id"));
				String pasword = StringUtil.nvl(request.getParameter("pasword"));
				
				LoginVO loginVO = dao.selectUserById(id);
				System.out.println(id);
				System.out.println(pasword);
				System.out.println(loginVO.getId());
				System.out.println(loginVO.getPw());
				// 인증이 성공하면..
				if (loginVO.getId().equals(id) && loginVO.getPw().equals(pasword)) {
					HttpSession session = request.getSession();
					session.setAttribute("clould.sessionInfo", loginVO);
					view = "/main/mypage";
					return new RequestView(view, true);
				}else{
					System.out.println("인증 실패");
					throw new Exception("아이디 또는 비밀번호가 일치하지 않습니다. \\n다시 확인 후 입력해 주시기 바랍니다.");
				}
			}
		} catch (Exception e) { // 만약 catch 절이 비어있다면, NullPointException도 무시된다.
			e.printStackTrace();
			view = "login/login";
			request.setAttribute("message", e.getMessage());
			// logger.error("외부전달 오류");
			// logger.error(e.getMessage); // 내부 오류
		}
		
		return new RequestView(view);
		
	}
	
	@RequestMapping("logout")
	public View logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		//request.setAttribute("message", "로그아웃 되었습니다.");
		//return new CommandResult("login/login");
		return new RequestView("/main/main", true);
	}
}
