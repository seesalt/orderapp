package ordermap.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ordermap.model.Order;
import ordermap.model.OrderProduct;



public class OrderDAO extends BaseDAO {
	private OrderProductDAO opDao = new OrderProductDAO();
	
	
	private List<Order> selectOrder(String query) throws ClassNotFoundException {
		List<Order> results = new ArrayList<Order>();
		try (Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				int orderID = rs.getInt("orderID");
				int tableNR = rs.getInt("tableNR");
				int completed = rs.getInt("completed");
				
				Order newOrder = new Order(orderID, tableNR);
				
//				newOrder.getOrderProduct().addAll(opDao.findOrder(orderID));
				results.add(newOrder);
			}
		}	catch (SQLException sqle) { sqle.printStackTrace(); }
		return results;
	}
	
	public Order save(Order order) throws ClassNotFoundException{
		boolean orderExists = findByID(order.getOrderID()) != null; 
		
		for (OrderProduct op : order.getOrderProduct()) {
			opDao.update(order, op);
		}
		
		if(orderExists) {
			String query = "INSERT INTO orders (orderID, tableNR, completed) VALUES ( " + order.getOrderID() + "," + order.getTableNR() + "," + "1)";			
			try(Connection con = getConnection()) {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
			}	catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return order;
	}
	
	public Order savetest(Order order) throws ClassNotFoundException {
		boolean orderExists = findByID(order.getOrderID()) != null;
		
		if(orderExists) {
			String query = "INSERT INTO orders (tableNR, completed) VALUES ( " + order.getTableNR() + "," + "0)";
			try(Connection con = getConnection()) {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
			}	catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return order;
	}
	
	public void payOrder(int tNr) throws ClassNotFoundException {
		
			String query = "UPDATE orders SET completed=1 WHERE tableNR =" + tNr;
			try(Connection con = getConnection()) {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
			}	catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		
	}
	
	public List<Order> findAll() throws ClassNotFoundException{
		return selectOrder(String.format("SELECT * FROM orders"));
	}
	
	public Order findByID(int orderID) throws ClassNotFoundException{
		
		List<Order> orders = selectOrder(String.format("SELECT orderID, tableNR, completed FROM orders WHERE orderID = '%s'", orderID));
		Order c = orders.get(0);
		return c;
	}
	
	public Order findNonCompletedOrder(int tableNumber) throws ClassNotFoundException {
		List<Order> orders = selectOrder(String.format("SELECT orderID, tableNR, completed FROM orders WHERE completed = 0 AND tableNR = '%s'", tableNumber));
		Order c = orders.get(0);
		return c;
	}
	
//	public List<Order> findAllTables() throws ClassNotFoundException{
//		return selectOrder("SELECT tableNR from orders");
//	}

	
	public void update(OrderProduct op) {
		
		
	}

	
}
