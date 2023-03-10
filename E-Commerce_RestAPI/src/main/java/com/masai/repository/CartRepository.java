package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findByUserId(Integer userId);

}
