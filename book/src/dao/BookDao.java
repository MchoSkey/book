package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Book;

/*
 * 对book表的所有操作
 */
public interface BookDao {
	
	int PAGE_SIZE = 5;//每页显示5条记录
	
	
	//查询 所有book。返回集合
	List<Book> findAll()  throws Exception ;

	void insert(Book book) throws SQLException ;

	void delete(String id) throws SQLException;

	Book findById(String id) throws SQLException;

	void update(Book book)throws SQLException;

	List<Book> search(String name, String author) throws SQLException ;

	int findCount() throws SQLException ;

	List<Book> findByPage(int currentPage)throws SQLException;

}
