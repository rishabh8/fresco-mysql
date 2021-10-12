package com.fresco.jdbc.code;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fresco.jdbc.code.util.DbUtil;

// import com.fresco.jdbc.code.util.DbUtil;

public class DbOperations {
	Connection con;
	ResultSet res;
	PreparedStatement stat;
	public DbOperations() {
		con = DbUtil.getConnection();
	}

	public boolean insertSubject(String name) throws SQLException {
		stat = con.prepareStatement("insert into subject (name) values(?)");
		stat.setString(1, name);
		int result = stat.executeUpdate();
		return result > 0 ? true : false;
	}

	public ArrayList getSubjectById(int id) throws SQLException {
		ArrayList arr = new ArrayList();
		stat = con.prepareStatement("select * from subject where id=?");
		stat.setInt(1, id);
		res = stat.executeQuery();
		while (res.next()) {
			arr.add(res.getInt(1));
			arr.add(res.getString(2));
		}
		return arr;
	}

	public ResultSet getAllSubjects() throws SQLException {
		stat = con.prepareStatement("select * from subject");
		res = stat.executeQuery();
		return res;
	}

	public boolean insertStudent(String student_name, float score, String name) throws SQLException {
		PreparedStatement pstat = con.prepareStatement("select id from subject where name = ?");
		pstat.setString(1, name.trim());
		res = pstat.executeQuery();
		int subId = 0;
		while(res.next()) {
			subId = res.getInt(1);
		}

		stat = con.prepareStatement("insert into student (student_name,score,subject_id) values(?,?,?)");
		stat.setString(1, student_name);
		stat.setFloat(2, score);
		stat.setInt(3, subId);
		int result = stat.executeUpdate();
		return result > 0 ? true : false;
	}

	public ArrayList getStudentyId(int id) throws SQLException {
		ArrayList arr = new ArrayList();
		stat = con.prepareStatement("select * from student where id=?");
		stat.setInt(1, id);
		res = stat.executeQuery();
		while (res.next()) {
			arr.add(res.getInt(1));
			arr.add(res.getString(2));
			arr.add(res.getFloat(3));
			arr.add(res.getInt(4));
		}
		return arr;
	}

	public ResultSet getAllStudents() throws SQLException {
		stat = con.prepareStatement("select * from student");
		res = stat.executeQuery();
		return res;
	}

}