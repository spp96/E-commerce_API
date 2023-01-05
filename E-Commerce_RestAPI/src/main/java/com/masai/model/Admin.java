package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	private String adminName;
	private String adminEmail;
	private String adminMobile;
	private String password;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
	@JsonIgnore
	private List<Product> productList = new ArrayList<>();

}
