package com.zzl.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zzl.dao.ICommonDao;
import com.zzl.entity.PageSet;

/**
 * @Name CommonDaoImpl<T>
 * @Description 公共的泛型接口的实现类，继承了HibernateDaoSupport以便获取HibernateTemplate实现了ICommonDao<T>
 * @Version V1.00
 * @CreateDate 2013-12-18
 */
public class CommonDaoImpl extends HibernateDaoSupport implements ICommonDao {
	/**
	 * @Description 通过注解的方式得到session来生成HibernateTemplate
	 * @param SessionFactory sessionFactory
	 * @return 无
	 */
	@Resource(name="sessionFactory")
	public final void setSessionFactoryDi(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	/** 
	 * @Description: 更新对象
	 * @param: entity
	 * @return 无
	 */
	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
	}
	/** 
	 * @Description: 保存对象
	 * @param: entity
	 * @return 无
	 */
	public void save(Object entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	
	/**  
	* @Description: 根据对象查询全部数据，orderBy字段如果为null则不排序
	* @param: entity
	* @Return: 返回对象
	*/
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findList(Class<T> c,String orderby){
		String queryString = "from "+c.getSimpleName()+(orderby==null?"":" order by "+orderby);
		return (List<T>)getHibernateTemplate().find(queryString);
	}
	
	
	/**  
	* @Description: 根据对象查询全部数据，orderBy字段如果为null则不排序
	* @param: entity
	* @Return: 返回对象
	*/
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findList(Class<T> c,Map<String ,Object> map,String orderby){
		Object obj [] =new Object[map.size()];
		
		String where = "";
		
		//首先拼装where条件
		int i = 0;
		 for (String key : map.keySet()) {
			 
			 where = where+key+"= ? "; 
			 
			 obj[i] = map.get(key);
			 
			 i++;
			}
		
		String queryString = "from "+c.getSimpleName()+"  where "
				+ where + (orderby==null?"":" order by "+orderby);
		return (List<T>)getHibernateTemplate().find(queryString, orderby);
	}
	
	
	
	/**  
	* @Description: 根据ID查询对象（返回唯一查询结果）
	* @CreateDate 2013-12-19
	*/
	@SuppressWarnings("unchecked")
	public <T> T findObjectByID(Class<T> t, Serializable id) {
		T instance = (T)getHibernateTemplate().get(t, id);
		return instance;
	}
	
	/**
	 * 根据id删除某条信息
	 * @CreateDate 2013-12-25
	 */
	public <T> void deleteObjectByIDs(Class<T> t, Serializable id) {
		
			this.getHibernateTemplate().delete(findObjectByID(t,id));
	}
	
	
	
	/**
	 * 分页查询（需要传入查询的sql语句），第二个参数是返回的结果是否是map
	 * @CreateDate 2013-12-25
	 */
	public List query(PageSet page,boolean mapResult) {
		
		String sql = page.getQuerySql().trim();
		
		//首先从数据库查询出来一共有多少条数据
		String countSQL = "select count(*) as resultCount "+sql.substring(sql.toLowerCase().indexOf("from"));
		
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(countSQL);
		
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		//查询出的记录有多少条
		Object resultCount = ((Map)query.list().get(0)).get("resultCount");
		
		query = null;
		
		int curpage = page.getCurrentPage()-1;
		
		curpage = curpage < 0 ? 0 : curpage;
		
		sql = page.getQuerySql();
		
		query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sql);
		
		page.setResultCount(Long.parseLong((String) resultCount));
		
		if(mapResult)
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		query.setFirstResult(curpage*page.getPageSize()).setMaxResults(page.getPageSize());
		
		return query.list();
	}
	
	/**
	 * 对某个对象执行saveOrUpdate
	 * @CreateDate 2013-12-25
	 */
	public void attachDirty(Object t) {
		getHibernateTemplate().merge(t);
	}
	
	
	/**
	 * 对某个对象集合执行saveOrUpdate
	 * @CreateDate 2013-12-25
	 */
	public void saveOrUpdateAll(Collection cols){
		getHibernateTemplate().saveOrUpdateAll(cols);
	}
	
}
