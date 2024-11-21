package com.springboot.spring_boot_first_app.entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
	public City(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Nonnull 
	@Column(name="NAME")
	private String name;
	
	public String getName() {
		return this.name;
	}
	
}
