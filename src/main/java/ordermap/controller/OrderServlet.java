package ordermap.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ordermap.model.Order;
import ordermap.model.OrderProduct;
import ordermap.model.Product;
import ordermap.model.RestaurantService;
import ordermap.model.ServiceProvider;



public class OrderServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		RestaurantService service = ServiceProvider.getOrderService();

		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantService service = ServiceProvider.getOrderService();
		
		Integer tNr = Integer.parseInt(req.getParameter("tableNR"));
		Integer amount = Integer.parseInt(req.getParameter("amount"));
		String name = req.getParameter("product");
		
		Product p = null;
		try {
			p = service.findProductbyName(name);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			service.addOrderForTable(p, amount, tNr);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
//		Integer id = Integer.parseInt(req.getParameter("toDelete"));
//		
//		try {
//			service.deleteProduct(id);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		resp.sendRedirect("index.jsp");	
		
		
	}
}