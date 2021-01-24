package m;

import m.Task;
import java.util.Comparator;

class MyComp implements Comparator<Task>{

    @Override
	public int compare(Task task1 ,Task task2){
		return task1.getName().compareTo(task2.getName());
	}
}