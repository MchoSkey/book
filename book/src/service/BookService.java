package service;

import java.sql.SQLException;
import java.util.List;

import bean.Book;
import bean.PageBean;

public interface BookService {

	List<Book> findAll() throws Exception;

	void insert(Book book) throws Exception;

	void delete(String id) throws SQLException;

	Book findById(String id) throws SQLException;

	void update(Book book) throws SQLException;

	List<Book> search(String name, String author) throws SQLException;

	PageBean findByPage(int currentPage) throws SQLException;

}
