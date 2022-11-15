package com.assessment.Ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

	@Id
	private Integer id;
	private String status;
	private Integer total;
	private List<OrderItem> orderitem;
	private LocalDateTime created;
	private Integer shippingCharge;
	private String address;
}
