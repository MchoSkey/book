package service.impl;

import java.sql.SQLException;
import java.util.List;

import bean.Book;
import bean.PageBean;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

public class BookServiceImpl implements BookService {
	
	
	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public List<Book> findAll() throws Exception {
		
		return bookDao.findAll();
	}

	@Override
	public void insert(Book book) throws Exception {
		bookDao.insert(book);
		
	}

	@Override
	public void delete(String id)  throws SQLException{
		bookDao.delete(id) ;
		
	}

	@Override
	public Book findById(String id) throws SQLException {
		
		return bookDao.findById(id);
	}

	@Override
	public void update(Book book) throws SQLException {
		bookDao.update(book) ;
	}

	@Override
	public List<Book> search(String name, String author) throws SQLException {
		return bookDao.search(name,author);
	}
/*
 * 封装分页的数据。
 * 这里体现了服务层的优势，一个service可以调用多个dao进行数据的获取和封装
 */
	@Override
	public PageBean findByPage(int currentPage) throws SQLException {
		PageBean<Book> pageBean = new PageBean<Book>();
		//属性分别：currentPage  totalPage pageSize totalSize list
		//挨个给属性进行封装
		pageBean.setCurrentPage(currentPage);
		int paseSize = bookDao.PAGE_SIZE;
		pageBean.setPageSize(paseSize);
		// totalSize 数据库里一共 有多少数据呢。需要dao查出来
		int totalSize = bookDao.findCount();
		pageBean.setTotalSize(totalSize);
		
		//有多少页。总记录 totalSize 除以每页几条pageSize  关键是否能整除
		int totalPage = totalSize%paseSize==0 ? totalSize/paseSize : (totalSize/paseSize+1);
		pageBean.setTotalPage(totalPage);
		
		//设置当前页的学生数据
		List<Book> list = bookDao.findByPage(currentPage);
		pageBean.setList(list);
		
		return pageBean;
	}

}
