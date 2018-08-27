package com.bdi.mvc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.UserService;
import com.bdi.mvc.service.impl.UserServiceImpl;
import com.bdi.mvc.vo.User;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("userList")) {
			List<User> userList = us.getUserList(null);
			request.setAttribute("list", userList);
		}else if(cmd.equals("userView") || cmd.equals("userUpdate")) {
			int uiNo = Integer.parseInt(request.getParameter("uiNo"));
			request.setAttribute("user", us.getUser(uiNo));
		}else if(cmd.equals("userInsert")) {
			
		}else if(cmd.equals("userUpdate")) {
			
		}else if(cmd.equals("userDelete")) {
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		if(cmd.equals("userInsert")) {
			String uiName = request.getParameter("uiName");
			String uiId = request.getParameter("uiId");
			String uiPwd = request.getParameter("uiPwd");
			String uiDesc = request.getParameter("uiDesc");
			int uiAge = Integer.parseInt(request.getParameter("uiAge"));
			int diNo = Integer.parseInt(request.getParameter("diNo"));
			User ue = new User(0,
					uiName,
					uiId,
					uiPwd,
					uiDesc,
					uiAge,
					diNo);
			request.setAttribute("rMap",us.userInsert(ue));
		}else if(cmd.equals("userUpdate")) {
			int uiNo = Integer.parseInt(request.getParameter("uiNo"));
			String uiName = request.getParameter("uiName");
			String uiId = request.getParameter("uiId");
			String uiPwd = request.getParameter("uiPwd");
			String uiDesc = request.getParameter("uiDesc");
			int uiAge = Integer.parseInt(request.getParameter("uiAge"));
			int diNo = Integer.parseInt(request.getParameter("diNo"));
			User ue = new User(uiNo,
					uiName,
					uiId,
					uiPwd,
					uiDesc,
					uiAge,
					diNo);
			request.setAttribute("rMap",us.userUpdate(ue));
		}else if(cmd.equals("userDelete")) {
			int uiNo = Integer.parseInt(request.getParameter("uiNo"));
			request.setAttribute("rMap", us.userDelete(uiNo));
			uri = "/views/user/userView";
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
