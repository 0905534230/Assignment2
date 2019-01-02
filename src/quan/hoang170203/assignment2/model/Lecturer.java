package quan.hoang170203.assignment2.model;

import java.util.Scanner;

import quan.hoang170203.assignment2.controller.Observer;
import quan.hoang170203.assignment2.define.Define;
import quan.hoang170203.assignment2.model.Person;

public class Lecturer extends Person implements Observer{

	private String homeTown;
	private String department;
	private String qualification;
	private int allowance;
	private int periodPerMonth;
	private float salaryRatio;
	private int yearsOfWork;
	private float basicSalary;
	private boolean isCreated;
	
	public Lecturer() {
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public int getPeriodPerMonth() {
		return periodPerMonth;
	}

	public void setPeriodPerMonth(int periodPerMonth) {
		this.periodPerMonth = periodPerMonth;
	}

	public float getSallaryRatio() {
		return salaryRatio;
	}

	public void setSalaryRatio(float salaryRatio) {
		this.salaryRatio = salaryRatio;
	}

	public int getYearsOfWork() {
		return yearsOfWork;
	}

	public void setYearsOfWork(int yearsOfWork) {
		this.yearsOfWork = yearsOfWork;
	}
	
	public float getbasicSalary() {
		this.basicSalary = basicSalary;
		return basicSalary;
	}
	
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	@Override
	public String toString() {
		return "Lecturer [homeTown=" + homeTown + ", department=" + department + ", qualification=" + qualification
				+ ", allowance=" + allowance + ", periodPerMonth=" + periodPerMonth + ", salaryRatio=" + salaryRatio
				+ ", yearsOfWork=" + yearsOfWork + ", basicsalary=" + basicSalary + "]";
	}
	public void input() {
		Scanner sc = new Scanner( System.in);
		
		System.out.println("Enter Name :" + ((isCreated)? this.name :""));
		this.name = sc.nextLine();
		
		System.out.println("Enter Year of birth :" + ((isCreated)? this.yearOfBirth :""));
		this.yearOfBirth = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter your hometown :" + ((isCreated)? this.homeTown :""));
		this.homeTown = sc.nextLine();
		
		System.out.println("Enter department :" + ((isCreated)? this.department :""));
		this.department = sc.nextLine();

		System.out.println("Enter periodPerMonth :" + ((isCreated)? this.periodPerMonth :""));
		this.periodPerMonth = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter SalaryRatio :" + ((isCreated)? this.salaryRatio :""));
		this.salaryRatio = Float.parseFloat(sc.nextLine());
	
		System.out.println("Enter YearofWork: " + ((isCreated)? this.yearsOfWork :""));
		this.yearsOfWork = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter BasicSalary" + ((isCreated)? this.basicSalary :""));
		this.basicSalary = Float.parseFloat(sc.nextLine());
	
		System.out.println("Choose qualification.\n" + ((isCreated)? this.qualification :"")
				         + "1. BACHELOR.\n "
						 + "2. MASTER.\n "
						 + "3. DOCTOR.\n");
				
		int selection = sc.nextInt();
		switch (selection) {
			case Define.TYPE_OF_BACHELOR: {
				qualification =Define.QUALIFICATION_OF_BACHELOR;
				allowance = Define.ALLOWANCE_OF_BACHELOR;
				break;
			}
			case Define.TYPE_OF_MASTER: {
				qualification = Define.QUALIFICATION_OF_MASTER;
				allowance = Define.ALLOWANCE_OF_DOCTOR;
				break;
			}
			case Define.TYPE_OF_DOCTOR: {
				qualification = Define.QUALIFICATION_OF_DOCTOR;
				allowance = Define.ALLOWANCE_OF_DOCTOR;
				break;
			}
		}
		if(!isCreated) {
			isCreated = true;
		}
	}
	private Lecturer (LecturerBuilder builder) {
		this.isCreated = false;
		this.id = builder.id;
		this.name = builder.name;
		this.type = builder.type;
		this.yearOfBirth = builder.yearOfBirth;
		this.homeTown = builder.homeTown;
		this.department = builder.department;
		this.qualification = builder.qualification;
		this.allowance = builder.allowance;
		this.periodPerMonth = builder.periodPerMonth;
		this.salaryRatio = builder.salaryRatio;
		this.yearsOfWork = builder.yearsOfWork;
		this.basicSalary = builder.basicSalary;
	}
	public static class LecturerBuilder{
		private int id;
		private String name;
		private int yearOfBirth;
		private int type;
		
		private String homeTown;
		private String department;
		private String qualification;
		private int allowance;
		private int periodPerMonth;
		private float salaryRatio;
		private int yearsOfWork;
		private int selection;
		private float basicSalary;
		
		public LecturerBuilder ( int id , int type) {
			this.id = id;
			this.type= type;
		}

		public LecturerBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public LecturerBuilder setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
		
		public LecturerBuilder setHomeTown(String homeTown) {
			this.homeTown = homeTown;
			return this;
		}

		public LecturerBuilder setDepartment(String department) {
			this.department = department;
			return this;
		}

		public LecturerBuilder setQualification(String qualification) {
			this.qualification = qualification;
			return this;
		}

		public LecturerBuilder setAllowance(int allowance) {
			this.allowance = allowance;
			return this;
		}

		public LecturerBuilder setPeriodPerMonth(int periodPerMonth) {
			this.periodPerMonth = periodPerMonth;
			return this;
		}

		public LecturerBuilder setSalaryRatio(float salaryRatio) {
			this.salaryRatio = salaryRatio;
			return this;
		}
		
		public LecturerBuilder setYearsOfWork(int yearsOfWork) {
			this.yearsOfWork = yearsOfWork;
			return this;
		}	
		
		public LecturerBuilder setBasicSalary (float basicSalary) {
			this.basicSalary = basicSalary;
			return this;
		}
		
		public Lecturer build () {
			return new Lecturer(this);
		}
	}
	@Override
	public void update(float basicSalary) {
			this.basicSalary = basicSalary;
	}

	@Override
	public float getSalary() {
		float salary = salaryRatio * basicSalary + allowance + periodPerMonth *45;
		return salary;
	}
}


