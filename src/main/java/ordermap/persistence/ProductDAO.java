package ordermap.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ordermap.model.Product;

public class ProductDAO extends BaseDAO {
	
	
	private List<Product> selectProduct(String query) throws ClassNotFoundException{
		List<Product> results = new ArrayList<Product>();
		try (Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt("productID");
				int stock = rs.getInt("stock");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				Product newProduct = new Product(stock, name, price);
				results.add(newProduct);
			}
		}	catch (SQLException sqle) { sqle.printStackTrace(); }
		return results;
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException{
		return selectProduct("SELECT * FROM products");		
	}
	
	public Product findByID(int productID) throws ClassNotFoundException{
		List<Product> products = selectProduct(String.format("SELECT productID, stock, name, price  FROM products WHERE productID = '%s'", productID));
		Product p = products.get(0);
		return p;
	}
	
	public Product findByName(String name) throws ClassNotFoundException{
		List<Product> products = selectProduct(String.format("SELECT * FROM products WHERE name = '%s'", name));
		Product p = products.get(0);
		return p;
	}
	
	public boolean delete(Product product) throws ClassNotFoundException {
		boolean result = false;
		boolean productExists = findByID(product.getProductID()) != null;
		
		if (productExists) {
			String query = "DELETE FROM products WHERE productID = " +product.getProductID(); 
					
			try (Connection con = getConnection()) {
				
				Statement stmt = con.createStatement();
				stmt.executeUpdate(query);  // 1 row updated!
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		return result;
	}

	public boolean createProduct(Product p) throws ClassNotFoundException {
		boolean result = false;
		//boolean productExists = findByName(p.getName()) != null;
		
		
			String query = "INSERT INTO products (stock,name,price) VALUES ('" + p.getStock() + "','" + p.getName() + "','" + p.getPrice() + "')";
			
			try (Connection con = getConnection()) {
				
				Statement stmt = con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		
		return result;
	}
	
	
	
	
	
	
	
	
}
