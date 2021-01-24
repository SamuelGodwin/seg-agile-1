package m;
import java.util.ArrayList;
import java.util.Observable;
import m.SomeDataClass;


public class Task extends Observable{
	
	private String name;
	private int capacity;
	private ArrayList<Task> requirements;
	private int time;
	private ArrayList<Task> tasks;
	private boolean isDone=false;
	private SomeDataClass someData;
	private int startTime=0;
	private int endTime=0;
	private int people;

	public Task(String name, int capacity, ArrayList<Task> requirements, int time , int people , SomeDataClass someData) {
		tasks = new ArrayList<Task>();
		this.name = name;
		this.capacity = capacity;
		this.requirements = requirements;
		this.time = time;
		this.someData=someData;
		this.people = people;
	}

	public String getName(){
		return name;
	} 

	public int getCapacity(){
		return capacity;
	}

	public int getPeople(){
		return people;
	}

	public void setPeople(int thePeople){
		people = thePeople;
	}

	public int getTime(){
		return time;
	}

	public ArrayList<Task> getRequirements() {
      return requirements;
    }

	
	public void setName(String theName) {
		name=theName;
	}
	
	public void setCapacity(int theCapacity) {
		capacity = theCapacity;
	}
	
	public void setTime(int theTime) {
		time = theTime;
	}

	public void setStartTime(int sTime){
		startTime=sTime;
	}

	public int getStartTime(){
		return startTime;
	}

	public void setEndTime(int eTime){
		endTime=eTime;
	}

	public int endTime(){
		return endTime;
	}
	
	
	public void setRequirements(ArrayList<Task> theRequirements) {
		this.requirements = theRequirements;
	}
  
    public void add_Task(Task task) {
        tasks.add(task);
        someData.setTasks(tasks);
        setChanged();
        notifyObservers(tasks);
    }
    public ArrayList<Task> getTasks() {
    	return tasks;
    }

    public void setIsDone(boolean done){
    	isDone=done;
    }

	public boolean isDone() {
		return isDone;
	}

}