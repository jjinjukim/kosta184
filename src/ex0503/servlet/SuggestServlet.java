package ex0503.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggestServlet")
public class SuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String words [] = {
			"������ ���׿�","������ �ȳ�","��å����?","Happy ��� ���� ��û","�����̳� ����",
			"������ ħ��","�÷��̸�Ʈ","����","��å","���� ���","���� ������ ������","Ajax�Ҹ��Ѱ�",
			"������ ����¯","��Ÿ���� ���ִ�","����ٵ���","�ٶ��̺γ׿�","������ ���","������~",
			"������~�����","���ǾƱ�","����","���Ǳ��","���Ǽ���"
	};
    
	/**
	 * ù�ܾ ������ �ܾ ã�Ƽ� list�� ��� �����ϴ� �޼ҵ� �ۼ� 
	 * */
	private List<String> search(String keyWord){
		List<String>list=new ArrayList<>();
		
		for(String word : words) {
			if(word.toLowerCase().startsWith(keyWord.toLowerCase() )) { //startsWith �� �ܾ�� �����ϴ°� ã���ִ°�
				list.add(word);
			}
		}
		return list;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");//�ڹٽ�ũ��Ʈ �� �ѱ� ���ڵ� �ϱ����� �ʿ� 
		
		request.setCharacterEncoding("UTF-8");//post��� �ѱ� ���ڵ� ����
		String keyWord = request.getParameter("keyWord");
		
		List<String> list = this.search(keyWord); //�ڹٽ�ũ��Ʈ�� list ���� 
	
		
		/*//front���� ������ ���� 
				PrintWriter out = response.getWriter();
				
		//front�� �����͸� �����ϱ� ���ؼ� text�������� ��ȯ�غ���
		//����|�ܾ�,�ܾ�,�ܾ�~~~ //������ ���� �ܾ� �и�
				
		out.print(list.size()+"|");//String data = list.size()+"|";
		
		for(int i=0; i<list.size() ; i++) {
			if(i==(list.size()-1))
				out.print(list.get(i));
			else
			out.print(list.get(i)+",");
		}*/
		
		/////////////////////////////////////////////////////////////////////////////
		//list�� json���·� ��ȯ�ؼ�  front�� ������ [{} , {} , {}]
		JSONArray jsonArr= JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
		
	}

}
