package com.tingche.action;	
	
import java.io.IOException;	
import java.io.PrintWriter;	
import java.sql.Connection;	
import java.sql.SQLException;	
import java.sql.Statement;	
	
import javax.servlet.ServletException;	
import javax.servlet.http.HttpServlet;	
import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import com.tingche.db.DBManager;	
	
/**
 *
 */
public class DelCfeiAction extends HttpServlet {	
	
	/**	
	 * Constructor of the object.	
	 */	
	public DelCfeiAction() {	
		super();	
	}	
	
	/**	
	 * Destruction of the servlet. <br>	
	 */	
	public void destroy() {	
		super.destroy(); // Just puts "destroy" string in log	
		// Put your code here	
	}	
	
	/**	
	 * The doGet method of the servlet. <br>	
	 * 	
	 * This method is called when a form has its tag value method equals to get.	
	 * 	
	 * @param request	
	 *            the request send by the client to the server	
	 * @param response	
	 *            the response send by the server to the client	
	 * @throws ServletException	
	 *             if an error occurred	
	 * @throws IOException	
	 *             if an error occurred	
	 */	
	public void doGet(HttpServletRequest request, HttpServletResponse response)	
			throws ServletException, IOException {	
	
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();	
		String id = request.getParameter("id");	
	
		DBManager dbm = new DBManager();	
		//删除车费
		String sql = "delete from cfei where id="+id;	
	
		Statement stat = null;	
		Connection conn = null;	
		try {	
			conn = dbm.getConnection();	
			stat = conn.createStatement();	
			stat.execute(sql);	
		 	
		} catch (SQLException e) {	
			// TODO Auto-generated catch block	
			e.printStackTrace();	
		} finally {	
			try {	
				if (stat != null)	
					stat.close();	
				if (conn != null)	
					conn.close();	
			} catch (SQLException e) {	
				// TODO Auto-generated catch block	
				e.printStackTrace();	
			}	
		}	
		response.sendRedirect("cfei/list.jsp");	
		out.flush();	
		out.close();	
	}	
	
	/**	
	 * Initialization of the servlet. <br>	
	 * 	
	 * @throws ServletException	
	 *             if an error occurs	
	 */	
	public void init() throws ServletException {	
		// Put your code here	
	}	
	
}	
