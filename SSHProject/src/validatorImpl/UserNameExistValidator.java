package validatorImpl;

import Exception.BaseException;
import model.User;
import service.UserCheckService;
import service.UserRegisterService;
import util.ErrorList;
import validator.BaseValidator;

public class UserNameExistValidator implements BaseValidator{
	
	/**
	 * <p>�����û����ǲ��� �Ѿ�����</p>
	 * 
	 */
	@Override
	public void validate(User user) {
		// if not found the u will be null
		if(null != user){
			//throw new BaseException(ErrorList.UserName_Is_Exist);
		}
	}
}
