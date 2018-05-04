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
import ex0503.dto.CustomerDTO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");//내가뷰쪽으로 한글 보낼때 한글깨지지 않도록 하기위해 
		//0과 1만 보낼꺼라 필요 없어 
		
		request.setCharacterEncoding("UTF-8");//post방식 한글 인코딩 설정
		
		//.serialize()로 넘긴 값 받기 dto 에 저장 
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		CustomerDTO customerDTO = new CustomerDTO(id, name, age, phone, addr);
		
		CustomerDAO dao = new CustomerDAOImpl();
		int result = dao.insert(customerDTO);
		
		PrintWriter out = response.getWriter();
		out.print(result);
				
	}

}
