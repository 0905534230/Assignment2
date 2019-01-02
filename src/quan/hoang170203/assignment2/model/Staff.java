package quan.hoang170203.assignment2.model;
import quan.hoang170203.assignment2.controller.Observer;
import quan.hoang170203.assignment2.define.Define;
import quan.hoang170203.assignment2.model.Person;


import java.util.Scanner;
public class Staff extends Person implements Observer {
	private String homeTown;
	private String department;
	private int workDay;
	private float salaryRatio;
	private int allowance;
	private String position;
	private int yearsOfWork;
	private float basicSalary;
	private boolean isCreated;
	
	public Staff() {
	}
	
	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getWorkDay() {
		return workDay;
	}

	public void setWorkDay(int workDay) {
		this.workDay = workDay;
	}

	public float getSalaryRatio() {
		return salaryRatio;
	}

	public void setSalaryRatio(float salaryRatio) {
		this.salaryRatio = salaryRatio;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getYearsOfWork() {
		return yearsOfWork;
	}

	public void setYearsOfWork(int yearsOfWork) {
		this.yearsOfWork = yearsOfWork;
	}
	
	public float getBasicSalary() {
		return basicSalary;
	}
	
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	@Override
	public String toString() {
		return "Staff [homeTown=" + homeTown + ", department=" + department + ", workDay=" + workDay + ", salaryRatio="
				+ salaryRatio + ", allowance=" + allowance + ", position=" + position + ", yearsOfWork=" + yearsOfWork
				+ ", basicsalary=" + basicSalary + "]";
	}
	public void input() {
		Scanner sc = new Scanner( System.in);		
		
		System.out.println("Enter Name :" + ((isCreated) ? this.name : ""));
		this.name = sc.nextLine();	

		System.out.println("Enter Year of birth :"+ ((isCreated)? this.yearOfBirth :""));
		this.yearOfBirth = Integer.parseInt(sc.nextLine());

		System.out.println("Enter your hometown :" + ((isCreated)? this.homeTown :""));
		this.homeTown = sc.nextLine();
		
		System.out.println("Enter department :" + ((isCreated)? this.department :""));
		this.department = sc.nextLine();

		System.out.println("Enter Workday :" + ((isCreated)? this.workDay :""));
		this.workDay = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter salaryRatio :" + ((isCreated)? this.salaryRatio :""));
		this.salaryRatio = Float.parseFloat(sc.nextLine());
		
		System.out.println("Enter Yearofwork: "+ ((isCreated)? this.yearsOfWork :""));
		this.yearsOfWork = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter BasicSalary" + ((isCreated)? this.basicSalary :""));
		this.basicSalary = Integer.parseInt(sc.nextLine());
		
		System.out.println("Choose Position.\n" + ((isCreated)? this.position :"")
						 + "1. CHIEF.\n"
						 + "2. DEPUTY.\n"
						 + "3. EMPLOYEE.\n");
		
		int selection = sc.nextInt();

		switch(selection) {
			case Define.TYPE_OF_CHIEF: {
				position = Define.POSITION_OF_CHIEF;
				allowance = Define.ALLOWANCE_OF_CHIEF;
				break;
			}
			case Define.TYPE_OF_DEPUTY: {
				position = Define.POSITION_OF_DEPUTY;
				allowance = Define.ALLOWANCE_OF_DEPUTY;
				break;
			}
			case Define.TYPE_OF_EMPLOYEE: {
				position = Define.POSITION_OF_EMPLOYEE;
				allowance = Define.ALLOWANCE_OF_EMPLOYEE;
				break;
			}
		}
		if (!isCreated) {
				isCreated = true;
		}
	}	
	private Staff (StaffBuilder builder) {
		this.isCreated = false;
		this.id = builder.id;
		this.name = builder.name;
		this.type = builder.type;
		this.yearOfBirth = builder.yearOfBirth;
		this.homeTown = builder.homeTown;
		this.department = builder.department;
		this.workDay = builder.workDay;
		this.salaryRatio = builder.salaryRatio;
		this.allowance = builder.allowance;
		this.position = builder.position;
		this.yearsOfWork = builder.yearsOfWork;
		this.basicSalary = builder.basicSalary;
	}
	public static class StaffBuilder{
		private int id;
		private String name;
		private int yearOfBirth;
		private int type;
		
		private String homeTown;
		private String department;
		private int workDay;
		private float salaryRatio;
		private int allowance;
		private String position;
		private int yearsOfWork;
		private int selection;
		private float basicSalary;
		
		public StaffBuilder(int id , int type) {
			this.id = id;
			this.type = type;
		}
		
		public StaffBuilder setName ( String name) {
			this.name = name;
			return this;
		}
		
		public StaffBuilder setHomeTown(String homeTown) {
			this.homeTown = homeTown;
			return this;
		}
		
		public StaffBuilder setyearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}

		public StaffBuilder setDepartment(String department) {
			this.department = department;
			return this;
		}

		public StaffBuilder setWorkDay(int workDay) {
			this.workDay = workDay;
			return this;
		}

		public StaffBuilder setSalaryRatio(float salaryRatio) {
			this.salaryRatio = salaryRatio;
			return this;
		}

		public StaffBuilder setAllowance(int allowance) {
			this.allowance = allowance;
			return this;
		}
		
		public StaffBuilder setPosition(String position) {
			this.position = position;
			return this;
		}

		public StaffBuilder setYearsOfWork(int yearsOfWork) {
			this.yearsOfWork = yearsOfWork;
			return this;
		}	
		
		public StaffBuilder setBasicSalary(float basicSalary) {
			this.basicSalary = basicSalary;
			return this;
		}
		
		public Staff build() {
			return new Staff(this);
		}	
	}
	
	@Override
	public void update(float basicSalary) {
			this.basicSalary = basicSalary;
	}

	@Override
	public float getSalary() {
			float salary = salaryRatio * basicSalary + allowance + workDay *30;
		return salary;
	}
}	
	
