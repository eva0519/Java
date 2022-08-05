package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String title = "TEST2";
		String writerId = "newlec";
		String content = "hahaha";
		String files = "";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO notice ("
				+ "    title,"
				+ "    writer_id,"
				+ "    content,"
				+ "    files"
				+ ") VALUES (?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "디비아이디", "디비비번");
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
		PreparedStatement st = con.prepareStatement(sql);
		// 쿼리문의 ?에 index는 1부터 시작.
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		// executeUpdate는 DML 실행된 Rows 정수 결과값을 반환한다.
		int result = st.executeUpdate();
		
		System.out.println(result);
		
//		rs.close();
		st.close();
		con.close();
	}

}
