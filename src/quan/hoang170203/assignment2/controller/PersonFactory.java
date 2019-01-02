package quan.hoang170203.assignment2.controller;
import quan.hoang170203.assignment2.define.Define;
import quan.hoang170203.assignment2.model.CasualWorker;
import quan.hoang170203.assignment2.model.Lecturer;
import quan.hoang170203.assignment2.model.Person;
import quan.hoang170203.assignment2.model.Staff;


public class PersonFactory {
	public static Person getPerson(int type) {
		Define.lastestId++;
		switch (type) {
		case Define.TYPE_OF_LECTURER: return new Lecturer.LecturerBuilder(type , Define.lastestId).build();
		case Define.TYPE_OF_CASUALWORKER: return new CasualWorker.CasualWorkerBuilder(Define.lastestId , type).build();
		case Define.TYPE_OF_STAFF: return new Staff.StaffBuilder(Define.lastestId , type ).build();
		}
		return null;
	}
	
}
