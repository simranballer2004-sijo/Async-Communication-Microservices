package net.javaguides.base_domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {
	private String message; //contains key value pair
	private String status;
	private Order order;
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		this.status = status;
		
	}
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}
	
	public void setOrder(Order order) {
		// TODO Auto-generated method stub
		this.order = order;
	}
	
	public String getStatus() {
		// TODO Auto-generated method stub
		return this.status;
		
	}
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
		
	}
	public Order getOrder() {
		// TODO Auto-generated method stub
		return this.order;
		
	}
	
	@Override
	public String toString() {
	    return "OrderEvent{" +
	            "message='" + this.message + '\'' +
	            ", status=" + this.status +
	            ", order='" + this.order.toString() + '\'' +
	            '}';
	}


}
