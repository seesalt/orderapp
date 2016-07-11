package ordermap.model;

public class ServiceProvider {
	private static RestaurantService orderService = new RestaurantService();

	public static RestaurantService getOrderService() {
		return orderService;
	}
}
