package ordermap.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ordermap.persistence.OrderDAO;
import ordermap.persistence.OrderProductDAO;
import ordermap.persistence.ProductDAO;


public class RestaurantService {
	//private ArrayList<Product> allProducts =  new ArrayList<Product>();
	//private ArrayList<Order> allOrders = new ArrayList<Order>();
	
	//adds the daos so they can be used in the service
	private OrderDAO oDao = new OrderDAO();
	private ProductDAO pDao = new ProductDAO();
	private OrderProductDAO opDao = new OrderProductDAO();
	
	
	// *******CREATE*********//////
	
	
	//Voegt een product toe aan de order van een tafel.
	//Hier vind altijd een update op de database plaats. 
	//Alleen als er bij een tafel net is afgerekend moet er een nieuwe order
	//gemaakt worden.
	public void addOrderForTable(Product product, int amount, int tNr) throws ClassNotFoundException{
		Order o = oDao.findNonCompletedOrder(tNr);
		System.out.println(o.getOrderID());
		//Als er nog geen openstaande order is voor de tafel moet er een nieuwe order aangemaakt worden in de database
		//en gekoppeld worden aan de geselecteerde tafel.
		if (o == null) {
			int orderID = o.getOrderID();
			// nieuwe order maken en toevoegen in database
			Order no = new Order(orderID, tNr);
			oDao.savetest(no);
			// nieuwe order toekennen aan variabele 'o'
			no = o;
			
		}
		
		//Als de order gemaakt is kan het product aan de order toegevoegd worden
		//Nieuw product
		OrderProduct op = new OrderProduct(product, amount);
		//Voeg het nieuwe product toe aan de order	
		o.addProduct(op);
		op.setProduct(product);
		op.setOrder(o);
		opDao.update(o, op);
		
		// zoeken naar non-completed Order obv tafelnummer
		// 		bestaat WEL: gebruik deze Order
		//		bestaat NIET: maak nieuwe Order
		
		// nieuw OrderProduct maken en toevoegen
		
		//OrderProduct oP = new OrderProduct(o, product, amount);
	}
	
	public void addProduct(int sk, String nm, double pr) throws ClassNotFoundException{
		for (Product prod : pDao.getAllProducts()) {
			if (prod.getName().equals(nm)) {
				throw new IllegalArgumentException("Product Bestaat al!");
			}
		}
		
		Product p = new Product(sk, nm, pr);
		pDao.createProduct(p);
	}
	
	public void pay(int tNr) throws ClassNotFoundException {
		oDao.payOrder(tNr);
	}
	
	
	
	//*******READ*******
	public List<Product> returnAllProducts() throws ClassNotFoundException {
		return pDao.getAllProducts();
	}
	
	public Product findProductbyID(int productID) throws ClassNotFoundException{
		Product p = pDao.findByID(productID);
		return p;
	}
	
	public Product findProductbyName(String name) throws ClassNotFoundException{
		Product p = pDao.findByName(name);
		return p;
	}
	
	public List<OrderProduct> showAllOrderedProducts(int orderID) throws ClassNotFoundException {
		 return opDao.findOrder(orderID);
		 
	}
	
//	public List<Order> showAllTables() throws ClassNotFoundException {
//		return oDao.findAllTables();
//	}
	
	public List<Order> returnAllOrders() throws ClassNotFoundException {
		return oDao.findAll();
	}
	
	//*******UPDATE*******
	
	
	
	//*******DELETE********
	
	public void deleteProduct(int productID) throws ClassNotFoundException {
		Product p = pDao.findByID(productID);
		
		if (p != null) {
			pDao.delete(p);
		} else throw new IllegalArgumentException("Id does not exist!");
	}
}
