package service;

import model.User;

public interface UserModifyService {
	/**
	 * <p>�޸���Ϣ</p>
	 * 
	 */
	public User modifyInfo(User u);
	
	/**
	 * <p>�޸�����</p>
	 * 
	 */
	public User modifyPsw(User u,String newPsw);
}
