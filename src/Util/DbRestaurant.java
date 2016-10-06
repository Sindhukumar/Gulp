package Util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Tool.Restaurant;

public class DbRestaurant {

    public static void insert(Restaurant restaurant) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		// System.out.println("DbBullhorn: begin transaction");
		try {
			trans.begin();
			em.persist(restaurant);
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

    public static void update(Restaurant restaurant) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(restaurant);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	
      
    }

    public static void delete(Restaurant restaurant) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(restaurant));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	
        
    }

    public static List<Restaurant> restaurants(){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select r from Restaurant r";
        
        List<Restaurant> posts = null;
        try{
            TypedQuery<Restaurant> query = em.createQuery(qString,Restaurant.class);
            posts = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return posts;
    }
    
    public static Restaurant get (String rname,String  address,String  description)
    {
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select r from Restaurant r where r.rname =:rname AND r.address = :address AND r.description = :description";
        
        Restaurant posts = null;
        try{
            TypedQuery<Restaurant> query = em.createQuery(qString,Restaurant.class);
            query.setParameter("rname", rname);
            query.setParameter("address", address);
            query.setParameter("description", description);
            posts = query.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return posts;
    }
    
    
    public static Restaurant restaurant (Integer rid){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select r from Restaurant r where r.rid =:rid";
        
        Restaurant posts = null;
        try{
            TypedQuery<Restaurant> query = em.createQuery(qString,Restaurant.class);
            query.setParameter("rid", rid);
            posts = query.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return posts;
    }
    
    public static List<Restaurant> searchRestaurant (String search)
    {
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        List<Restaurant> searchposts = null;
        String qString = "select r from Restaurant r "
                + "where r.rname like :search";
        
        try{
            TypedQuery<Restaurant> query = em.createQuery(qString,Restaurant.class);
            query.setParameter("search", "%" + search + "%");
            searchposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchposts;
    }
    
}
