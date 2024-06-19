package com.project.npp.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="customer")
public class Customer {
	
	
	
	
	@Id
	private String username;
	
	
//	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	private String email;
	
	private String name;
	
	private Long phoneNumber;
	
	@ManyToOne
	private Operator currentOperator;
	
	private LocalDate startDate;
	
	@ManyToOne
	private Operator newOperator;
	
	@Enumerated(EnumType.STRING)
	private Status status;
}
