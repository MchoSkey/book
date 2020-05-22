package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;
import service.impl.BookServiceImpl;

/**
 * 负责查询所有的图书信息。显示到页面上
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	BookService service = new BookServiceImpl();
		try {
			List<Book> list = service.findAll();
			System.out.println(list);
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
