package com.cdac.service;

import java.util.List;

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
import com.cdac.dto.PlaceBidData;
import com.cdac.encryption.PasswordEncryption;
import com.cdac.entity.Advertisement;
import com.cdac.entity.Bidding;
import com.cdac.entity.User;
import com.cdac.exception.UserServiceException;
import com.cdac.repository.AdminRepository;
import com.cdac.repository.CommonRepository;
import com.cdac.repository.TransporterRepository;
import com.cdac.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserServiceInterface {

	
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
	
	
	
	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	
	
	
	
	
	@Override
	public CommonResponse postAdd (Advertisement obj) {
		
		try {
			userRepository.save(obj);
			CommonResponse response = new CommonResponse();
			response.setStatus(true);
			response.setMsg("Your Advertisement is placed Successfully !");
			logger.info(obj.getUser().getEmail()+" New Add Placed ! ");
		
			return response;
		}
		catch (Exception e ) {
			CommonResponse response = new CommonResponse();
			response.setStatus(false);
			response.setMsg("Something went Wrong !");
			return response;
		}
	}
	
	
	
	@Override
	public List<Bidding> getAllBids(int addid) {
		try {
			return userRepository.getAllBids(addid);
		}
		catch(Exception e) {
			//System.out.println(e.getMessage());
	        	return null;
		}
	}




	@Override
	public CommonResponse acceptOffer(Bidding bid) {
		try {
			userRepository.acceptOffer(bid.getAdd().getAdd_id(),bid.getBid_id());
			CommonResponse res=new CommonResponse();
			res.setMsg("Offer accepted!!");
			res.setStatus(true);
			logger.info(bid.getUser().getEmail()+" Bid accepted  ! ");
			try {
				emailService.sendAcceptOffer(bid.getUser().getEmail(),bid.getBid_id(),bid.getOffer_price());
			}catch(Exception e ) {}
			return res;
		}catch(Exception e ) {
			CommonResponse res=new CommonResponse();
			res.setMsg("Something went wrong !!");
			res.setStatus(false);
			return res;
		}
		
	}

	
	
	
	
	@Override
	public List<Advertisement> getYourAdds(int id) {
		
		try {
			return userRepository.getYourAdds(id);
		}
		catch(Exception e ) {
			return null; 
		}
	}

	public Bidding getBid(int id) {
		try {
			return userRepository.findByPK(Bidding.class, id);
		}
		catch(Exception e ) {
			return null; 
		}
	}

	
	@Override
	public Bidding getBidByAdd(int id) {
		
		try {
			return userRepository.getBidByAdd(id);
		}
		catch(Exception e ) {
			return null; 
		}
	}

	
	
	@Override
	public CommonResponse deleteAdd(int id) {
		
		try {
			userRepository.deleteAdd(id);
			CommonResponse res=new CommonResponse();
			res.setMsg("Deleted  !!");
			res.setStatus(true);
			logger.warn(id+" Add deleted ! ");
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
