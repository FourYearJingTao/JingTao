package validatorImpl;

import model.User;
import service.UserCheckService;
import util.ErrorList;
import validator.BaseValidator;
import Exception.BaseException;

public class UserExistValidator implements BaseValidator{
	private UserCheckService userCheckService;
	
	/**
	 * <p>ע��uerService</p>
	 * 
	 */
    public void setUserCheckService(UserCheckService userCheckService) {  
        this.userCheckService = userCheckService;  
    }
    
	/**
	 * <p>�����û����ǲ��� �Ѿ�����</p>
	 * 
	 */
	@Override
	public void validate(User user) {
		User u = userCheckService.checkUser(user);
		
		// if not found the u will be null
		if(null == u){
			throw new BaseException(ErrorList.UserName_Not_Exist);
		}
	}
}
