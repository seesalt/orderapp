package ordermap.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ordermap.model.Order;
import ordermap.model.OrderProduct;
import ordermap.model.Product;



public class OrderProductDAO extends BaseDAO {
	private Connection conn;
	private String tblName = "orderproduct";
	//private OrderDAO orderDAO = new OrderDAO();
	private ProductDAO productDAO = new ProductDAO();
	
//	public OrderProductDAO() {
//		
//	}
	
	private List<OrderProduct> selectOrderProducts(String query) throws ClassNotFoundException {
		List<OrderProduct> results = new ArrayList<OrderProduct>(); 
		try (Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()){
				int amount = rs.getInt("amount");
				int productID = rs.getInt("productID");
				int orderID = rs.getInt("orderID");
				Product product = productDAO.findByID(productID);
				//Order order = orderDAO.findByID(orderID);
				OrderProduct newOrderProduct = new OrderProduct(product, amount);
				//newOrderProduct.setOrder(order);
				newOrderProduct.setProduct(product);
				results.add(newOrderProduct);
			}
		}	catch (SQLException sqle) { sqle.printStackTrace(); }
		return results;
	}
	
	public List<OrderProduct> findOrder(int orderID) throws ClassNotFoundException {
		return selectOrderProducts(String.format("SELECT productID, amount FROM '%s' WHERE orderID = '%s'",tblName, orderID));
	}

	public void update(Order order, OrderProduct op) {
		String query = "INSERT INTO orderproducts (product_ID,order_ID,amount) VALUES(" + op.getHetProduct().getProductID() + "," + order.getOrderID() + "," + op.getAmount() + ")";
		try (Connection con = getConnection()) {
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);  // 1 row updated!
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
		


////	public void update(OrderProduct op) {
////		String query = "INSERT INTO orderproducts order_ID, Product_ID, amount VALUES(" + op.getOrder().getOrderID() + "," + op.getHetProduct().getProductID() + "," + op.getAmount() + ")";
////		
////		try (Connection con = getConnection()) {
////			
////			Statement stmt = con.createStatement();
////			stmt.executeUpdate(query);  // 1 row updated!
////			
////		} catch (SQLException sqle) {
////			sqle.printStackTrace();
////		}
////	}
//		
	}


