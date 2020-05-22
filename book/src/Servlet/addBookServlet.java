package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import service.BookService;
import service.impl.BookServiceImpl;

/**
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBookServlet")
public class addBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取参数封装成对象
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		Book book = new  Book( name, author, price, description);
		//添加到数据库
		BookService service = new BookServiceImpl();
		try {
			service.insert(book);
			//插入成功后跳转到列表页。但是要再查一次数据库然后才跳转，所以应该请求servlet而不是直接去jsp
			request.getRequestDispatcher("BookListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
