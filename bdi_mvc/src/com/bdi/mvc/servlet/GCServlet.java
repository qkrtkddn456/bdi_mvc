package com.bdi.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.GCService;
import com.bdi.mvc.service.impl.GCServiceImpl;
import com.bdi.mvc.vo.GC;

public class GCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GCService gs = new GCServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
			if(cmd.equals("gcList")) {
				List<GC> gcList = gs.getGCList(null);
				request.setAttribute("list", gcList);
			}else if(cmd.equals("gcView")) {
				String gcNumStr = request.getParameter("gcNo");
				GC gc = new GC();
				gc.setGcnum(Integer.parseInt(gcNumStr));
				request.setAttribute("gc", gs.getGC(gc.getGcnum()));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		try {
			if(cmd.equals("gcInsert")) {
				String gcName = request.getParameter("gcName");
				int gcPrice = Integer.parseInt(request.getParameter("gcPrice"));
				String gcVendor = request.getParameter("gcVendor");
				int gcOrder = Integer.parseInt(request.getParameter("gcOrder"));
				String gcDesc = request.getParameter("gcDesc");
				String gcImg = request.getParameter("gcImg");
				GC gc = new GC(0, gcName, gcPrice, gcVendor, gcOrder, gcDesc, gcImg);
				request.setAttribute("rMap", gs.insertGC(gc));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
