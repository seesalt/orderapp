package ordermap.services;

import java.sql.SQLException;
import javax.json.*;
import javax.ws.rs.*;

import ordermap.model.Order;
import ordermap.model.Product;
import ordermap.model.RestaurantService;
import ordermap.model.ServiceProvider;

@Path("/products")
public class RestaurantResource {
	
	
	@GET
	@Produces("application/json")
	public String getProducts() throws ClassNotFoundException, SQLException {
		RestaurantService service = ServiceProvider.getOrderService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Product p : service.returnAllProducts()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("productID", p.getProductID());
			job.add("name", p.getName());
			job.add("stock", p.getStock());
			job.add("price", p.getPrice());
			
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("/tables")
	@Produces("application/json")
	public String getTables() throws ClassNotFoundException {
		RestaurantService service = ServiceProvider.getOrderService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Order t :  service.showAllTables()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("tableNR", t.getTableNR());
			
			jab.add(job);
		}
		 JsonArray array = jab.build();
		 return array.toString();
	}
}
