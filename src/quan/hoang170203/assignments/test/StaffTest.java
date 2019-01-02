package quan.hoang170203.assignments.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import quan.hoang170203.assignment2.define.Define;
import quan.hoang170203.assignment2.model.Lecturer;
import quan.hoang170203.assignment2.model.Staff;

public class StaffTest {
	private final double delta = 0.0001;
	
	Staff s;
	
	@Before
	public void test_builder() {
		s = new Staff.StaffBuilder(Define.lastestId, Define.TYPE_OF_STAFF)
				.setName("Quan")
				.setyearOfBirth(1999)
				.setHomeTown("Da Nang")
				.setDepartment("IBM")
				.setWorkDay(25)
				.setSalaryRatio((float) 2.5)
				.setAllowance(Define.ALLOWANCE_OF_CHIEF)
				.setPosition(Define.POSITION_OF_CHIEF)
				.setYearsOfWork(30)
				.setBasicSalary(Define.DEFAULT_BASIC_SALARY)
				.build();
	}
	
	@Test
	public void testBuilderSetAllowanceWithDeputy() {
		s = new  Staff.StaffBuilder(Define.lastestId, Define.TYPE_OF_STAFF)
			.setPosition(Define.POSITION_OF_DEPUTY)
			.setAllowance(Define.ALLOWANCE_OF_DEPUTY)
			.build();
	}
	
	@Test
	public void testBuilderSetAllowanceWithMaster() {
		s = new Staff.StaffBuilder(Define.lastestId, Define.TYPE_OF_STAFF)
			.setPosition(Define.POSITION_OF_EMPLOYEE)
			.setAllowance(Define.ALLOWANCE_OF_EMPLOYEE)
			.build();
	}
	
	@Test
	public void test_toString() {
		assertEquals("Staff [homeTown=Da Nang, department=IBM, workDay=25, salaryRatio=2.5, allowance=1000, position=Chief, yearsOfWork=30, basicsalary=730.0]" ,s.toString());
	}
	
	@Test
	public void test_Staff() {
		Staff s = new Staff();
		assertNotNull(s);
	}
	
	@Test
	public void test_getID() {
		assertEquals(0 , s.getId());
	}
	
	@Test
	public void test_setName() {
		s.setName("Quan");
		assertEquals("Quan" , s.getName());
	}
	
	@Test
	public void test_setYearOfBirth() {
		s.setyearOfBirth(1999);
		assertEquals(1999 , s.getyearOfBirth());
	}
	
	@Test
	public void test_getType() {
		assertEquals(2 , s.getType());
	}
	
	@Test
	public void test_SetHomeTown() {
		s.setHomeTown("Da Nang");
		assertEquals("Da Nang" , s.getHomeTown());
	}
	
	@Test
	public void test_setDepartment() {
		s.setDepartment("IBM");
		assertEquals("IBM" , s.getDepartment());
	}
	
	@Test
	public void test_setWorkDay() {
		s.setWorkDay(50);
		assertEquals(50 , s.getWorkDay() , delta);
	}
	
	@Test
	public void test_setSalaryRatio() {
		s.setSalaryRatio((float) 2.5);
		assertEquals(2.5 , s.getSalaryRatio() , delta);
	}
	
	@Test
	public void test_setAllowanceOfChief() {
		s.setAllowance(Define.ALLOWANCE_OF_CHIEF);
		assertEquals(1000 , s.getAllowance() , delta);
	}
	
	@Test
	public void test_setAllowanceOfDeputy() {
		s.setAllowance(Define.ALLOWANCE_OF_DEPUTY);
		assertEquals(600 , s.getAllowance() , delta);
	}
	
	@Test
	public void test_setAllowanceOfEmployee() {
		s.setAllowance(Define.ALLOWANCE_OF_EMPLOYEE);
		assertEquals(400 , s.getAllowance() , delta);
	}
	
	@Test
	public void test_setPositionOfChief() {
		s.setPosition(Define.POSITION_OF_CHIEF);
		assertEquals("Chief" , s.getPosition());
	}
	
	@Test 
	public void test_setPositionOfDeputy() {
		s.setPosition(Define.POSITION_OF_DEPUTY);
		assertEquals("Deputy" , s.getPosition());
	}
	
	@Test
	public void test_setPositionOfEmployee() {
		s.setPosition(Define.POSITION_OF_EMPLOYEE);
		assertEquals("Employee" , s.getPosition());
	}
	
	@Test
	public void test_setYearsOfWork() {
		s.setYearsOfWork(25);
		assertEquals(25 , s.getYearsOfWork() , delta);
	}
	
	@Test
	public void test_setBasicSalary() {
		s.setBasicSalary(25000);
		assertEquals(25000 , s.getBasicSalary() , delta);
	}
	@Test
	public void test_update() {
		s.update(400);
		assertEquals(400 , s.getBasicSalary() , delta);
	}
	
	@Test
	public void test_getSalary() {
		assertEquals(3575,s.getSalary() , delta);
	}
}
