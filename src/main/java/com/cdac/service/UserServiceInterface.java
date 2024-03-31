package com.cdac.service;

import java.util.List;

import com.cdac.dto.CommonResponse;
import com.cdac.entity.Advertisement;
import com.cdac.entity.Bidding;

public interface UserServiceInterface {
	
	public CommonResponse deleteAdd(int id);
	
	public Bidding getBidByAdd(int id);
	
	public Bidding getBid(int id);
	
	public List<Advertisement> getYourAdds(int id);
	
	public CommonResponse acceptOffer(Bidding bid);
	
	public List<Bidding> getAllBids(int addid);
	
	public CommonResponse postAdd (Advertisement obj);
	
}
