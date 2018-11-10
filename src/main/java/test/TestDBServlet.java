//package com.test;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class TestDBServlet
// */
//@WebServlet("/TestDBServlet")
//public class TestDBServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			//setup user login
//			String user = "root";
//			String pass = "root";
//			
//			//db url
//			String jdbcUrl = "jdbc:mysql://localhost:8889/discussion_board_db?useSSL=false&serverTimezone=UTC";
//			String driver = "com.mysql.cj.jdbc.Driver";
//			
//			//test connection to db
//			try {
//				PrintWriter out = response.getWriter();
//				out.println("Connecting to database "+ jdbcUrl);
//				Class.forName(driver);
//				Connection connection = DriverManager.getConnection(jdbcUrl, user,pass);
//				out.println("SUCCESS!");
//				connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new ServletException(e);
//			}
//		
//	}
//
//}
