package com.zzl.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.zzl.entity.PageSet;

/**
 * @Name ICommonDao<T>
 * @Description 公共的泛型接口
 * @Version V1.00
 * @CreateDate 2013-12-18
 */
public interface ICommonDao {

	
	void update(Object entity);
	
	void save(Object entity);
	
	<T> List<T> findList(Class<T> c,String orderby);
	
	<T> List<T> findList(Class<T> c,Map<String ,Object> map,String orderby);
	
	<T> T findObjectByID(Class<T> t, Serializable id);
	
	<T> void deleteObjectByIDs(Class<T> t, Serializable id);
	
	List query(PageSet page,boolean mapResult);
	
	void attachDirty(Object t);
	
	void saveOrUpdateAll(Collection cols);
}

