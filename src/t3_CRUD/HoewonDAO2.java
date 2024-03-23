package t3_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoewonDAO2 {
	private Connection conn = null;//mysql서버 접속해서 DB연결하는것까지가 connection 의 기능
	private Statement stmt = null;//
	private ResultSet rs = null;//select가 사용되면 무조건 필요함
	
	HoewonVO vo = null; //vo를 올려놓으면 나중에 필요할때 생성해서 쓰면 편함
	private String sql = "";//null로 주어도 괜찮음
	
	public HoewonDAO2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaclass";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패~~");
		}
	}
	
	public void connClose() {//connection 닫음
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	public void stmtClose() {
		try {
			if(stmt != null ) stmt.close();//null이 아닐경우에 닫는다는 의미
		} catch (SQLException e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			stmtClose();
		} catch (SQLException e) {}
	}

	//전체 회원 조회
	public ArrayList<HoewonVO> getList() {
		ArrayList<HoewonVO> vos = new ArrayList<HoewonVO>();
		try {
			stmt = conn.createStatement();
			sql = "select * from hoewon";
			rs = stmt.executeQuery(sql);
			
			//HoewonVO vo = null;
			while(rs.next()) {
				vo = new HoewonVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
	//개별검색처리
	public HoewonVO getSearch(String name) {//리턴타입이 Hoewon 그래서 밑에서 vo생성하고 리턴을 vo로 해준다.
		HoewonVO vo = new HoewonVO();
		
		try {
			 stmt = conn.createStatement();
			String sql = "select * from hoewon where name = '"+name+"'";//select는 무조건 넘겨줘야해서 바로 밑문장으로 받아줌
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}	finally {
			rsClose();
		}
		return vo;
	}
	//회원자료 수정처리
//	System.out.print("수정할 항목? 1.성명: 2.나이 3.성별 4.주소 ==> ");
	public void setUpdate(int idx, int choice, String content) {
		try {
			 stmt = conn.createStatement();
			String sql = "";
			if(choice == 1) {
				sql = "update hoewon set name='"+content+"' where idx=" + idx;
			}
			else if(choice == 2) {
				sql = "update hoewon set age="+Integer.parseInt(content)+" where idx=" + idx;
			}
			else if(choice == 3) {
				sql = "update hoewon set gender="+content+" where idx=" + idx;
			}
			else if(choice == 4) {
				sql = "update hoewon set address='"+content+"' where idx=" + idx;
			}
			//select인 경우는 excuteQuery를 쓴다. 나머지는 결과를 넘겨받지 않는다.
			//update delete insert 는 반환 없다.
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}finally {
			stmtClose();
		}
	}
	
	//회원 삭제 처리
	public void setDelete(String name) {
		try {
			 stmt = conn.createStatement();
			sql = "delete from hoewon where name = '"+name+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}finally {
			stmtClose();
		}
	}

	//회원 등록 처리
	public void setInput(HoewonVO vo) {
		try {
			 stmt = conn.createStatement();
			sql = "insert into hoewon values(default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getAddress()+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}finally {
			stmtClose();
		}
	}

}
