package t6_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NetpayDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	NetpayVO vo = null;
	private String sql ="";
	
	public NetpayDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaclass";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패!");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패!");
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	public void pstmtClose() {
		try {
			if(pstmt != null ) pstmt.close();
		} catch (Exception e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			pstmtClose();
		} catch (Exception e) {}
	}
//본봉 테이블 입력처리
	public int setSalaryInput(NetpayVO vo) {
		int res = 0;
		try {
			sql = "insert into salary values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getJikkub());
			pstmt.setInt(2, vo.getBonbong());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}finally {
			pstmtClose();
		}
		return res;
	}
	//성명 중복처리
	public NetpayVO getJikkubSearch(String jikkub) {
		NetpayVO vo = new NetpayVO();
		try {
			sql = "select * from salary where jikkub = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jikkub);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setJikkub(jikkub);
				vo.setBonbong(rs.getInt("bonnbong"));
			}
			else vo =null;
			
		} catch (Exception e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}finally {
			rsClose();
		}
		return null;
	}
//전체 자료
	public ArrayList<NetpayVO> getSalaryList() {
		ArrayList<NetpayVO> vos = new ArrayList<>();
		
		try {
			sql = "select * from salary order by bonbong desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new NetpayVO();
				vo.setJikkub(rs.getString("jikkub"));
				vo.setBonbong(rs.getInt("bonbong"));
				
				vos.add(vo);
			}
		} catch (Exception e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}finally {
			rsClose();
		}
		return null;
	}
	
}
