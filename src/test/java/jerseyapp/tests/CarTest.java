package jerseyapp.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cohort2.jerseyapp.dao.CarDao;
import com.cohort2.jerseyapp.model.Car;

public class CarTest {
	
	int expected = 6;
	
	@Test
	public void testFetchCars() {
	  int actual = CarDao.getInstance().fetchCarData().size();
	  
	  assertEquals(expected, actual);
	}

}
