<?xml version="1.0" encoding="euc-kr" ?>
<%@ page contentType = "text/xml; charset=euc-kr" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "util.DB" %>
<%@ page import = "util.Util" %>
<% 
	
	request.setCharacterEncoding("utf-8");
	String nickName = request.getParameter("nickName");
	String msg = request.getParameter("msg");
	String message = "["+nickName+"] "+msg;
	
	System.out.println(message);
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	boolean isSuccess = true;
	
	try {
		conn = DB.getConnection();
		
		System.out.println(conn);
		pstmt = conn.prepareStatement(
			"insert into CHAT_MESSAGE "+
			"values (chat_seq.nextval, ?, sysdate, ?)");
		pstmt.setString(1, nickName);
		pstmt.setString(2, message);
		pstmt.executeUpdate();
		
		System.out.println("완료했냐??");
	} catch(SQLException ex) {
		isSuccess = false;
	} finally {
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
%>
<result>
	<code><%= isSuccess ? "success" : "fail" %></code>
</result>
