package quan.hoang170203.assignments.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.Result;

public class TestRunner {
	   public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(TestSuite.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }
	}  	

