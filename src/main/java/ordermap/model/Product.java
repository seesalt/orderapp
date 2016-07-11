package ordermap.model;

public class Product {
	private int productID;
	private int stock;
	private String name;
	private double price;
	
	
	public Product(int sk, String nm, double pr){
		this.productID = productID;
		stock = sk;
		name = nm;
		price = pr;
	}
	
	public int getProductID(){
		return productID;
	}
	
	public int getStock(){
		return stock;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
}
