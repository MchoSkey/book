package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Util.JDBCUtil;
import bean.Book;
import dao.BookDao;
/**
 * 这是bookDao的是具体实现，针对dao接口完成具体的跟数据库打交道
 * @author Administrator
 *
 */
public class BookDaoImpl implements BookDao{
	DataSource dataSource = JDBCUtil.getDataSource();
	QueryRunner query = new QueryRunner(dataSource);
	
/*
 * 跟数据库打交道。查询所有数据
 */
	@Override
	public List<Book> findAll() throws Exception {
		String sql ="select * from book";
		List<Book> list = query.query(sql, new BeanListHandler<Book>(Book.class));
		return list;
	}

/*
 * 插入一条数据
 */
	@Override
	public void insert(Book book) throws SQLException {
		String sql = "insert into book value(null,?,?,?,?)";
		query.update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getDescription());
		System.out.println("插入一条成功");
	}
/*
 * 删除的方法
 */
	@Override
	public void delete(String id) throws SQLException {
		query.update("delete from book where id = ?", id);
		
	}
/*
 * 根据ID查询一条数据
 */
	@Override
	public Book findById(String id) throws SQLException {
		Book book = query.query("select * from book where id = ?", new BeanHandler<Book>(Book.class),id);
		return book;
	}
/*
 * 更新数据
 */
	@Override
	public void update(Book book) throws SQLException {
		String sql = "update book set name = ? , author = ? , price= ? ,description = ? where id = ? " ;
		query.update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getDescription(),book.getId());
		System.out.println("更新第"+book.getId()+"成功---------------");
	}
/*
 * 按照书名或者作者名进行模糊查询
 */
	@Override
	public List<Book> search(String name, String author) throws SQLException {
		//这里要分析一下。
		/*
		 * 如果只有姓名：select * from book where name like ?;
		 * 如果只有作者名：select * from book where author like ?;
		 * 如果两个都有： select * from book where name like ? and author like ?;
		 * 如果两个都没有:select * from book;
		 */
		String sql = "select * from book where 1 =1 ";
		//弄个集合进行拼接
		ArrayList<String> list = new ArrayList<String>();
		if (!name.isEmpty()) {
			sql = sql + "and name like ?";
			list.add("%" + name +"%");
		}
		if (!author.isEmpty()) {
			sql = sql + "and author like ?";
			list.add("%" + author +"%");
		}
		System.out.println("最终的模糊查询的是：：：：：：：："+sql);
		return query.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
	}
/*
 * 查数据库一共有多少记录
 */
	@Override
	public int findCount() throws SQLException {
		String sql = "select count(*) from book "; 
		Long res = (Long) query.query(sql, new ScalarHandler());
		return  res.intValue();
	}
/*
 * 查询当前页包含的书籍信息
 */
	@Override
	public List<Book> findByPage(int currentPage) throws SQLException {
		String sql = "select * from book limit ? offset ? ";
		/*
		 * 第一个问号  返回几条记录  第二个问号  跳过前面多少条
		 * 1----------5  (1-1)*0
		 * 2----------5  (2-1)*5
		 * 3----------5  (3-1)*5
		 */
		return query.query(sql, new BeanListHandler<Book>(Book.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
	}

}
