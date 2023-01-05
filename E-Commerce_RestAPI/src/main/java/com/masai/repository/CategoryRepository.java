package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
