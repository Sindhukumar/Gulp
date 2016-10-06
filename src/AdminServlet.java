

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tool.Restaurant;
import Tool.Review;
import Tool.Ruser;
import Util.DbRestaurant;
import Util.DbReview;
import Util.DbUser;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String rname = request.getParameter("rname");
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		
		Restaurant addNew = new Restaurant();
		Review dummyreview = new Review();
		Ruser user = (Ruser) request.getSession().getAttribute("user");
		
		addNew.setRname(rname);
		addNew.setAddress(address);
		addNew.setDescription(description);
		
		System.out.println("Adding a new restaurant");
		DbRestaurant.insert(addNew);
		System.out.println("Restaurant added");
		
		
		dummyreview.setRating(null);
		dummyreview.setReview(null);
		dummyreview.setRuser(user);
		dummyreview.setRestaurant(DbRestaurant.get(rname,address,description));
		DbReview.insert(dummyreview);
		System.out.println("Dummy Review added");
		
		
		String nextURL = "/Home";
		response.sendRedirect(request.getContextPath()+nextURL);
		
		
		
	}

}
