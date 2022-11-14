package com.assessment.Ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.assessment.Ecommerce.model.Order;
import com.assessment.Ecommerce.repo.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	/**
	 * @see Save Order data in db
	 * @param Order> Order Data
	 * @return order
	 */
	public Order saveOrder(Order order) {
		orderRepository.insert(order);
		return order;
	}
	
	/**
	 * @see Update data for existing order in db
	 * @param order
	 * @return order
	 */
	public Order updateOrder(Order order) {
		orderRepository.save(order);
		return order;
	}
	

	/**
	 * @see Get all orders data available in db
	 * @return list of all orders
	 */
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	
	/** @see Delete Order based on there id
	 * @param id -> OrderId
	 */
	public void deleteOrder(Integer id) {
		orderRepository.deleteById(id);
	}
     
	/**
	 * @see get Order data by there id
	 * @param id -> OrderId
	 * @return Order data
	 */
	public Order getOrderByIdAsObject(Integer id) {
		Optional<Order> byId = orderRepository.findById(id);
		return byId.isPresent() ? byId.get() : null;
	}
	
	
	
	
}
