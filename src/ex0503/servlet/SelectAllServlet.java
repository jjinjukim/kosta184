package ex0503.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0503.dao.CustomerDAO;
import ex0503.dao.CustomerDAOImpl;
import ex0503.dto.CustomerDTO;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//���������� �ѱ۱����� �ʵ��� �ϱ�����
		
		// daoȣ������ �װ�� list�޾Ƽ� json���� ��ȯ�ؼ� �����Ѵ�
		CustomerDAO dao = new CustomerDAOImpl();
		List<CustomerDTO>list = dao.selectAll();
		
		JSONArray arr = JSONArray.fromObject(list);//[{id:��,name:��,.....},{},{}]
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

}
