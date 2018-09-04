package com.bdi.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.common.UploadFiles;
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
			}else if(cmd.equals("gcView") || cmd.equals("gcUpdate")) {
				String gcNumStr = request.getParameter("gcNum");
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
			if(cmd.equals("gcInsert")) {Map<String,String> param = UploadFiles.saveFileList(request);
			if(param.isEmpty()) {
				new ServletException("파일 저장이 실패하였습니다.");
			}
			String gcName = param.get("gcName");
			String gcPrice = param.get("gcPrice");
			String gcVendor = param.get("gcVendor");
			String gcDesc = param.get("gcDesc");
			String gcImg = param.get("gcImg");
			GC game = new GC(0,
					gcName,
					Integer.parseInt(gcPrice),
					gcVendor,
					0,
					gcDesc,
					gcImg
					);
			//게임서비스에서 game목록을 인서트 함수를 호출해준다.
			Map<String,Object> rMap = gs.insertGC(game);
			//해당 리스트를 포워딩할 jsp에서 포문을 돌리며 출력해주기위해
			//rMap라는 키값을 저장한다.
			request.setAttribute("rMap", rMap);
			}else if(cmd.equals("gcUpdate")) {
				int gcNum = Integer.parseInt(request.getParameter("gcNum"));
				String gcName = request.getParameter("gcName");
				int gcPrice = Integer.parseInt(request.getParameter("gcPrice"));
				String gcVendor = request.getParameter("gcVendor");
				int gcOrder = Integer.parseInt(request.getParameter("gcOrder"));
				String gcDesc = request.getParameter("gcDesc");
				String gcImg = request.getParameter("gcImg");
				GC gc = new GC(gcNum, gcName, gcPrice, gcVendor, gcOrder, gcDesc, gcImg);
				request.setAttribute("rMap", gs.updateGC(gc));
			}else if(cmd.equals("gcDelete")) {
				GC gc = new GC(Integer.parseInt(request.getParameter("gcNum")), null, 0, null, 0, null, null);
				request.setAttribute("rMap", gs.deleteGC(gc));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
