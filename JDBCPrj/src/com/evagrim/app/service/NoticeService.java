package com.evagrim.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.evagrim.app.entity.Notice;

public class NoticeService {
	
	// NOTICE 테이블 SELECT 하여 List로 받아오기
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@아이피:1521/사용할디비이름";
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "디비아이디", "디비암호");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regDate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			
			Notice notice = new Notice(id, title, writerId, content, regDate, hit);
			list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

}
