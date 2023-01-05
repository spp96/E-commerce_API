package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;	
	private String productName;
	private String productDescription;
	private String productBrand;
	private Double productRating;
	private Double productMarketPrice;
	private Double productSellingPrice;
	private Integer productStock;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@ManyToOne
	@JsonIgnore
	private Admin admin;


}
