package com.cdac.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.controller.TransportController;
import com.cdac.dto.CommonResponse;
import com.cdac.entity.Bidding;
import com.cdac.entity.User;
import com.cdac.repository.AdminRepository;
import com.cdac.repository.CommonRepository;
import com.cdac.repository.TransporterRepository;
import com.cdac.repository.UserRepository;

@Service
@Transactional
public class AdminService implements AdminServiceInterface {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommonRepository commonRepository;
	
	@Autowired
	private TransporterRepository transporterRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private EmailService emailService;
	
	
	
	private static final Logger logger = LogManager.getLogger(AdminService.class);
	
	@Override
	public List<Bidding> getFinalizedAdds() {
		try {
			return adminRepository.getFinalizedAdds();
		}
		catch(Exception e) {
	        	return null;
		}
	}

	
	@Override
	public List<User> getAllCustomers() {
		
		try {
			return adminRepository.getAllCustomers();
		}
		catch(Exception e ) {
			return null; 
		}	
	}
	
	@Override
	public List<User> getAllTransporters() {
		try {
			return adminRepository.getAllTransporters();
		}
		catch(Exception e ) {
			return null; 
		}	
	}
	
	@Override
	public CommonResponse deleteUser(int id) {
		try {
			adminRepository.deleteUser(id);
			CommonResponse res=new CommonResponse();
			res.setMsg("Deleted  !!");
			res.setStatus(true);
			logger.warn(id +"  User deleted ! ");
			return res;
			}
			catch(Exception e ){
				System.out.println(e.getMessage());
				CommonResponse res=new CommonResponse();
				res.setMsg("Something Went wrong !!");
				res.setStatus(false);
				return res;
			}
		
	}

}
