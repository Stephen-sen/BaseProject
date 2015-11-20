package com.zzl.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zzl.dao.IUserDao;
import com.zzl.entity.FjwzUser;
import com.zzl.util.SaxBeans;

@Component
public class UserAction extends ActionSupports {
	
	//Dao≤„∂‘œÛ
	@Resource
	private IUserDao userDao; 
	
	
	/*IUserDao userDao=(IUserDao) SaxBeans.getBean("000");*/	
	
	public List<FjwzUser> userList;
	
	public String findAllUser(){
		
		userList = userDao.findList(FjwzUser.class, null);
		
		return SUCCESS;
	}

}
