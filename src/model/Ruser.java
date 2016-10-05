package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RUSERS database table.
 * 
 */
@Entity
@Table(name="RUSERS")
@NamedQuery(name="Ruser.findAll", query="SELECT r FROM Ruser r")
public class Ruser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String useremail;

	private String username;

	private String userrole;

	private String zip;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="ruser")
	private List<Review> reviews;

	public Ruser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserrole() {
		return this.userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setRuser(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setRuser(null);

		return review;
	}

}