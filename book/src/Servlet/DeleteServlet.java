package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.impl.BookServiceImpl;

/**
 * 删除记录的servlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//获取删除的ID
		String id = request.getParameter("id");
		BookService service = new BookServiceImpl();
		try {
			service.delete(id);
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
