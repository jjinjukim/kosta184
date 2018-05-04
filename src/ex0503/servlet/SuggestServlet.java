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
			"날씨가 좋네요","지은이 안녕","산책갈까?","Happy 사료 샘플 요청","개린이날 선물",
			"강아지 침대","플레이매트","간식","산책","좋은 사료","오늘 점심은 뭐먹지","Ajax할만한가",
			"나현이 센스짱","스타벅스 맛있다","손톱다듬자","바람이부네요","오늘은 춥다","지은아~",
			"지은아~노올자","해피아기","해피","해피까까","해피선물"
	};
    
	/**
	 * 첫단어가 동일한 단어를 찾아서 list에 담아 리턴하는 메소드 작성 
	 * */
	private List<String> search(String keyWord){
		List<String>list=new ArrayList<>();
		
		for(String word : words) {
			if(word.toLowerCase().startsWith(keyWord.toLowerCase() )) { //startsWith 그 단어로 시작하는것 찾아주는것
				list.add(word);
			}
		}
		return list;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");//자바스크립트 가 한글 인코딩 하기위해 필요 
		
		request.setCharacterEncoding("UTF-8");//post방식 한글 인코딩 설정
		String keyWord = request.getParameter("keyWord");
		
		List<String> list = this.search(keyWord); //자바스크립트는 list 몰라 
	
		
		/*//front보낼 데이터 설정 
				PrintWriter out = response.getWriter();
				
		//front로 데이터를 전송하기 위해서 text형식으로 변환해본다
		//개수|단어,단어,단어~~~ //개수에 따라 단어 분리
				
		out.print(list.size()+"|");//String data = list.size()+"|";
		
		for(int i=0; i<list.size() ; i++) {
			if(i==(list.size()-1))
				out.print(list.get(i));
			else
			out.print(list.get(i)+",");
		}*/
		
		/////////////////////////////////////////////////////////////////////////////
		//list를 json형태로 변환해서  front로 보내기 [{} , {} , {}]
		JSONArray jsonArr= JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
		
	}

}
