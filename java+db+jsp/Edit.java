package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Edit {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection( //1
					"jdbc:oracle:thin:@localhost:1521:xe",
					"jspuser",
					"1234");
			System.out.println("접속 성공!");
			
			StringBuffer query = new StringBuffer();
			query.append("update \"MEMBER\" ");
			query.append("set \"MEMBERPW\"=?, \"NICKNAME\"=? ");
			query.append("where \"NUM\" =?");
			
			System.out.println(query.toString());
			
			pstmt = conn.prepareStatement(query.toString()); //쿼리문 작성 2
			pstmt.setString(1, "4321"); //파라미터 인덱스 1번에잇는 (첫번째 물음표) 2번회원 호출3
			pstmt.setString(2, "nnnn"); 
			pstmt.setInt(3, 4);
			
			result = pstmt.executeUpdate(); //숫자를 반환한다. 4 
			System.out.println(result + "행이 수정되었습니다.");	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
}
}
}