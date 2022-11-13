package com.assessment.Ecommerce.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

	public Order(int id2, String status2, int total2, Object created2, Object shippingCharge2, Object object) {
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	private String status;
	private Integer total;
	private LocalDateTime created;
	private Integer shippingCharge;
	private String address;
}
