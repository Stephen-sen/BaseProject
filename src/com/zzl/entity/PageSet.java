package com.zzl.entity;


public class PageSet {
	int pageSize=10;//每页多少条
	long totalPage;//一共多少页
	int currentPage = 1;//当前第几页
	long resultCount;//总共多少条
	int maxPageSize = 10000;//最多有几条
	String querySql;//执行查询的sql语句
	String from;//当前页是从第几条开始
	String to;//当前页是到第几条
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getResultCount() {
		return resultCount;
	}
	public void setResultCount(long resultCount) {
		this.resultCount = resultCount;
	}
	public int getMaxPageSize() {
		return maxPageSize;
	}
	public void setMaxPageSize(int maxPageSize) {
		this.maxPageSize = maxPageSize;
	}
	public String getQuerySql() {
		return querySql;
	}
	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	
}
