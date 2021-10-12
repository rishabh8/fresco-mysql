package com.fresco.jdbcTests;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fresco.jdbc.code.DbOperations;
import com.fresco.jdbc.code.util.DbUtil;
import com.fresco.jdbc.code.util.RunningScripts;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class JdbcTest {
    DbOperations dbOp = new DbOperations();

  @BeforeClass
    public static void test1() throws Exception{
        RunningScripts scr = new RunningScripts();
        scr.runDbScript();
  }
	@org.junit.Test
	public void test2() throws Exception{
		dbOp.insertSubject("Maths");
		dbOp.insertSubject("Science");
		dbOp.insertSubject("English");
		ArrayList record = dbOp.getSubjectById(2);
		assertEquals(record.get(0), 2);
		assertEquals(record.get(1), "Science");
		ResultSet rs = dbOp.getAllSubjects();
		rs.next();
		assertEquals(rs.getInt("id"),1);
		assertEquals(rs.getString("name"),"Maths");
		rs.next();
		assertEquals(rs.getInt("id"),2);
		assertEquals(rs.getString("name"),"Science");
		rs.next();
		assertEquals(rs.getInt("id"),3);
		assertEquals(rs.getString("name"),"English");
	}
	@org.junit.Test
	public void test3() throws Exception{
		ResultSet rs = DbUtil.getConnection().createStatement().executeQuery("select id, name from subject");
		rs.next();
		assertEquals(rs.getInt("id"),1);
		assertEquals(rs.getString("name"),"Maths");
		rs.next();
		assertEquals(rs.getInt("id"),2);
		assertEquals(rs.getString("name"),"Science");
		rs.next();
		assertEquals(rs.getInt("id"),3);
		assertEquals(rs.getString("name"),"English");
	}
	public void helper1(ResultSet rs) throws SQLException {
		rs.next();
		assertEquals(rs.getInt("id"),1);
		assertEquals(rs.getString("student_name"),"John");
		assertEquals((int)rs.getFloat("score"),67);
		assertEquals(rs.getInt("subject_id"), 1);
		rs.next();
		assertEquals(rs.getInt("id"),2);
		assertEquals(rs.getString("student_name"),"Smith");
		assertEquals((int)rs.getFloat("score"),89);
		assertEquals(rs.getInt("subject_id"), 2);
	}
	@org.junit.Test
	public void test4() throws Exception{
		dbOp.insertStudent("John", 67, "Maths");
		dbOp.insertStudent("Smith", 89, "Science");
		ArrayList record = dbOp.getStudentyId(1);
		assertEquals(record.get(0), 1);
		assertEquals(record.get(1), "John");
		assertEquals(record.get(2), 67.0f);
		assertEquals(record.get(3), 1);
		ResultSet rs = dbOp.getAllStudents();
		helper1(rs);
	}
//	@org.junit.Test
//	public void test5() throws Exception{
//		ResultSet rs = DbUtil.getConnection().createStatement().executeQuery("select id, first_name,last_name, score, subject_name from student");
//		helper1(rs);
//	}
	
}