package jdbcre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. CONNECTION 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"webdb2","webdb2");
			
			//3. SQL문/ 바인딩/ 실행

			String query = "";
			query += " select book_id as bId, ";
			query += "        title as bTitle, ";
			query += " 		  pubs,";
			query += " 		  to_char(pub_date,'yy/mm/dd') as da , ";
			query += " 		  author_id ";
			query += " from book ";
			
			pstmt =  conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int aId = rs.getInt("author_id");
				
				String date = rs.getString("da");
				
				System.out.println(
						rs.getInt("bId")+		
				rs.getString("bTitle")+
				rs.getString("pubs")+
				date+", "+
				aId
				);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
