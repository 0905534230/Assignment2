package quan.hoang170203.assignment2.model;

import java.util.Scanner;

public class CasualWorker extends Person {
	private int workDay;
	private int priceOfWorkDay;
	private boolean isCreated;
	
	public CasualWorker() {
	}
	
	public int getWorkDay() {
		return workDay;
	}

	public void setWorkDay(int workDay) {
		this.workDay = workDay;
	}

	public int getPriceOfWorkDay() {
		return priceOfWorkDay;
	}

	public void setPriceOfWorkDay(int priceOfWorkDay) {
		this.priceOfWorkDay = priceOfWorkDay;
	}

	@Override
	public String toString() {
		return "CasualWorker [workDays=" + workDay + ", priceOfWorkDay=" + priceOfWorkDay + "]";
	}
	public void input() {
		Scanner sc = new Scanner( System.in);
		
		System.out.println("Enter Name: " + ((isCreated)?  this.name :""));
		this.name = sc.nextLine();
		
		System.out.println("Enter YearOfBirth :" + ((isCreated)? this.yearOfBirth :""));
		this.yearOfBirth = sc.nextInt();
		
		System.out.println("Enter Number Workdays:" + ((isCreated)? this.workDay :""));
		this.workDay = sc.nextInt();

		System.out.println("Enter Number PriceOfWorkDay:" + ((isCreated)? this.priceOfWorkDay :""));
		this.priceOfWorkDay = sc.nextInt();

		if (!isCreated) {
			isCreated = true;
		}
	}
	private CasualWorker (CasualWorkerBuilder builder) {
		this.isCreated = false;
		this.id = builder.id;
		this.name = builder.name;
		this.type = builder.type;
		this.yearOfBirth = builder.yearOfBirth;
		this.workDay = builder.workDay;
		this.priceOfWorkDay = builder.priceOfWorkDay;
	}
	public static class CasualWorkerBuilder{
		private int id;
		private String name;
		private int yearOfBirth;
		private int type;
		
		private int workDay;
		private int priceOfWorkDay;
		
		public CasualWorkerBuilder (int id , int type) {
			this.id = id;
			this.type = type;
		}

		public CasualWorkerBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public CasualWorkerBuilder setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
		
		public CasualWorkerBuilder setWorkDay(int workDay) {
			this.workDay = workDay;
			return this;
		}
	
		public CasualWorkerBuilder setPriceOfWorkDay(int priceOfWorkDay) {
			this.priceOfWorkDay = priceOfWorkDay;
			return this;
		}
		public CasualWorker build() {
			return new CasualWorker(this);
		}
	}
	@Override
	public float getSalary() {
			float salary = workDay * priceOfWorkDay ;
		return 0;
	}	
}
