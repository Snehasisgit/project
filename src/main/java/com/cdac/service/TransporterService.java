package com.cdac.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dto.CommonResponse;
import com.cdac.dto.PlaceBidData;
import com.cdac.entity.Advertisement;
import com.cdac.entity.Bidding;
import com.cdac.repository.AdminRepository;
import com.cdac.repository.CommonRepository;
import com.cdac.repository.TransporterRepository;
import com.cdac.repository.UserRepository;


@Service
@Transactional
public class TransporterService implements TransporterServiceInterface {
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
		
		private static final Logger logger = LogManager.getLogger(TransporterService.class);
	
	public CommonResponse placeBid(PlaceBidData data,int id) {
	
		try {
			Advertisement add= userRepository.findByPK(Advertisement.class, id);
			
			Bidding bid = new Bidding();
			bid.setAdd(add);
			bid.setEstimated_deliveryDate(data.getEstimated_deliveryDate());
			bid.setOffer_price(data.getOffer_price());
			bid.setUser(data.getUser());
		    bid.setRemark(data.getRemark());
		    
		     userRepository.save(bid);
		     
		     logger.info(data.getUser().getEmail()+" Bid Placed ! ");
		     
			CommonResponse response = new CommonResponse();
			response.setStatus(true);
			response.setMsg("Bid placed ! ");
			return response;
		}catch(Exception e) {
			CommonResponse response = new CommonResponse();
			response.setStatus(false);
			response.setMsg(" Something Went Wrong ");
			return response;
		}
	}
	
	public List<Advertisement> getAllAdds() {
		
		try {
			return transporterRepository.getAllAdds();
		}
		catch(Exception e) {
	        	return null;
		}
	}
	
	
	public List<Bidding> getYourBids(int id) {
		try {
			return transporterRepository.getYourBids(id);
		}
		catch(Exception e ) {
			return null; 
		}	
	}
	
   public CommonResponse deleteBid(int id) {
		
		try {
			transporterRepository.deleteBid(id);
			logger.warn(id+" Bid Placed ! ");
			CommonResponse res=new CommonResponse();
			res.setMsg("Deleted  !!");
			res.setStatus(true);
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
   
   
   


