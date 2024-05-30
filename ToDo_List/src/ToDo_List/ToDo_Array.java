package ToDo_List;

import java.util.*;
import java.time.format.DateTimeFormatter;

public class ToDo_Array {
	
	public ArrayList<Task> taskList;
	
	//Constructor
	public ToDo_Array() {
		taskList = new ArrayList<Task>();
	}
		
	//option adding a Task-Class Object
	public ArrayList<Task> addTaskToList(Task myTask) {
		this.taskList.add(myTask);
		return taskList;
	}
	//counting all Task-Class Objects in the Array
	public int countAllTasksInList() {
		int number_of_all_tasks = this.taskList.size();
		return number_of_all_tasks;
	}
	//counting incomplete Task-Class Objects in the Array
	public int countIncompleteTasksInList() {
		int number_of_incomplete_tasks = 0;
		for (Task t : taskList) {
			if (t.completion_status == false) {
				number_of_incomplete_tasks++;
			}
		}
		return number_of_incomplete_tasks;
	}

	//List all tasks given a ToDo Array Object
	public void listAllTasks() {
		//Table Header
		System.out.println(
				this.countAllTasksInList() + " Task(s) insgesamt:\n" +
				"Titel          | Projekt  | Prio | Status   | erstellt am      | fällig bis \n"+
				"============================================================================="
				);	
		//Loop to generate a row String for each task
		for (Task t : taskList) {
			String DueDate_String = t.DueDate.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
			String CreationDate_String = t.CreationDate.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
			System.out.println(
					padRight(t.Title, 15) + "| " + 
					padRight(t.Project, 9) + "| "+
					padRight(Integer.toString(t.Priority), 5) + "| "+
					padRight(t.completion_status ? "erledigt " : " " , 9) + "| "+
					padRight(CreationDate_String, 17) + "| "+
					DueDate_String
					);
		}
		System.out.println();
	}
	
	//List all tasks given a ToDo Array Object
	public void listIncompleteTasks() {
		//Table Header
		System.out.println(
				this.countIncompleteTasksInList() + " Task(s) zu erledigen:\n" +
				"Titel          | Projekt  | Prio | erstellt am      | fällig bis \n"+
				"================================================================="
				);	
		//Loop to generate a row String for each task
		for (Task t : taskList) {
			if (t.completion_status == false) {
			String DueDate_String = t.DueDate.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
			String CreationDate_String = t.CreationDate.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
			System.out.println(
					padRight(t.Title, 15) + "| " + 
					padRight(t.Project, 9) + "| "+
					padRight(Integer.toString(t.Priority), 5) + "| "+
					padRight(CreationDate_String, 17) + "| "+
					DueDate_String
					);
			}
		}
		System.out.println();
	}
	
	//Methods for String Padding
	public static String padRight(String s, int n) {
	     return String.format("%-" + n + "s", s);  
	}
	public static String padLeft(String s, int n) {
	    return String.format("%" + n + "s", s);  
	}
	
	



}
