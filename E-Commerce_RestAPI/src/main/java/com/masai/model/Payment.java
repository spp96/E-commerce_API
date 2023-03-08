package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId; 
	private String UTR;
    private LocalDateTime localDateTime;
    private Integer userId;
    private boolean paymentStatus;
    
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Admin admin;
//    

}
