package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select2 {
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
			pstmt = conn.prepareStatement("select * from \"MEMBER\" where \"NUM\"=?"); //전체 조회 동작
			pstmt.setInt(1, 2); //파라미터 인덱스 1번에잇는 (첫번째 물음표) 2번회원 호출
			rs = pstmt.executeQuery();
			
			//테이블 값 가져오기
			if(rs.next()) {
				MemberVo vo = new MemberVo(
				rs.getInt("NUM"),
				rs.getString("MEMBERID"),
				rs.getString(3),
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