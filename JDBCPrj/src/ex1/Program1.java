package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@아이피:1521/사용할디비이름";
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "디비아이디", "디비암호");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regDate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			
			// 조회수 10이상인 데이터만 요청 시
			//if(hit >= 10)
			//	System.out.printf("id:%d, title:%s, writerId:%s, regDate:%s, content:%s, hit:%d\n", id, title, writerId, content, regDate, hit);			
			// 이렇게 하면 안됨.
			// 필터링, 정렬, 그룹핑은 자바에서 하지않고 DB에서 해준다.
			// 데이터 가공처리는 SQL, 자바는 UI 레이아웃만
			// String sql = "SELECT * FROM NOTICE WHERE HIT>10";
			// 조회수가 10 이상인 것만 DB에서 요청한 다음에 사용한다.
		}
		
		
		rs.close();
		st.close();
		con.close();
	}

}
