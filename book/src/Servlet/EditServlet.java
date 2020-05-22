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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要修改的是哪个数据。查出来，方便回显
		String id = request.getParameter("id");
		//根据这个id去查数据。
		BookService service  = new BookServiceImpl();
		try {
			Book  book = service.findById(id);
			//放进域对象，跳转，回显
			request.setAttribute("book", book);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
