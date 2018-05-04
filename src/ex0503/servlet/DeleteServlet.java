package ex0503.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0503.dao.CustomerDAO;
import ex0503.dao.CustomerDAOImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//자바스크립트 가 한글 인코딩 하기위해 필요 
		
		request.setCharacterEncoding("UTF-8");//post방식 한글 인코딩 설정
		
		String id = request.getParameter("id");
		
		CustomerDAO dao = new CustomerDAOImpl();
		
		int result = dao.delete(id);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		
			
	}

}
