package m;

import java.util.ArrayList;
import java.util.Observable;
import m.SomeDataClass;


public class People extends Observable{
	
	private String firstName;
	private String surname;
	private String employeeNum;
	private int capacity;
	private ArrayList<People> people;
	private SomeDataClass someData;
	private int hisTime=0;
	
	public People(String firstName, String surname, String employeeNum, int capacity , SomeDataClass someData) {
		people = new ArrayList<People>();
		this.firstName = firstName;
		this.surname = surname;
		this.employeeNum = employeeNum;
		this.capacity = capacity;
		this.someData = someData;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public ArrayList<People> getPeople(){
		return people;
	}
	
	public void add_People(People person) {
		System.out.println(person.getFirstName()+" "+ person.getSurname() +" "+person.getEmployeeNum()+" "+person.getCapacity());
		people.add(person);
		someData.setPeoples(people);
		setChanged();
		notifyObservers(person);
	}

	public void setTime(int time){
		hisTime = time;
	}

	public int getTime(){
		return hisTime;
	}
	
}