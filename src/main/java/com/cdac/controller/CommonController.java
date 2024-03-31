package com.cdac.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.CommonResponse;
import com.cdac.dto.ForgotPasswordIn;
import com.cdac.dto.ForgotPasswordOTP;
import com.cdac.dto.LoginDetails;
import com.cdac.entity.User;
import com.cdac.service.CommonService;
import com.cdac.service.EmailService;
import com.cdac.service.UserService;

@RestController
@CrossOrigin
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private EmailService emailService;
	
	private static final Logger logger = LogManager.getLogger(TransportController.class);
	
	@PostMapping("/login")
	public User login(@RequestBody LoginDetails loginCred) {
		return commonService.login(loginCred);
	}
	
	@PostMapping("/register")
	public CommonResponse register(@RequestBody User obj) {
		return commonService.register(obj);
	}
	
	
	
	
	@GetMapping("/otp")
	public ForgotPasswordOTP forgotPassword(@RequestParam("email") String email ) {	
		return commonService.forgotPassword(email);	
	}
	
	@PutMapping("/changepassword")
	public CommonResponse changePassword(@RequestBody LoginDetails obj) {
		return commonService.changePassword(obj);
	}
	


}
