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
 * @Description �����ķ��ͽӿڵ�ʵ���࣬�̳���HibernateDaoSupport�Ա��ȡHibernateTemplateʵ����ICommonDao<T>
 * @Version V1.00
 * @CreateDate 2013-12-18
 */
public class CommonDaoImpl extends HibernateDaoSupport implements ICommonDao {
	/**
	 * @Description ͨ��ע��ķ�ʽ�õ�session������HibernateTemplate
	 * @param SessionFactory sessionFactory
	 * @return ��
	 */
	@Resource(name="sessionFactory")
	public final void setSessionFactoryDi(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	/** 
	 * @Description: ���¶���
	 * @param: entity
	 * @return ��
	 */
	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
	}
	/** 
	 * @Description: �������
	 * @param: entity
	 * @return ��
	 */
	public void save(Object entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	
	/**  
	* @Description: ���ݶ����ѯȫ�����ݣ�orderBy�ֶ����Ϊnull������
	* @param: entity
	* @Return: ���ض���
	*/
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findList(Class<T> c,String orderby){
		String queryString = "from "+c.getSimpleName()+(orderby==null?"":" order by "+orderby);
		return (List<T>)getHibernateTemplate().find(queryString);
	}
	
	
	/**  
	* @Description: ���ݶ����ѯȫ�����ݣ�orderBy�ֶ����Ϊnull������
	* @param: entity
	* @Return: ���ض���
	*/
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findList(Class<T> c,Map<String ,Object> map,String orderby){
		Object obj [] =new Object[map.size()];
		
		String where = "";
		
		//����ƴװwhere����
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
	* @Description: ����ID��ѯ���󣨷���Ψһ��ѯ�����
	* @CreateDate 2013-12-19
	*/
	@SuppressWarnings("unchecked")
	public <T> T findObjectByID(Class<T> t, Serializable id) {
		T instance = (T)getHibernateTemplate().get(t, id);
		return instance;
	}
	
	/**
	 * ����idɾ��ĳ����Ϣ
	 * @CreateDate 2013-12-25
	 */
	public <T> void deleteObjectByIDs(Class<T> t, Serializable id) {
		
			this.getHibernateTemplate().delete(findObjectByID(t,id));
	}
	
	
	
	/**
	 * ��ҳ��ѯ����Ҫ�����ѯ��sql��䣩���ڶ��������Ƿ��صĽ���Ƿ���map
	 * @CreateDate 2013-12-25
	 */
	public List query(PageSet page,boolean mapResult) {
		
		String sql = page.getQuerySql().trim();
		
		//���ȴ����ݿ��ѯ����һ���ж���������
		String countSQL = "select count(*) as resultCount "+sql.substring(sql.toLowerCase().indexOf("from"));
		
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(countSQL);
		
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		//��ѯ���ļ�¼�ж�����
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
	 * ��ĳ������ִ��saveOrUpdate
	 * @CreateDate 2013-12-25
	 */
	public void attachDirty(Object t) {
		getHibernateTemplate().merge(t);
	}
	
	
	/**
	 * ��ĳ�����󼯺�ִ��saveOrUpdate
	 * @CreateDate 2013-12-25
	 */
	public void saveOrUpdateAll(Collection cols){
		getHibernateTemplate().saveOrUpdateAll(cols);
	}
	
}
