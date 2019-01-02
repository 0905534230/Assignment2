package quan.hoang170203.assignments.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import quan.hoang170203.assignment2.controller.Observer;
import quan.hoang170203.assignment2.controller.PersonFactory;
import quan.hoang170203.assignment2.controller.Subject;
import quan.hoang170203.assignment2.define.Define;
import quan.hoang170203.assignment2.model.CasualWorker;
import quan.hoang170203.assignment2.model.Lecturer;
import quan.hoang170203.assignment2.model.Person;
import quan.hoang170203.assignment2.model.Staff;

public class Menu {
	
	public static int inputChoice(int min , int max) {
		Scanner scanner = new Scanner(System.in);
		int value = min - 1;
		boolean check = false;
		
		System.out.println("Input choice ( " + min + " - " + max + ")");
		
		while(check == false) {
			System.out.println("Input your choice :");
			value = Integer.parseInt(scanner.nextLine());
			
			if ( value < min || value > max)
				System.out.println("Wrong input :");
			else
				check = true;
		}
		return value;
	}
	
	public static int chooseTypeOfEmployee() {
		Scanner scanner = new Scanner (System.in);
		int value;
		System.out.println("1.Lecturer. \n" 
							+ "2.Staff. \n"
							+ "3.Casual Worker");
		value = inputChoice(1 , 3);
		switch(value) {
		case 1: return Define.TYPE_OF_LECTURER;
		case 2: return Define.TYPE_OF_STAFF;
		default: return Define.TYPE_OF_CASUALWORKER;
		}
		
	}
	
	public static void View() {
		int value;
		while(true) {
		System.out.println("Menu");
		System.out.println("1. Add new worker");
		System.out.println("2. Edit employee information ");
		System.out.println("3. Delete employee");
		System.out.println("4. Display employee");
		System.out.println("5. Delete total data");
		System.out.println("6. Display salary all of worker in system");
		System.out.println("7. Update basic salary");
		System.out.println("8. Nhap danh sach ma can bo subscribe luong co ban");
		System.out.println("9. Exit");
		
		value = inputChoice (1,9);
		switch (value) {
		case 1:{
			Menu1();
			break;
			}
		case 2:{
			Menu2();
			break;
		}
		case 3:{
			Menu3();
			break;
		}
		case 4:{
			Menu4();
			break;
			}
		case 5: {
			Menu5();
			break;
		}
		case 6:{
			Menu6();
			break;
		}
		case 7:{
			Menu7();
			break;
		}
		case 8:{
			Menu8();
			break;
		}
		case 9:{
			Menu9();
			break;
		}
		}
	}
}
	public static void Menu1() {
		System.out.println("1.1 Add new employee in the bottom");
		System.out.println("1.2 Add new employee on the top ");
		System.out.println("1.3 Add new employee after specific position");
		System.out.println("1.4 Add new employee in the bottom from staff.txt");
		System.out.println("1.5 Add new employee worker from labor.text");
		System.out.println("1.6 Return");
		
		int value = inputChoice (1,6);
		switch (value) {
		case 1 : {
			switch (chooseTypeOfEmployee()) {
			case Define.TYPE_OF_LECTURER: {
				Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
				lecturer.input();
				Define.persons.add(lecturer);
				break;
			}
			case Define.TYPE_OF_STAFF: {
				Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
				staff.input();
				Define.persons.add(staff);
				break;
				}
			default: {
				CasualWorker casualworker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUALWORKER);
				casualworker.input();
				Define.persons.add(casualworker);
				break;
			}
			}
			break;
		}	
		case 2 : {
			switch (chooseTypeOfEmployee()) {
			case Define.TYPE_OF_LECTURER: {
				Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
				lecturer.input();
				Define.persons.add(0 , lecturer);
				break;
			}
			case Define.TYPE_OF_STAFF: {
				Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
				staff.input();
				Define.persons.add(0 , staff);
				break;
				}
			default: {
				CasualWorker casualworker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUALWORKER);
				casualworker.input();
				Define.persons.add(0 ,casualworker);
				break;
			}
			}	
			break;
		}		
		case 3 : {	
			Scanner scanner = new Scanner (System.in);
			System.out.println("Enter k position");
			int k = scanner.nextInt();
			switch (chooseTypeOfEmployee()) {
			case Define.TYPE_OF_LECTURER: {
				Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
				lecturer.input();
				Define.persons.add(k , lecturer);
				break;
			}
			case Define.TYPE_OF_STAFF: {
				Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
				staff.input();
				Define.persons.add(k , staff);
				break;
			}
			default: {
				CasualWorker casualworker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUALWORKER);
				casualworker.input();
				Define.persons.add(k ,casualworker);
				break;
			}
		}	
		break;
		}
		case 4 : {
			Scanner sc = null;
			try {
				sc = new Scanner (new File ("staff.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			int numberOfStaffs = Integer.parseInt(sc.nextLine());
			int type;
			int yearOfBirth;
			String name ;
			String qualification;
			int workDay;
			float salaryRatio;
			int allowance;
			String position;
			int yearsOfWork;
			float basicSalary;
			int periodPerMonth;
			String department;
			String homeTown;
			
			for (int index = 0  ; index < numberOfStaffs ;index++) {
				type = Integer.parseInt(sc.nextLine());
				yearOfBirth = Integer.parseInt(sc.nextLine());
				name = sc.nextLine();
				salaryRatio = Float.parseFloat(sc.nextLine());
				yearsOfWork = Integer.parseInt(sc.nextLine());
				basicSalary = Float.parseFloat(sc.nextLine());
				homeTown = sc.nextLine();
				department = sc.nextLine();
				
				switch(type) {
				case Define.TYPE_OF_STAFF:{
					position = sc.nextLine();
					workDay = Integer.parseInt(sc.nextLine());
					Staff newStaff = new Staff.StaffBuilder(Define.lastestId, Define.TYPE_OF_STAFF)
									.setyearOfBirth(yearOfBirth)
									.setName(name)
									.setYearsOfWork(yearsOfWork)
									.setSalaryRatio(salaryRatio)
									.setHomeTown(homeTown)
									.setDepartment(department)
									.setBasicSalary(basicSalary)
									.setWorkDay(workDay)
									.setPosition(position)
									.build();
					Define.persons.add(newStaff);			
					
					break;				
				}
				case Define.TYPE_OF_LECTURER:{
					qualification = sc.nextLine();
					periodPerMonth = Integer.parseInt(sc.nextLine());
					Lecturer newLecturer = new Lecturer.LecturerBuilder(Define.lastestId, Define.TYPE_OF_LECTURER)
									.setHomeTown(homeTown)
									.setDepartment(department)
									.setBasicSalary(basicSalary)
									.setQualification(qualification)
									.setYearsOfWork(yearsOfWork)
									.setSalaryRatio(salaryRatio)
									.setPeriodPerMonth(periodPerMonth)
									.setName(name)
									.setYearOfBirth(yearOfBirth)
									.build();
					Define.persons.add(newLecturer);
					break;
				}
				}
				
			}
			break;
		}
		case 5: {
			Scanner sc = null;
			try {
				sc = new Scanner (new File ("labor.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			int numberOfLabors = Integer.parseInt(sc.nextLine());
			int type;
			String name;
			int yearOfBirth;
			int workDay;
			int priceOfWorkDay;
			
			for ( int index = 0 ; index < numberOfLabors ; index++) {
				yearOfBirth = Integer.parseInt(sc.nextLine());
				name = sc.nextLine();
				workDay = Integer.parseInt(sc.nextLine());
				priceOfWorkDay = Integer.parseInt(sc.nextLine());
				
				
				CasualWorker newCasualWorker = new CasualWorker.CasualWorkerBuilder(Define.lastestId, Define.TYPE_OF_CASUALWORKER)
												.setPriceOfWorkDay(priceOfWorkDay)
												.setWorkDay(workDay)
												.setName(name)
												.setYearOfBirth(yearOfBirth)
												.build();
				Define.persons.add(newCasualWorker);
			}
		}
		case 6: {
			return;
		}
	}
}		
	public static void Menu2() {
		System.out.println("Enter employee number:");
		Scanner sc = new Scanner (System.in);
		int value = sc.nextInt();
		
		if ((value >= 0) && (value < Define.persons.size())) {
			Define.persons.get(value).input();
		}else {
			System.out.println("No result :");
		}	
	}
	
	public static void Menu3() {
		System.out.println("Enter employee number:");
		Scanner sc = new Scanner (System.in);
		int value = sc.nextInt();
		
		if(( value >= 0 ) && (value < Define.persons.size())) {
			Define.persons.remove(value);
		}else {
			System.out.println("No Result!");
		}
	}
	
	public static void Menu4() {
		int value;
		while (true) {
			System.out.println("4.1 Display current list");
			System.out.println("4.2 Display list after order by ASC salary");
			System.out.println("4.3 Display list after order by alphaB");
			System.out.println("4.4 Firgure out staff by name");
			System.out.println("4.5 Firgure out staff by year of birth");
			System.out.println("4.6 Return");
			value = inputChoice (1,6);
		switch (value) {
		case 1 : {
				showListPerson(Define.persons);
				break;
			}
		case 2 : {
			ArrayList <Person> persons = new ArrayList <>();
			persons = Define.persons;
								
			for (int i = 0; i < Define.persons.size(); i++) {
				for (int j = i+1; j < Define.persons.size(); j++) {
					if ( persons.get(i).getSalary() > persons.get(j).getSalary())
					{
						Person temp = persons.get(j);
						persons.set(j, persons.get(i));
						persons.set(i, temp);
					}
				}						
			}
			showListPerson(persons);
			break;
		}
		case 3: {
		ArrayList <Person> tempPersons = new ArrayList <>();
		tempPersons = (ArrayList<Person>) Define.persons.clone();
		Collections.sort(tempPersons , new Comparator<Person>() {
			
			@Override
			public int compare (Person p1 , Person p2) {
				return (p1.getName().compareTo(p2.getName()));
			}
		});	
			showListPerson(tempPersons);
			break;
		}
		case 4: {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name");
			String name = sc.nextLine();
			Person person;
			boolean isFound = false;
			ArrayList <Person> persons = new ArrayList <>();
			
			for (int index = 0 ; index < Define.persons.size() ; index++) {
					person = Define.persons.get(index);
						if(person.getName().toLowerCase().contains(name.toLowerCase())) {
							persons.add(person);
							isFound = true;
					}
			}		
			if (isFound == false ) {
				System.out.println("No Result");
			}else {
				showListPerson(persons);
			}
			break;
}		
		case 5: {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your Year Of Birth");
			int yearOfBirth = sc.nextInt();
			Person person;
			boolean isFound = false;
			ArrayList <Person> persons = new ArrayList <>();
			
			for (int index = 0 ; index < Define.persons.size() ; index++) {
					person = Define.persons.get(index);
						if(person.getyearOfBirth() == yearOfBirth) {
							persons.add(person);
							isFound = true;
						}
				}
			if (isFound == false ) {
				System.out.println("No Result");
			}else {
				showListPerson(persons);
			}
			break;
			}
		case 6: {
			return;
			}
		}
	}
}	
	public static void showListPerson(ArrayList<Person> persons) {
		System.out.format("%-4s %-20s %-15s %-10s %-15s %-6s %-6s %-6s %-6s %-6s %n", "#", "Name", "YearOfBirth", "HomeTown", "Type", "C1", "C2", "C3", "C4", "C5");
		for (int index = 0; index < persons.size(); index++) {
			System.out.format("%-4d %-20s %-15d "
					, index
					, persons.get(index).getName()
					, persons.get(index).getyearOfBirth());
			
			switch (persons.get(index).getType()) {
			case Define.TYPE_OF_LECTURER: {
				System.out.format("%-10s %-15s %-6s %-6s %-6d %-6d %-6f %n"
						, ((Lecturer)persons.get(index)).getHomeTown()
						, "GV"
						, ((Lecturer)persons.get(index)).getDepartment()
						, ((Lecturer)persons.get(index)).getQualification()
						, ((Lecturer)persons.get(index)).getAllowance()
						, ((Lecturer)persons.get(index)).getPeriodPerMonth()
						, ((Lecturer)persons.get(index)).getSallaryRatio());
				
				break;
			}
			
			case Define.TYPE_OF_STAFF: {
				System.out.format("%-10s %-15s %-6s %-6s %-6d %-6d %-6f %n"
						, ((Staff)persons.get(index)).getHomeTown()
						, "NV"
						, ((Staff)persons.get(index)).getDepartment()
						, ((Staff)persons.get(index)).getPosition()
						, ((Staff)persons.get(index)).getAllowance()
						, ((Staff)persons.get(index)).getWorkDay()
						, ((Staff)persons.get(index)).getSalaryRatio());
				
				break;
			}	
			default : {
				System.out.format("%-10s %-15s %-6s %-6s %-6s %-6d %-6d %n"
						, "NULL"
						, "CasualWorker"
						, "NULL"
						, "NULL"
						, "NULL"
						, ((CasualWorker)persons.get(index)).getWorkDay()
						, ((CasualWorker)persons.get(index)).getPriceOfWorkDay());
				
			}
			}
		}
	}



	public static void Menu5() {
		System.out.println("Already deleted");
		Define.persons.clear();
	}
	
	public static void Menu6() {
		System.out.println("List Name and Salary of employee ");
		System.out.format("%4s %20s %12s %n","#" , "Name" , "Salary");
		
		for(int index = 0 ; index < Define.persons.size() ; index++) {
			System.out.format("%4d %20s %12f %n"
					, index
					, Define.persons.get(index).getName()
					, Define.persons.get(index).getSalary());
		}
	}
	
	public static void Menu7() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter new minimum wage");
		Define.newbasicSalary = Float.parseFloat(sc.nextLine());
	}
	
	public static void Menu8() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter employees id");
		String text = sc.nextLine();
		String indexs[] = text.split(" ");
		
		Subject subject = new Subject ();
		int indexTemp;
		for (int index = 0 ; index < indexs.length ; index++) {
			indexTemp = Integer.parseInt(indexs[index]);
			if (( indexTemp >= 0) && (indexTemp < Define.persons.size()))
				if ((Define.persons.get(indexTemp).getType() == Define.TYPE_OF_LECTURER) || (Define.persons.get(indexTemp).getType() == Define.TYPE_OF_STAFF))
					subject.attach((Observer)Define.persons.get(indexTemp));
					
				else
				System.out.println("No Result");
			else
				System.out.println("No Result");

		}
		subject.notifyChange(Define.newbasicSalary);
	}
	
	public static void Menu9() {
		System.out.println("Exit");
		System.exit(0);
	}	
}
