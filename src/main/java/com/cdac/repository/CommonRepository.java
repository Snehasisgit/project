package com.cdac.repository;

import org.springframework.stereotype.Repository;

import com.cdac.entity.User;

@Repository
public class CommonRepository extends GenericRepository {

	
	public User findByEmailAndPassword(String email, String password) {
		return (User)
				entityManager
				.createQuery("select a from User a where a.email = :em and a.pass = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	 }
	
	
	
	public boolean isAccountPresent(String email) {
		return  (Long)
				entityManager
				.createQuery("select count(a) from User a where a.email = :em")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}



	public void changePassword(String email, String md5) {
		
		entityManager
		.createQuery("update User u set u.pass=:pass where u.email=:em")
		.setParameter("em", email)
		.setParameter("pass", md5)
		.executeUpdate();
	}
	
}
