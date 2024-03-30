package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select의 결과
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"jspuser",
					"1234");
			System.out.println("접속 성공!");
			pstmt = conn.prepareStatement("select * from \"MEMBER\""); //전체 조회 동작
			rs = pstmt.executeQuery();
			
			//테이블 값 가져오기
			while(rs.next()) {
				MemberVo vo = new MemberVo(
				rs.getInt(1),
				rs.getString(2),
				rs.getString("MEMBERPW"),
				rs.getString(4));
				vo.setDate(rs.getDate("DATE"));
				
				System.out.println(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
	        }
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