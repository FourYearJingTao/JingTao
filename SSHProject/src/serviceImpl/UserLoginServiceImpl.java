package serviceImpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import Exception.BaseException;
import model.User;
import daoImpl.UserDao;
import service.UserCheckService;
import service.UserLoginService;
import util.ErrorList;
import util.UserUtil;
import validator.BaseValidator;

public class UserLoginServiceImpl implements UserLoginService {
	private UserDao userDao;
	private List<BaseValidator> validators;
	private UserCheckService userCheckService;
	
	/**
	 * <p>ע��userDao</p>
	 * 
	 */
	public void setUserDao(UserDao userdao) {  
	    this.userDao = userdao;  
	}
	
	/**
	 * <p>ע��userCheckService</p>
	 * 
	 */
	public void setUserCheckService(UserCheckService userCheckService) {  
	    this.userCheckService = userCheckService;  
	}
	/**
	 * <p>ע��validators</p>
	 * 
	 */
	public void setValidators(List<BaseValidator> validators) {
		this.validators = validators;
	}
	
	/**
	 * <p>��½����</p>
	 * 
	 */
	@Override
	public User login(User u) {
		//check the user from DB
		User user = userCheckService.checkUser(u);
		
		if(null == user || user.getState()==UserUtil.disable){
			//username not exist
			throw new BaseException(ErrorList.UserName_Not_Exist);
		}
		if(user.getState()==UserUtil.pause){
			//user temporaily close
			throw new BaseException(ErrorList.Temporarily_Closed);
		}
		if(StringUtils.equals(u.getPassword(), user.getPassword())){
			//password not equal 
			throw new BaseException(ErrorList.Password_not_Correct);
		}
		
		return user;
	}
}
