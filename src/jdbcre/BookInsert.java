package jdbcre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInsert {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//1. jdbc 오라클 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.connection을 얻어온다
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"webdb2","webdb2");
			//3.SQL문 /바인딩 /실행
			String query = "INSERT INTO book VALUES(seq_book_id.nextval,?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,"우리들의 일그러진 영웅");
			pstmt.setString(2,"다림");
			pstmt.setString(3,"1992/02/22");
			pstmt.setInt(4,1);
			pstmt.executeUpdate();
			
			pstmt.setString(1,"삼국지");
			pstmt.setString(2,"믿음사");
			pstmt.setString(3,"2002/03/01");
			pstmt.setInt(4,1);
			pstmt.executeUpdate();
			
			pstmt.setString(1,"토지");
			pstmt.setString(2,"마르니에북스");
			pstmt.setString(3,"2012/08/15");
			pstmt.setInt(4,2);
			pstmt.executeUpdate();
			
			pstmt.setString(1,"유시민의 글쓰기 특강");
			pstmt.setString(2,"생각의 길");
			pstmt.setString(3,"2015/04/01");
			pstmt.setInt(4,3);
			pstmt.executeUpdate();
			
			pstmt.setString(1,"패션왕");
			pstmt.setString(2,"중앙북스(books)");
			pstmt.setString(3,"2012/02/22");
			pstmt.setInt(4,4);
			pstmt.executeUpdate();
			
			pstmt.setString(1,"순정만화");
			pstmt.setString(2,"재미주의");
			pstmt.setString(3,"2011/08/03");
			pstmt.setInt(4,5);
			pstmt.executeUpdate();
			
			pstmt.setString(1,"오직두사람");
			pstmt.setString(2,"문학동네");
			pstmt.setString(3,"2017/05/04");
			pstmt.setInt(4,6);
			pstmt.executeUpdate();
			
			pstmt.setString(1,"26년");
			pstmt.setString(2,"재미주의");
			pstmt.setString(3,"2012/02/04");
			pstmt.setInt(4,5);
			pstmt.executeUpdate();
			
			System.out.println("완료되었습니다.");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
