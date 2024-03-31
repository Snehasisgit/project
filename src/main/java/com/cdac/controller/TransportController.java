package com.cdac.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.cdac.dto.PlaceBidData;
import com.cdac.encryption.PasswordEncryption;
import com.cdac.entity.Advertisement;
import com.cdac.entity.Bidding;
import com.cdac.entity.User;
import com.cdac.service.AdminService;
import com.cdac.service.CommonService;
import com.cdac.service.EmailService;
import com.cdac.service.TransporterService;
import com.cdac.service.UserService;



@RestController
@CrossOrigin
public class TransportController {
      
	
	@Autowired
	private TransporterService transporterService;
	
	
	
	@PostMapping("/placebid") 
	public CommonResponse placeBid(@RequestBody PlaceBidData data,@RequestParam("addid") int id) {
		return transporterService.placeBid(data,id);
	}
	
	@GetMapping("/getalladds")
    public List<Advertisement> getAllAdds(){
		return transporterService.getAllAdds();
	}
	
	@GetMapping("/getyourbids")
	public List<Bidding> getYourBids(@RequestParam("tid") int id){
		return transporterService.getYourBids(id);	
	}
	
	@DeleteMapping("/deletebid")
	public CommonResponse deleteBid(@RequestParam("bidid") int id ) {
		return transporterService.deleteBid(id);
	}
	
	
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

