package com.cdac.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdac.entity.Bidding;
import com.cdac.entity.User;

@Repository
public class AdminRepository extends GenericRepository {
	
	public List<User> getAllCustomers() {
			return entityManager
				.createQuery("select u from User u where u.isAdmin=false order by u.isTransporter asc")
				.getResultList();
	}
	
	public List<User> getAllTransporters() {
		return entityManager
				.createQuery("select u from User u where u.isTransporter=true order by u.user_id")
				.getResultList();
	}
	
	public void deleteUser(int id) {
		entityManager
		.createQuery("delete Bidding b where b.user.user_id=:id")
		.setParameter("id", id)
		.executeUpdate();
			
		entityManager
		.createQuery("delete Advertisement a where a.user.user_id=:id")
		.setParameter("id", id)
		.executeUpdate();
		
		entityManager
		.createQuery("delete User u where u.user_id=:id")
		.setParameter("id", id)
		.executeUpdate();
	}
	
	public List<Bidding> getFinalizedAdds() {
		return entityManager
				.createQuery("select b from Bidding b where b.isBidFinalized=true order by b.bid_id desc")
				.getResultList();
	}

}
