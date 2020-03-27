package com.shyam.app.model.order;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@NoArgsConstructor
@Data
public class Order {

	private int id;
	private String status;
	
	public Order(int id){
		this.id = id;
	}
}
