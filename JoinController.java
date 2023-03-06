package model2.mvcmember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;

@WebServlet("/mvcmember/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		System.out.println(userId);
		
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		int res = dao.selectView(userId);
		
		if(res == 1) {
			System.out.println("중복된 아이디");
		}
		else {
			System.out.println("사용 가능한 아이디");
		}
		
		out.write(res + "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
