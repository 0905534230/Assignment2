package quan.hoang170203.assignments.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;

import quan.hoang170203.assignment2.define.Define;
import quan.hoang170203.assignment2.model.Lecturer;

public class LecturerTest {
	private final double delta = 0.0001;
	
	Lecturer l;
	

	@Before
	public void test_builder() {
		l = new Lecturer.LecturerBuilder(Define.lastestId, Define.TYPE_OF_LECTURER)
			.setYearOfBirth(1999)
			.setName("Quan")
			.setHomeTown("Da Nang")
			.setDepartment("CSE")
			.setQualification(Define.QUALIFICATION_OF_BACHELOR)
			.setAllowance(Define.ALLOWANCE_OF_BACHELOR)
			.setPeriodPerMonth(30)
			.setSalaryRatio((float) 2.5)
			.setYearsOfWork(15)
			.setBasicSalary(Define.DEFAULT_BASIC_SALARY)
			.build();		
	}
	
	@Test
	public void testBuilderSetAllowanceWithDoctor() {
		l = new  Lecturer.LecturerBuilder(Define.lastestId, Define.TYPE_OF_LECTURER)
			.setQualification(Define.QUALIFICATION_OF_DOCTOR)
			.setAllowance(Define.ALLOWANCE_OF_DOCTOR)
			.build();
	}
	
	@Test
	public void testBuilderSetAllowanceWithMaster() {
		l = new  Lecturer.LecturerBuilder(Define.lastestId, Define.TYPE_OF_LECTURER)
			.setQualification(Define.QUALIFICATION_OF_MASTER)
			.setAllowance(Define.ALLOWANCE_OF_MASTER)
			.build();
	}
	
	@Test
	public void test_toString() {
		assertEquals( "Lecturer [homeTown=Da Nang, department=CSE, qualification=Bachelor, allowance=300, periodPerMonth=30, salaryRatio=2.5, yearsOfWork=15, basicsalary=730.0]", l.toString());		
	}
	
	@Test
	public void test_Lecturer() {
		Lecturer l= new Lecturer();
		assertNotNull(l);
	}
	
	@Test
	public void test_getId() {
		assertEquals(0, l.getId());
	}
	
	@Test
	public void test_setName() {
		l.setName("Quan");
		assertEquals("Quan" ,l.getName());
	}
	
	@Test
	public void test_setYearOfBirth() {
		l.setyearOfBirth(1999);
		assertEquals(1999 , l.getyearOfBirth());
	}
	
	@Test
	public void test_getType() {
		assertEquals(1 , l.getType());
	}
	
	@Test
	public void test_SetHomeTown() {
		l.setHomeTown("Da Nang");
		assertEquals("Da Nang" , l.getHomeTown());
	}
	
	@Test
	public void test_setDepartment() {
		l.setDepartment("CSE");
		assertEquals("CSE" , l.getDepartment());
	}
	
	@Test
	public void test_setQualificationOfBachelor() {
		l.setQualification(Define.QUALIFICATION_OF_BACHELOR);
		assertEquals("Bachelor" , l.getQualification());
	}
	
	@Test
	public void test_setQualificationOfMaster() {
		l.setQualification(Define.QUALIFICATION_OF_MASTER);
		assertEquals("Master" , l.getQualification());
	}
	
	@Test
	public void test_setQualificationOfDoctor() {
		l.setQualification(Define.QUALIFICATION_OF_DOCTOR);
		assertEquals("Doctor" , l.getQualification());
	}
	
	@Test
	public void test_setAllowanceOfBachelor() {
		l.setAllowance(Define.ALLOWANCE_OF_BACHELOR);
		assertEquals(300 , l.getAllowance() , delta);
	}
	
	@Test
	public void test_setAllowanceOfDoctor() {
		l.setAllowance(Define.ALLOWANCE_OF_DOCTOR);
		assertEquals(2000 , l.getAllowance() , delta);
	}
	
	@Test
	public void test_setAllowanceOfMaster() {
		l.setAllowance(Define.ALLOWANCE_OF_MASTER);
		assertEquals(900 , l.getAllowance() , delta);
	}
	
	@Test
	public void test_setPeriodPerMonth() {
		l.setPeriodPerMonth(25);
		assertEquals(25 , l.getPeriodPerMonth() , delta);
	}
	
	@Test
	public void test_setSalaryRatio() {
		l.setSalaryRatio((float) 2.5);
		assertEquals(2.5 , l.getSallaryRatio() , delta);
	}
	
	@Test
	public void test_setYearsOfWork() {
		l.setYearsOfWork(25);
		assertEquals(25 , l.getYearsOfWork() , delta);
	}
	
	@Test
	public void test_setBasicSalary() {
		l.setBasicSalary(25000);
		assertEquals(25000 , l.getbasicSalary() , delta);
	}
	
	@Test
	public void test_update() {
		l.update(400);
		assertEquals(400 , l.getbasicSalary() , delta);
	}
	
	@Test
	public void test_getSalary() {
		assertEquals(3475,l.getSalary() , delta);
	}
	
}
