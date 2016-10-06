
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.RS;
import Tool.Review;
import Tool.Ruser;
import Tool.Restaurant;
import Util.DbRestaurant;
import Util.DbReview;

/**
 * Servlet implementation class Review
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/Review.jsp";

		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/Home";
		HttpSession session = request.getSession();
		String restaurantid = request.getParameter("restaurantid");
		int rid = Integer.parseInt(restaurantid);

		Restaurant restaurant = DbRestaurant.restaurant(rid);
		Ruser user = (Ruser) session.getAttribute("user");
		
		String reviewText = request.getParameter("review");

		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		
		int rating = Integer.parseInt(request.getParameter("number"));
		
		System.out.println("Rating---->"+BigDecimal.valueOf(rating));
		
		Review review = new Review();
		
		review.setRating(BigDecimal.valueOf(rating));
		review.setRestaurant(restaurant);
		review.setReview(reviewText);
		review.setReviewdate(date);
		review.setRuser(user);
		DbReview.insert(review);
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

}
