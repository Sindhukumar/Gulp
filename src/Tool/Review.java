package Tool;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the REVIEWS database table.
 * 
 */
@Entity
@Table(name="REVIEWS")
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long reviewid;

	private BigDecimal rating;

	private String review;

	private String reviewdate;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	@JoinColumn(name="RID")
	private Restaurant restaurant;

	//bi-directional many-to-one association to Ruser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Ruser ruser;

	public Review() {
	}

	public long getReviewid() {
		return this.reviewid;
	}

	public void setReviewid(long reviewid) {
		this.reviewid = reviewid;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewdate() {
		return this.reviewdate;
	}

	public void setReviewdate(String reviewdate) {
		this.reviewdate = reviewdate;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Ruser getRuser() {
		return this.ruser;
	}

	public void setRuser(Ruser ruser) {
		this.ruser = ruser;
	}

}