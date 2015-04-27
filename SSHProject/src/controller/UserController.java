package controller;


import java.util.Map;

import service.UserDeleteService;
import service.UserLoginService;
import service.UserModifyService;
import service.UserRegisterService;
import util.UserUtil;
import model.User;
import model.UserDTO;
import Exception.BaseException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import converter.UserConverter;

public class UserController extends ActionSupport {
		//private Map<String,Object> sessionContext = ActionContext.getContext().getSession();
		//service
	    private UserRegisterService userRegisterService;
	    private UserLoginService userLoginService;
	    private UserModifyService userModifyService;
	    private UserDeleteService userDeleteService;
	    
	    private UserConverter userConverter;
	    private UserDTO userDTO;
	    
	    
	    /**
		 * <p>ע��userRegisterService</p>
		 * 
		 */
	    public void setUserRegisterService(UserRegisterService userRegisterService) {  
	        this.userRegisterService = userRegisterService;  
	    }
	    
	    /**
		 * <p>ע��userLoginService</p>
		 * 
		 */
	    public void setUserLoginService(UserLoginService userLoginService) {  
	        this.userLoginService = userLoginService;  
	    }
	    
	    /**
		 * <p>ע��UserModifyService</p>
		 * 
		 */
		public void setUserModifyService(UserModifyService userModifyService){
			this.userModifyService = userModifyService;
		}
		
		/**
		 * <p>ע��UserConverter</p>
		 * 
		 */
		public void setUserDeleteService(UserDeleteService userDeleteService) {
			this.userDeleteService = userDeleteService;
		}
		
	    /**
		 * <p>ע��UserConverter</p>
		 * 
		 */
		public void setUserConverter(UserConverter userConverter) {
			this.userConverter = userConverter;
		}
		
	    /**
		 * <p>�û�ע��</p>
		 */
	    public String register() {
	        try {
	        	//1.convert the userDTO to user
        		User user = userConverter.registerConverter(userDTO);
        		
        		//2.involk userService to save the user
        		userRegisterService.saveUser(user);
	        } catch (BaseException e) {
	        	String errorMessage = e.getMessage();
	        	System.out.println(errorMessage);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return SUCCESS;
	    }
	    
	    /**
		 * <p>�û���½</p>
		 * 
		 */
	    public String login() {
	    	
	        try {
	        	//1.primary check and convert
		    	User user = userConverter.loginConverter(userDTO);
		    	
		    	//2.get the user info from database
		    	User u = userLoginService.login(user);
		    	
		    	//3.convert the user to userDTO
		    	
		    	//4.set the log in state to session and return the userDTO
		    	//sessionContext.put("userId",u.getUserId());
		    	//sessionContext.put("userName", u.getUsername());
	        } catch (BaseException e) {
	        	String errorMessage = e.getMessage();
	        	System.out.println(errorMessage);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return SUCCESS;
	    }
	    
	    /**
		 * <p>�û������޸�</p>
		 * 
		 */
	    public String modifyInfo() {
	    	this.userDTO.setGender(UserUtil.female);
	    	this.userDTO.setAddress("�й�");
	    	this.userDTO.setIdCardNo("123123123123123");
	    	this.userDTO.setUserId("297e5af94b7941b6014b7942b6ca0000");
	    	
	    	try {
		    	//1.convert the userDTO to user
		    	User user = userConverter.modifyConverter(userDTO);
		    	user.setPassword("12322");
		    	//2.save the new info to db
		    	this.userModifyService.modifyInfo(user);
	    	} catch (BaseException e) {
	        	String errorMessage = e.getMessage();
	        	System.out.println(errorMessage);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    	
	    	return SUCCESS;
	    }
	    
	    /**
		 * <p>�޸�����</p>
		 * 
		 */
	    public String modifyPassword() {
	    	String flag = "error";
	    	try {
        		//convert userDto to user for password
        		User user = userConverter.modifyPswConverter(userDTO);
        		//2.save the new password to db
        		this.userModifyService.modifyInfo(user);
        		
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "error";
	        }
	        
	        return flag;
	    }
	    
	    /**
		 * <p>ɾ���û�</p>
		 * 
		 */
	    public String deleteUser() {
	        try {
        		//if user is login convert the userDTO to user
	        	User user = userConverter.deleteUserConverter(userDTO);
        		//delete the user from DB
	        	userDeleteService.deleteUser(user);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return SUCCESS;
	    }
	   
	    
	    /**
		 * <p>��ȡuserDTO</p>
		 * 
		 */
		public UserDTO getUserDTO() {
			return userDTO;
		}

		/**
		 * <p>ע��userDTO</p>
		 * 
		 */
		public void setUserDTO(UserDTO userDTO) {
			this.userDTO = userDTO;
		}
}