package com.cdac.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.CommonResponse;
import com.cdac.entity.Bidding;
import com.cdac.entity.User;
import com.cdac.service.AdminService;
import com.cdac.service.EmailService;
import com.cdac.service.UserService;

@RestController
@CrossOrigin
public class AdminController {
	
	

	@Autowired
	private AdminService adminService;
	
	private static final Logger logger = LogManager.getLogger(TransportController.class);
	
	
	
	@GetMapping("/getfinalizedadds")
    public List<Bidding> getFinalizedAdds(){
		return adminService.getFinalizedAdds();
	}
	
	
	@GetMapping("/getallcustomers")
	public List<User> getAllCustomers(){
		return adminService.getAllCustomers();
	}
	
	@GetMapping("/getalltransporters")
	public List<User> getAllTransporters(){
		return adminService.getAllTransporters();
	}
	
	@DeleteMapping("deleteuser")
	public CommonResponse deleteUser(@RequestParam int id ) {
		 return adminService.deleteUser(id);
	}

}
