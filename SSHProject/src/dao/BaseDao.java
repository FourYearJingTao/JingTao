package dao;

import org.hibernate.HibernateException;

public interface BaseDao {  
	/**
	 * <p>�洢һ���������ݿ���</p>
	 * 
	 */
	public void saveObject(Object obj) throws HibernateException;
	
	/**
	 * <p>����һ�� ����</p>
	 * 
	 */
	public Object checkObjet(String sql);
	
	/**
	 * <p>ɾ��һ�� ����</p>
	 * 
	 */
	public void deleteObject(String sql);
	
	/**
	 * <p>����һ�� ����</p>
	 * 
	 */
	public Object updateObject(Object obj);
}  