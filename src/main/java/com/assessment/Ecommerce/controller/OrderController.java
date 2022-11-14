package com.assessment.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.Ecommerce.Exception.OrderNotFoundException;
import com.assessment.Ecommerce.Service.OrderService;
import com.assessment.Ecommerce.model.Order;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private OrderService service;
    
	@GetMapping("/health")
	public String sayHello() {
		return "Service is up...";
	}
	
	/**
	 * @see Create new Order
	 * @param Order
	 * @return Order ResponseEntity
	 */

	@PostMapping("/order")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
		Order retOrder = service.saveOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(retOrder);
	}

	
	/**
	 * @see update existing order endpoint based on Orderid
	 * @param order
	 * @return order ResponseEntity
	 */
	@PutMapping("/order/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) throws OrderNotFoundException {
		Order retOrder = service.updateOrder(order);
		if(service.getOrderByIdAsObject(order.getId())!=null) {
			Order updateOrder = service.updateOrder(retOrder);
			return ResponseEntity.status(HttpStatus.OK).body(updateOrder);
		} else {
			throw new OrderNotFoundException("Student Not Found to Update" + order.toString());
		}
//		return ResponseEntity.status(HttpStatus.CREATED).body(retOrder);
	}

	
	
	/**
	 * @see Get list of all available Orders endpoint
	 * @return
	 */
	@GetMapping("/order")
	public List<Order> getOrders() {
		return service.getAllOrders();
	}
	
	
	
	/**
	 * @see Get trainer detailes based on trainerId endpoint
	 * @param id -> trainerId
	 * @return trainer
	 * @throws TrainerNotFoundException
	 */
	@GetMapping("/order/{id}")
	public Order getOrders(@PathVariable Integer id) throws OrderNotFoundException {
		Order retOrder = service.getOrderByIdAsObject(id);
		if (retOrder == null) {
			throw new OrderNotFoundException("Sorry Order not found");
		}
		return retOrder;
	}
	
	
	@GetMapping("/order/status/{id}")
	public String getOrdersStatus(@PathVariable Integer id) throws OrderNotFoundException {
		Order retOrder = service.getOrderByIdAsObject(id);
		if (retOrder == null) {
			throw new OrderNotFoundException("Sorry Order not found");
		}
		return retOrder.getStatus();
	}
	
	
	
	
	
	/**
	 * @see delete Order data endpoint
	 * @param id
	 * @return validation whether Order is deleted or not
	 * @throws OrderNotFoundException
	 */
	@DeleteMapping("/order/{id}")
	public String deleteTrainer(@PathVariable Integer id) throws OrderNotFoundException {
	    Order retTrainer = service.getOrderByIdAsObject(id);
		if (retTrainer == null) {
			throw new OrderNotFoundException("Sorry Order not found");
		}
		service.deleteOrder(id);
		return "Order Deleted Successfully";
	}


}
