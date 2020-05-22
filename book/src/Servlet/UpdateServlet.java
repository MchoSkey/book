package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import service.BookService;
import service.impl.BookServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数。封装数据
		request.setCharacterEncoding("utf-8");
		//获取参数封装成对象
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		Book book = new Book(id, name, author, price, description);
		//去数据库进行更新
		
		BookService service = new BookServiceImpl();
		try {
			service.update(book);
			request.getRequestDispatcher("BookListServlet").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
