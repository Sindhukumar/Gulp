package Util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Tool.RS;
import Tool.Restaurant;
import Tool.Review;


public class DbReview {

    public static void insert(Review review) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		// System.out.println("DbBullhorn: begin transaction");
		try {
			trans.begin();
			em.persist(review);
			// System.out.println("DbBullhorn: commit transaction");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("DbBullhorn: rollback transaction");
			trans.rollback();
		} finally {
			// System.out.println("DbBullhorn: close em");
			em.close();
		}
	
       
    }

    public static void update(Review review) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(review);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	
      
    }

    public static void delete(Review review) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(review));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	
        
    }

    public static List<Review> review (){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select b from Gradebook b";
        
        List<Review> posts = null;
        try{
            TypedQuery<Review> query = em.createQuery(qString,Review.class);
            posts = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return posts;
    }
    
    public static List<RS> getRestaurantsWithRating (){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select r.restaurant, avg(r.rating) average from Review r group by r.restaurant order by avg(r.rating)";
        List<Object[]> restaurants=null;
        List<RS> rsList = new ArrayList<RS>();
        try{
            Query query = em.createQuery(qString,RS.class);
            restaurants = query.getResultList();
            
            for(Object[] o:restaurants){
            	RS rs= new RS();
            	rs.setRestaurant((Restaurant)o[0]);
            	rs.setAverage(o[1]==null?-1:(double)o[1]);
            	rsList.add(rs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return rsList;
    }
    
    public static Review review (Integer reviewid){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select b from Gradebook b where b.gradebookid =:gradebookid";
        
        Review reviews = null;
        try{
            TypedQuery<Review> query = em.createQuery(qString,Review.class);
            query.setParameter("gradebookid", reviewid);
            reviews = query.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return reviews;
    }
    
    public static List<Review> reviewofUser(long userid)
    {
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        List<Review> userposts = null;
        String qString = "select b from Review b where b.ruser.userid = :userid";
        
        try{
            TypedQuery<Review> query = em.createQuery(qString,Review.class);
            query.setParameter("userid", userid);
            userposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return userposts;    
    }
    
    public static List<Review> searchReview (String search)
    {
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        List<Review> searchposts = null;
        String qString = "select r from Review r "
                + "where r.review like :search";
        
        try{
            TypedQuery<Review> query = em.createQuery(qString,Review.class);
            query.setParameter("search", "%" + search + "%");
            searchposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchposts;
    }
    
}
