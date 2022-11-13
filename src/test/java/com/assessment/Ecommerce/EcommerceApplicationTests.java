package com.assessment.Ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.assessment.Ecommerce.Service.OrderService;
import com.assessment.Ecommerce.model.Order;
import com.assessment.Ecommerce.repo.OrderRepository;

@SpringBootTest
class EcommerceApplicationTests {

	@Autowired
	private OrderService service;

	@MockBean
	private OrderRepository repo;
	
	@BeforeEach
	public void setUp() {
		System.out.println("+++++++++-----------------------------------------------------------------+++++++++");
		Optional<Order> user = Optional
				.of(new Order(101,"Delivered",860, null, null, null));
		List<Order> list = Arrays
				.asList(new Order(101, "Gaurav",890,null, null, null));

		// mocked object
		when(repo.findById(101)).thenReturn(user);
		when(repo.findAll()).thenReturn(list);
		when(repo.save(user.get())).thenReturn(user.get());
		when(repo.insert(user.get())).thenReturn(user.get());

	}
	
	@Test
	@DisplayName("When Order id is given return valid object")
	void trainerValidReturn() {
		assertEquals(101, service.getOrderByIdAsObject(101).getId());
	}
	
	@Test
	@DisplayName("get all the Orders and list should give you an array of 1 user")
	void getAllTrainers() {
		assertEquals(1, service.getAllOrders().size());
	}
	
	
	@Test
	@DisplayName("save the valid Order and acknowledge the same")
	void saveTrainerToTheServer() {
		Order order = new Order(102, "Delivered", 980, null, null, null);

		assertNotNull(service.saveOrder(order));
	}

}
