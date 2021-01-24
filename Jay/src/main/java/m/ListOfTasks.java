package m;
import java.util.ArrayList;
import java.lang.Math;

public class ListOfTasks{

    private static ArrayList<Task> tasks;

    public ListOfTasks() {
        tasks = new ArrayList<Task>();
//    	Task task1 = new Task("shave", 1 , 3);
//    	Task task2 = new Task("eat" , 3 , 4);
//    	tasks.add(task1);
//    	tasks.add(task2);
    }

    public void add_Task(Task task) {
        tasks.add(task);
    }
    public ArrayList<Task> getTasks() {

    	return tasks;
    }
}

//pass the list from the panel to the controller
//pass the list from the controller to the panel