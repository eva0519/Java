package com.evagrim.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.evagrim.app.entity.Notice;

public class NoticeService {

	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String uid = "";
	private String pwd = "";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {

		int start = 1+(page-1)*10; // 1 11 21 31 초항a1+(계수n-1)*차수d 등차수열
		int end = 10*page; // 10 20 30 40
		
		String sql = "select * from notice_view where "+field+" like ? and num between ? and ?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%"); 
		st.setInt(2, start); 
		st.setInt(3, end); 
		ResultSet rs = st.executeQuery();

		List<Notice> list = new ArrayList<Notice>();

		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regDate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");			

			Notice notice = new Notice(id, title, writerId, content, regDate, hit, files);
			list.add(notice);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	// Scalar 값을 얻어 온다. 단위값을 얻는 함수.
	public int getCount() throws ClassNotFoundException, SQLException {
		
		int count = 0;
		
		String sql = "select count(ID) COUNT from notice";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next())
			count = rs.getInt("COUNT");
			
		rs.close();
		st.close();
		con.close();

		return count;
	}

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO notice ("
				+ "    title,"
				+ "    writer_id,"
				+ "    content,"
				+ "    files"
				+ ") VALUES (?,?,?,?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
				
		st.close();
		con.close();
		
		return result;
	}

	public int update(Notice notice) throws ClassNotFoundException, SQLException {

		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "update notice "
				+ "set"
				+ "    TITLE=?,"
				+ "    CONTENT=?,"
				+ "    FILES=?"
				+ "where id=?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);

		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	public int delete(int id) throws ClassNotFoundException, SQLException {
				
		String url = "jdbc:oracle:thin:@ip:1521/xepdb1";
		String sql = "DELETE NOTICE WHERE ID=?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setInt(1, id);

		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

}
