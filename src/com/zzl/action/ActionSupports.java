package com.zzl.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @Name ActionSupports
 * @Description ��ȡrequest��response����
 * @author ������
 * @Version V1.00
 * @CreateDate 2013-12-18
 */
@SuppressWarnings("serial")
public class ActionSupports extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	HttpServletRequest request;
	HttpServletResponse response;
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
	}
	
	@Override
	
	public String execute() throws Exception {
		System.out.println("�������û���ҵ�");
		return "�������û��ִ�У���";
	}
	
	//��ȡ��ǰ�û�
	
	//��ȡsession
	

}
