package com.cdac.service;

import java.util.List;

import com.cdac.dto.CommonResponse;
import com.cdac.dto.PlaceBidData;
import com.cdac.entity.Advertisement;
import com.cdac.entity.Bidding;

public interface TransporterServiceInterface {
	
	
	public CommonResponse deleteBid(int id);
	
	public List<Bidding> getYourBids(int id);
	
	public List<Advertisement> getAllAdds();
	
	public CommonResponse placeBid(PlaceBidData data,int id);
	
	

}
