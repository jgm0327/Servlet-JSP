package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.vo.MemberVO;
public class MemberDAO {

	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		}catch(Exception ex) {
			System.out.println("오류 발생: " + ex);
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception ex) {
				System.out.println("오류 발생: " + ex);
			}
		}
		close(con, pstmt);
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception ex) {
				System.out.println("오류 발생: " + ex);
			}
		}
		
		if(con != null) {
			try {
				con.close();
			}catch(Exception ex) {
				System.out.println("오류 발생: " + ex);
			}
		}
	}
	
	public void memberInsert(MemberVO member) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = connect();
			pstmt = con.prepareStatement("insert into member values (?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			pstmt.executeUpdate();
		}catch(Exception ex) {
			System.out.println("오류 발생: " + ex);
		}finally {
			close(con, pstmt);
		}
	}
	public MemberVO memberSearch(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		
		try {
			con = connect();
			pstmt = con.prepareStatement("select * from member where id=?");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMail(rs.getString(4));
			}
		}catch(Exception ex) {
			System.out.println("오류 발생: " + ex);
		}finally {
			close(con, pstmt, rs);
		}
		return member;
	}
	
	public void memberUpdate(MemberVO member) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = connect();
			pstmt = con.prepareStatement("update member set passwd=?, name=?, mail=? where id=?");
			pstmt.setString(1,member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMail());
			pstmt.setString(4, member.getId());
			pstmt.executeUpdate();
		}catch(Exception ex) {
			System.out.println("오류 발생: " + ex);
		}finally {
			close(con, pstmt);
		}
	}
	
	public void memberDelete(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = connect();
			pstmt = con.prepareStatement("delete from member where id=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception ex) {
			System.out.println("오류 발생: " + ex);
		}finally {
			close(con, pstmt);
		}
	}
	
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		try {
			System.out.println("entered");
			con = connect();
			pstmt = con.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMail(rs.getString(4));
				System.out.println(" " + member);
				list.add(member);
			}
		}catch(Exception ex) {
			System.out.println("오류 발생: " + ex);
		}finally {
			close(con, pstmt, rs);
		}
		System.out.println(" " + list);
		return list;
	}
}
