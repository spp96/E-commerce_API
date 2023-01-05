package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin findByAdminMobile(String mobile);
	
	public Admin findByAdminId(Integer adminId);

}
