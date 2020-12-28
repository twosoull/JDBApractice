package jdbcre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorInsert {
	public static void main(String[] args) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
		    // 2. Connection 얻어오기
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url,"webdb2","webdb2");
				
		    // 3. SQL문 준비 / 바인딩 / 실행
				String query = " INSERT INTO author values(seq_author_id.nextval,?,?) ";
				
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1,"이문열");
				pstmt.setString(2,"경북양양");
				pstmt.executeUpdate();
				
				
				pstmt.setString(1,"박경리");
				pstmt.setString(2,"경상남도 통영");
				pstmt.executeUpdate();
				
				
				pstmt.setString(1,"유시민");
				pstmt.setString(2,"17대국회의원");
				pstmt.executeUpdate();
				
				pstmt.setString(1,"기안84");
				pstmt.setString(2,"기안동에서 산 84년생");
				pstmt.executeUpdate();
				
				pstmt.setString(1,"강풀");
				pstmt.setString(2,"온라인만화가 1세대");
				pstmt.executeUpdate();
				
				pstmt.setString(1,"김영하");
				pstmt.setString(2,"알쓸신잡");
				pstmt.executeUpdate();
				
				System.out.println("생성되었습니다.");
				
				
				
				
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}

	}
}
