package quan.hoang170203.assignments.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import quan.hoang170203.assignment2.define.Define;
import quan.hoang170203.assignment2.model.CasualWorker;

public class CasualWorkerTest {
	private final double delta = 0.0001;
	
	CasualWorker c;
	
	@Before
	public void test_Builder() {
		
		c = new CasualWorker.CasualWorkerBuilder(Define.lastestId, Define.TYPE_OF_CASUALWORKER)
			.setName("Quan")
			.setYearOfBirth(1999)
			.setWorkDay(25)
			.setPriceOfWorkDay(2500)
			.build();
	}
	
	@Test
	public void test_toString() {
		assertEquals("CasualWorker [workDays=25, priceOfWorkDay=2500]" , c.toString());
	}
	
	@Test
	public void test_CasualWorker() {
		assertNotNull(c);
	}
	
	@Test
	public void test_getId() {
		assertEquals(0 , c.getId());
	}
	
	@Test
	public void test_setName() {
		c.setName("Quan");
		assertEquals("Quan" , c.getName());
	}
	
	@Test
	public void test_setYearOfBirth() {
		c.setyearOfBirth(1999);
		assertEquals(1999 , c.getyearOfBirth());
	}
	
	@Test
	public void test_getType() {
		assertEquals(3 , c.getType());
	}
	
	@Test
	public void test_setWorkDay() {
		c.setWorkDay(30);
		assertEquals(30 , c.getWorkDay());
	}
	
	@Test
	public void test_setPriceOfWorkDay() {
		c.setPriceOfWorkDay(300);
		assertEquals(300 , c.getPriceOfWorkDay());
	}
	
}
