package com.assessment.Ecommerce.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {
	
	private int itemid;
	private String itemName;
	private int itemQuantity;

}
