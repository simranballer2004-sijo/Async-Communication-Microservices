package net.javaguides.base_domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data //provides all getter,setter,toString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
	private String orderId;
	private String name;
	private int qty;
	private double price;
	public void setOrderId(String orderId) {
		// TODO Auto-generated method stub
		this.orderId = orderId;
		
	}
	public String getOrderId() {
		// TODO Auto-generated method stub
		return this.orderId;
		
	}

}
