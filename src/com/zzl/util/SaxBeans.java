package com.zzl.util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @Name SaxBeans
 * @Description 解析beans.xml的类
 * @author 邵云鹏
 * @Version V1.00
 * @CreateDate 2013-12-18
 */
public class SaxBeans{
	public static ApplicationContext ac;
	static{
		 ac=new ClassPathXmlApplicationContext("beans.xml");
	}
	/**
	 * @Name getBean获取bean对象的方法
	 * @author 邵云鹏
	 * @Version V1.00
	 * @CreateDate 2013-12-18
	 * @parameters String BeanName
	 * @return Object
	 */
	public static Object getBean(String BeanName){
		return ac.getBean(BeanName);
	}

}
