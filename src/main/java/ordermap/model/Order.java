package ordermap.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class Order {
	private int orderID;
	private int tableNR;
	private boolean completed;
	private ArrayList<OrderProduct> deBesteldeProducten = new ArrayList<OrderProduct>();
	
	public Order(int orderID, int tableNR){
		this.orderID = orderID;
		this.tableNR = tableNR;
	}
	
	public int getOrderID(){
		return orderID;
	}
	public int getTableNR(){
		return tableNR;
	}
	
	public boolean getCompleted(){
		return completed;
	}
	
	public void addProduct(OrderProduct oP){
		deBesteldeProducten.add(oP);
	}
	
	public List<OrderProduct> getOrderProduct(){
		return deBesteldeProducten;
	
	}
	
	public double orderBedrag(){
		double total = 0;
		for(OrderProduct oP : deBesteldeProducten){
			total += oP.productPrice();
		}
		return total;
	}
	
	public List<OrderProduct> getMyOrders(){
		return Collections.unmodifiableList(deBesteldeProducten);
	}
	
}
