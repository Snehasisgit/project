package com.cdac.service;

import com.cdac.dto.CommonResponse;
import com.cdac.dto.ForgotPasswordIn;
import com.cdac.dto.ForgotPasswordOTP;
import com.cdac.dto.LoginDetails;
import com.cdac.entity.User;

public interface CommonServiceInterface {
	
	public CommonResponse  register (User obj);
	
	public User login (LoginDetails loginCred);
	
	public ForgotPasswordOTP forgotPassword(String email);

}
