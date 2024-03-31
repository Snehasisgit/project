package com.cdac.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.controller.TransportController;
import com.cdac.dto.CommonResponse;
import com.cdac.dto.ForgotPasswordIn;
import com.cdac.dto.ForgotPasswordOTP;
import com.cdac.dto.LoginDetails;
import com.cdac.encryption.PasswordEncryption;
import com.cdac.entity.User;
import com.cdac.exception.UserServiceException;
import com.cdac.repository.AdminRepository;
import com.cdac.repository.CommonRepository;
import com.cdac.repository.TransporterRepository;
import com.cdac.repository.UserRepository;

@Service
@Transactional
public class CommonService  implements CommonServiceInterface{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommonRepository commonRepository;
	
	@Autowired
	private EmailService emailService;
	
	private static final Logger logger = LogManager.getLogger(CommonService.class);
	
	
	@Override
	public CommonResponse register (User obj) {
	      try {
	    		if(commonRepository.isAccountPresent(obj.getEmail()))
					throw new UserServiceException("Email Already Registered!!!");
	    		
				obj.setPass(PasswordEncryption.getMd5(obj.getPass()));
					userRepository.save(obj);
				CommonResponse response = new CommonResponse();
				response.setStatus(true);
				response.setMsg("Registration Succefull!");
				logger.info(obj.getEmail()+"  New User Registration ");
					try {  // registration mail 
					       emailService.sendEmailForNewRegistration(obj.getEmail()); 
					}catch(Exception e){ System.out.println("email failed");}	
			return response;
			}
			catch(Exception e ) {
				CommonResponse response = new CommonResponse();
				response.setStatus(false);
				response.setMsg("Email Already Registered !!");
				return response;
			}
		}
	
	@Override
	public User login (LoginDetails loginCred) {
		try {
			loginCred.setPassword(PasswordEncryption.getMd5(loginCred.getPassword()));
			User user =commonRepository.findByEmailAndPassword(loginCred.getEmail(), loginCred.getPassword());
			
			logger.info(loginCred.getEmail()+"  User is trying to login. ");
		
		try { 
				emailService.sendEmailForLogin(loginCred.getEmail());
		}catch(Exception e ) { }
			return user;
		}
		catch(Exception e) {
			return null;
		}		
	}
	
	@Override
	public ForgotPasswordOTP forgotPassword(String email) {
		
		try {
			if(!commonRepository.isAccountPresent(email)) {
				throw new UserServiceException("User Not registered with us ");
			}

			int otp = emailService.generateOTP();
			try {
			emailService.sendOTP(email,otp);
			}catch(Exception e) {}
		
			ForgotPasswordOTP res = new ForgotPasswordOTP();
			res.setOtp(otp);
			return res;
		}catch(Exception e) {
			ForgotPasswordOTP res = new ForgotPasswordOTP();
			res.setOtp(-1);
			return res;
		}
		
	}

	public CommonResponse changePassword(LoginDetails obj) {
		try {
			commonRepository.changePassword(obj.getEmail(),PasswordEncryption.getMd5(obj.getPassword()));
			CommonResponse response = new CommonResponse();
			response.setStatus(true);
			response.setMsg("Password changed !");
			logger.warn(obj.getEmail()+"  Password changed ");
			return response;
		}catch(Exception e ) {
			CommonResponse response = new CommonResponse();
			response.setStatus(false);
			response.setMsg("Something Went wrong ! ");
			return response;
		}
	
	
	}
	
	
	

}
