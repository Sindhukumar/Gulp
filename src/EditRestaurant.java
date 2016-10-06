
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.Restaurant;
import Tool.Review;
import Tool.Ruser;
import Util.DbRestaurant;
import Util.DbReview;

/**
 * Servlet implementation class EditRestaurant
 */
@WebServlet("/EditRestaurant")
public class EditRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditRestaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/EditRestaurant";
		int rid = Integer.parseInt(request.getParameter("restaurantid"));
		HttpSession session = request.getSession();

		Restaurant currentRest = DbRestaurant.restaurant(rid);
		session.setAttribute("currentrest", currentRest);
		
		
		response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rid = Integer.parseInt(request.getParameter("restaurantid"));
		String rname = request.getParameter("rname");
		String address = request.getParameter("address");
		String description = request.getParameter("description");

		Restaurant addNew = new Restaurant();
		addNew.setRname(rname);
		addNew.setAddress(address);
		addNew.setDescription(description);
		addNew.setRid(rid);
		System.out.println("Adding a new restaurant");
		DbRestaurant.update(addNew);
		System.out.println("Restaurant added");

		String nextURL = "/Home";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
