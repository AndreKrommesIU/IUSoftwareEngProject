package ToDo_List;

import java.util.*;

public class ToDo_Array {
	
	public ArrayList<Task> taskList;
	
	public ToDo_Array() {
		taskList = new ArrayList<Task>();
	}
		
	//option taking a Task-Class Object
	public ArrayList<Task> addTaskToList(Task myTask) {
		this.taskList.add(myTask);
		return taskList;
	}
	
//	public ArrayList<Task> addTaskToList2(String title, String project, int priority) {
//		this.taskList.add(new Task(title,project,priority);
//		return taskList;
//	}
	

	//currently only counts the number of tasks
	public void listAllTasks(ToDo_Array tasklist) {
		System.out.println(
				this.taskList.size() + " Tasks:"
				);	
		for (Task t : taskList) {
			System.out.println(t.Title);
				
			
		}
	}
	


}
