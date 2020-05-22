package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import service.BookService;
import service.impl.BookServiceImpl;

/**
 * 用来出来模糊查询
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取需要查询的关键数据
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		System.out.println(name+":"+author);
		BookService service = new BookServiceImpl();
		try {
			List<Book> list = service.search(name,author);
			//放域对象中然后跳转
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
