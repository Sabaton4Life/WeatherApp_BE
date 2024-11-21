package com.springboot.spring_boot_first_app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCityDTO {
	private String previousName;
	private String newName;
}
