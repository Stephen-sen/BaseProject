package com.zzl.entity;


public class PageSet {
	int pageSize=10;//ÿҳ������
	long totalPage;//һ������ҳ
	int currentPage = 1;//��ǰ�ڼ�ҳ
	long resultCount;//�ܹ�������
	int maxPageSize = 10000;//����м���
	String querySql;//ִ�в�ѯ��sql���
	String from;//��ǰҳ�Ǵӵڼ�����ʼ
	String to;//��ǰҳ�ǵ��ڼ���
	
	
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
