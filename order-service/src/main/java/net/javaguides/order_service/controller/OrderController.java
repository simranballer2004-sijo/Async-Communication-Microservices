package net.javaguides.order_service.controller;

import org.apache.kafka.common.Uuid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.base_domains.dto.Order;
import net.javaguides.base_domains.dto.OrderEvent;
import net.javaguides.order_service.kafka.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	private OrderProducer orderProducer;
	
	public OrderController(OrderProducer orderProducer) {
		this.orderProducer = orderProducer;
	}
	
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) { //@RequestBody to convert json to Java Pojo
		
		
		order.setOrderId(Uuid.randomUuid().toString());
		
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setStatus("PENDING");
		orderEvent.setMessage("order status is in pending");
		orderEvent.setOrder(order);
		
		orderProducer.sendMessage(orderEvent);
		
		return "Order Placed Successfully";
		
	}
	

}
