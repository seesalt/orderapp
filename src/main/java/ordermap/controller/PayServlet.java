package ordermap.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ordermap.model.RestaurantService;
import ordermap.model.ServiceProvider;

public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantService service = ServiceProvider.getOrderService();
		
		int tNr = Integer.parseInt(req.getParameter("tableNR"));
		
		try {
			service.pay(tNr);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
