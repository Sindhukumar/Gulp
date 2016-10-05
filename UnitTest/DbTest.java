import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Tool.RS;
import Util.DbReview;

public class DbTest {

	@Test
	public void test() {
		System.out.println("start");
		List<RS> rs = DbReview.getRestaurantsWithRating();
//		System.out.println(rs.get(0).rid);
		for(RS r : rs){
			System.out.println("in for");
			System.out.println("Restaurant name:"+r.getRestaurant().getRname() +"average="+r.getAverage());
		}
	}

}
