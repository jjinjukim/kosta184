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
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/idCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");//���������� �ѱ۱����� �ʵ��� �ϱ�����
			
			request.setCharacterEncoding("UTF-8");//post��� �ѱ� ���ڵ� ����
			String id = request.getParameter("id");//getParameter�� �޾�
			
			CustomerDAO dao = new CustomerDAOImpl();
			String result = dao.idCheck(id);
			
			PrintWriter out = response.getWriter();
			out.print(result);
	}

}
