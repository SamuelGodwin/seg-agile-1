/**
 * 
 */
package m;

import m.Task;
import m.MyComp;
import java.util.ArrayList;
import m.People;
import java.util.Observable;
import java.util.Arrays;
import java.util.TreeMap;


/**
 * Class description - THIS IS JUST AN EXAMPLE MODEL
 * 
 * @author Samuel
 *
 */
public class SomeDataClass extends Observable{
	
	//private String[] someArray;
	//private String someString;
	private People people;
	private Task task;
	private ArrayList<People> peoples = new ArrayList<People>();
	private ArrayList<Task> tasks = new ArrayList<Task>();
	private TreeMap<Task , ArrayList<People>> theEnd = new TreeMap<Task ,ArrayList<People>>(new MyComp());
	
	public SomeDataClass(People people , Task task){
		this.people=people;
		this.task=task;
	}

	public SomeDataClass(){

	}


	
	public People getPeople() {
		
		return people;
	
	}
	
	public Task getTask() {
		return task;
		
	}

	public void setPeoples(ArrayList<People> persons){
		peoples = persons;
		setChanged();
		notifyObservers(persons);
	}

	public ArrayList<People> getPeoples(){
		return peoples;
	}

	public void setTasks(ArrayList<Task> myTask){
		tasks = myTask;
		

		setChanged();
		notifyObservers(myTask);
		
	}

	public ArrayList<Task> getTasks(){
		return tasks;
	}

	public String[] getStrings(){
		String[] myString = new String[19];
			for(int i = 0; i<tasks.size();i++){
				myString[i] = tasks.get(i).getName();
			}
		return myString;
	}
	
	//calculates and returns an arrayList of which task has which person and at which time
	public TreeMap<Task , ArrayList<People>> calculations() {
		theEnd = new TreeMap<Task ,ArrayList<People>>(new MyComp());
		if(getPeoples().isEmpty()==false && getTasks().isEmpty()==false){
			//System.out.println("it should go there at a point");
			for(Task myTask : getTasks()){
				myTask.setStartTime(0);
				myTask.setEndTime(0);
				myTask.setIsDone(false);
			}
			for (People aPerson : getPeoples()){
				aPerson.setTime(0);
			}
			assignSTasks();
			assignRTasks();
		}
		return theEnd;
	}

	public void assignSTasks(){
		ArrayList<People> someRand = new ArrayList<People>();
		int someRandTime=9999;
		for(Task myTask : getTasks()){
			if(myTask.getRequirements().isEmpty()){
				//System.out.println("maybe you should change to is empty");
				if(myTask.isDone()==false){
					myTask.setIsDone(true);
					for(People aPerson : getPeoples()){
						//System.out.println("blabla");
						if(aPerson.getTime()<=someRandTime){
							someRandTime=aPerson.getTime();
						}
					}
					for(People aPerson : getPeoples())
					{
						if(aPerson.getTime()== someRandTime){
							int aTime= myTask.getTime()+(myTask.getCapacity()-aPerson.getCapacity())/2;
							if(aTime<=aPerson.getTime()){
								aTime = 1;
							}
							//System.out.println("it should go there at a point ");
							int newTime = aPerson.getTime()+aTime;
							myTask.setStartTime(aPerson.getTime());
							aPerson.setTime(newTime);
							myTask.setEndTime(newTime);
							someRand.add(aPerson);
							//System.out.println(someRand.get(0).getFirstName());
							//System.out.println(aPerson.getFirstName());
							//System.out.println(myTask.getName());
							someRandTime = 90000;
							theEnd.put(myTask , someRand);
							//System.out.println("might have broken there");
							someRand = new ArrayList<People>();
							break;
						}
					}
				}
			}
		}
	}

	public void assignRTasks(){
		ArrayList<People> someRand = new ArrayList<People>();
		int someRandTime=9999;
		for(Task myTask : getTasks()){
			if(!myTask.getRequirements().isEmpty()){
				//System.out.println("maybe you should change to is empty");
				if(myTask.isDone()==false){
					myTask.setIsDone(true);
					for(People aPerson : getPeoples()){
						//System.out.println("blabla");
						if(aPerson.getTime()<=someRandTime){
							someRandTime=aPerson.getTime();
						}
					}
					for(People aPerson : getPeoples())
					{
						if(aPerson.getTime()== someRandTime || aPerson.getTime()<=someRandTime+1){
							System.out.println(myTask.getPeople());
							if(someRand.size() < myTask.getPeople()){
							someRand.add(aPerson);
							System.out.println("que");
							//System.out.println(someRand.get(0).getFirstName());
							}
						}

					}
					int capacities=0;
					for(People aPerson : someRand){
						capacities += aPerson.getCapacity();
						if(someRandTime<= aPerson.getTime()){
							someRandTime = aPerson.getTime();
						}
					}
					
					int newCapacity= capacities/someRand.size();
					//System.out.println(someRand.size());
					int aTime= someRandTime + myTask.getTime()+(myTask.getCapacity()-newCapacity)/2;
					System.out.println("lolipop");
					myTask.setStartTime(someRandTime);
							if(aTime<=someRandTime){
								aTime = 1;
							}

					//divide by the amount of people
					//calculate the new ending time
					for(People aPerson : someRand){

						aPerson.setTime(aTime);
						
					}
					myTask.setEndTime(aTime);
					//set to this task the correct time calculated
					// add to the treeMap 
					theEnd.put(myTask , someRand);
					// new someRand
					someRandTime = 9000;
					//newSomeRandTime
					someRand = new ArrayList<People>();
					//should maybe break
				}
			}
		}
	}
}
