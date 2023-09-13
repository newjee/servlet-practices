<%@ page import="com.poscodx.emaillist01.vo.GuestBookVo" %>
<%@ page import="com.poscodx.emaillist01.dao.GuestBookDao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String no = request.getParameter("no");
	String password = request.getParameter("password");

	GuestBookVo vo = new GuestBookVo();
	vo.setNo(Long.valueOf(no));
	vo.setPassword(password);

	new GuestBookDao().delete(vo);


	response.sendRedirect("/guestbook/deleteform.jsp");
%>