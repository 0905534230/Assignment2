package quan.hoang170203.assignments.test;

import quan.hoang170203.assignments.test.CasualWorkerTest;
import quan.hoang170203.assignments.test.LecturerTest;
import quan.hoang170203.assignments.test.StaffTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

	@Suite.SuiteClasses({
		LecturerTest.class,
		StaffTest.class,
		CasualWorkerTest.class
		
	})

	public class TestSuite {   
	}  
