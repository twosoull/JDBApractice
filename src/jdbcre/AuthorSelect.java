package jdbcre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorSelect {
	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			//1.JDBC Driver Loading
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.Connection 얻어오기
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"webdb2","webdb2");
			
			//3.쿼리문 작성 후 preparedStatement 객체 생성으로 보내주기
			//sql문 준비 / 바인딩 / 실행
			
			String query = "";
			query += " select author_id as aId , ";
			query += "        author_name as aName ,";
			query += "        author_desc  as aDesc ";
			query += " from author ";
			query += " order by author_id asc ";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int authorId = rs.getInt("aId");
				String authorName = rs.getString("aName");
				String authorDesc = rs.getString("aDesc");
				
				System.out.println(authorId + ", " + authorName+ ", " + authorDesc);
				
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
