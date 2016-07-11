package ordermap.model;

import java.util.Collections;
import java.util.List;


public class OrderProduct {
	private int amount;
	private Order order;
	private Product hetProduct;
	
	public OrderProduct(Product product, int amount){
		this.amount = amount;
		this.order = order;
		this.hetProduct = product;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public Order getOrder(){
		return order;
	}
	
	public void setOrder(Order order){
		this.order = order;
	}
	
	public Product getHetProduct(){
		return hetProduct;
	}
	public void setProduct(Product hetProduct){
		this.hetProduct = hetProduct;
	}
	
	public double productPrice(){
		double total = 0;
		total = hetProduct.getPrice() * amount;
		return total;
	}
}
