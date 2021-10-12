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

public class DbOperations {
	Connection con;
	public DbOperations() {
		con = DbUtil.getConnection();
	}
	public boolean insertSubject(String name) throws SQLException {
		return false;
	}
	public ArrayList getSubjectById(int id) throws SQLException {
		return null;
	}
	public ResultSet getAllSubjects() throws SQLException {
		return null;
	}
	public boolean insertStudent(String student_name, float score, String name) throws SQLException {
		return false;
		
	}
	public ArrayList getStudentyId(int id) throws SQLException {
	   return null;
	}
	public ResultSet getAllStudents() throws SQLException {
		
		return null;
	}
	
}