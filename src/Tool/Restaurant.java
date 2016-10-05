package Tool;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RESTAURANT database table.
 * 
 */
@Entity
@NamedQuery(name="Restaurant.findAll", query="SELECT r FROM Restaurant r")
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rid;

	private String address;

	private String description;

	private String rname;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="restaurant")
	private List<Review> reviews;

	public Restaurant() {
	}

	public long getRid() {
		return this.rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setRestaurant(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setRestaurant(null);

		return review;
	}

}