package ex0503.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *DB관련 로드,연결,닫기 위한 클래스
*/

public class DbUtil {
	
	static DataSource ds;

	/**
	 * 로드
	 */
	static {
		try {
			Context context = new InitialContext();
			ds= (DataSource)context.lookup("java:/comp/env/jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 연결
	 */
	public static Connection getConnection() throws SQLException { 
		return ds.getConnection();
	}
	
	/**
	 * 닫기
	 */
	// 연결 : Connection 닫아야해 
	// 실행 : 상황에 따라 닫다야 하는게 다르다 하지만 preparedStatemnt 가 Statemnt 상속받으므로 다형성을 이용해 Statemnt 로 닫는다 
	// Result : 검색을 했어야 닫아 = 메소드 오버로딩 
	public static void dbClose(Connection con , Statement st ){//인수 순서는 상관 없어 
		try {//왜 여기서 예외#
		if(st!=null) st.close();
		if(con!=null)con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void dbClose(Connection con , Statement st ,  ResultSet rs){//인수 순서는 상관 없어 
		try {
		if(rs!=null)rs.close();
		dbClose(con, st);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
