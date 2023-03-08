package com.masai.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private String productName;
	private String productDescription;
	private String productBrand;
	private Double productRating;
	private Double productMarketPrice;
	private Double productSellingPrice;
	private String categoryName;
	private Integer userId;
}
