package com.ty.springboot_hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class MedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "name can't be blank")
	private String name;
	private long cost;
	
	@ManyToOne
	private MedOrder medOrder;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public MedOrder getMedOrder() {
		return medOrder;
	}
	public void setMedOrder(MedOrder medOrder) {
		this.medOrder = medOrder;
	}

}
