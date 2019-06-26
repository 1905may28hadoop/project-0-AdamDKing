package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Handling a GET");
		// We have a lot of options available to read and respond to requests
		// we can start with basic text response:
		
		//to write to a response, we get a PrintWriter from the response object:
		PrintWriter pw = resp.getWriter();
		//then we can use the writer to write lines to the response body:
		//pw.write("Hello from the Servlet!");
		//we can write HTML to the response and the clients' browser will render it
		pw.write("<html><h1>Hello from HTML from Servlet</h1>"
				+ "<h2><a href=\"index.html\">Link!</a></h2></html>");
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Handling a POST");
		//we can get parameters from a POST with req.getParameter
		String color;
		color = req.getParameter("color");
		System.out.println("received color: " + color);
		//let's use that input to dynamically serve a different html snippet:
		resp.getWriter().write("<html><body style=\"background-color:"+color+"\">"
				+ "<h1>Dynamic html from Servlet!</h1></body></html>");
	}
	
	@Override
	public void init() throws ServletException {
		//log, then run the parent class's method anyway.
		System.out.println("Init method for HelloServlet");
		super.init();
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method for HelloServlet");
		super.destroy();
	}
	
	//Don't override service, but lets do it here so we can see:
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Service method for HelloServlet");
		super.service(req, res);
	}

}
