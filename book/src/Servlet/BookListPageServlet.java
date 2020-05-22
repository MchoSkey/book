package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.BookService;
import service.impl.BookServiceImpl;

/**
 * 分页显示数据
 */
@WebServlet("/BookListPageServlet")
public class BookListPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前页是第几页
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//根据指定的页数，去获取该页的数据
		BookService service = new BookServiceImpl();
		try {
			PageBean pageBean = service.findByPage(currentPage);
			//设置与对象 跳转
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
