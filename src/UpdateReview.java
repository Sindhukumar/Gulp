

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class UpdateReview
 */
@WebServlet("/UpdateReview")
public class UpdateReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReview() {
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
		String nextURL = "/ProfileServlet";
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
		DbReview.update(review);
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
