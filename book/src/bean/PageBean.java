package bean;
/*
 * 用来封装分页的数据
 * 包含
 * 该页面的学生集合数据，比如三条或者五条
 * 总的记录数
 * 总的页面数
 * 当前是第几页
 * 每页显示几条
 */

import java.util.List;

public class PageBean<T>{
	private int currentPage;//当前页
	private int totalPage;//总页数
	private int pageSize;//每页的记录数
	private int totalSize;//总的记录数
	private List<T> list;//当前页的学生集合
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int currentPage, int totalPage, int pageSize, int totalSize, List<T> list) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.list = list;
	}

	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", totalPage=" + totalPage + ", pageSize=" + pageSize
				+ ", totalSize=" + totalSize + ", list=" + list + "]";
	}
	
	
	
}
