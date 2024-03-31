package com.cdac.service;

import java.util.List;

import com.cdac.dto.CommonResponse;
import com.cdac.entity.Bidding;
import com.cdac.entity.User;

public interface AdminServiceInterface {

	
	public List<Bidding> getFinalizedAdds();
	
	public List<User> getAllCustomers();
	
	public List<User > getAllTransporters();
	
	public CommonResponse deleteUser(int id);
}
