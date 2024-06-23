package ToDo_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.format.DateTimeFormatter;

public class ToDo_Array {
	
	private ArrayList<Task> taskList;
	private static String filename = "ToDo-List.obj";
	
	//-----------------------Constructor-----------------------------------------------
	public ToDo_Array() {
		taskList = new ArrayList<Task>();
	}
	
	//-----------------------Getter & Setter-----------------------------------------------
	public ArrayList<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(ArrayList<Task> taskList) {
		this.taskList = taskList;
	}
	
	//---------------------------Methods----------------------------------------------------
	//adding a Task-Class Object
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
			if (t.isCompletion_status() == false) {
				number_of_incomplete_tasks++;
			}
		}
		return number_of_incomplete_tasks;
	}
	
	//counting incomplete Task-Class Objects in the Array
	public int countCompleteTasksInList() {
		int number_of_complete_tasks = 0;
		for (Task t : taskList) {
			if (t.isCompletion_status() == true) {
				number_of_complete_tasks++;
			}
		}
		return number_of_complete_tasks;
	}
	
	public void deleteCompletedTasks(){
		this.taskList.removeIf(t -> (t.isCompletion_status() == true));
	}
	
	public Task[] turnArrayListIntoArray(){
		Task[] taskArray = taskList.toArray(new Task[taskList.size()]);
		return taskArray;
	}
	
	//Write a Obj-File containing the current Task Array
	public void writeToDoListFile(){
	try {
		FileOutputStream fileOut = new FileOutputStream(filename);
		ObjectOutputStream output = new ObjectOutputStream(fileOut);
		System.out.println("Datei erfolgreich gespeichert.");
		output.writeObject(taskList);
		output.close();
		fileOut.close();
		return;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		return;
		}
	}
	
	//Read Tasks in existing Obj-File and save as taskList Attribute
	@SuppressWarnings("unchecked")
	public void readToDoListFile(){
	try {
		FileInputStream fileIn = new FileInputStream(filename);
		ObjectInputStream input = new ObjectInputStream(fileIn);
		System.out.println("Datei wird ausgelesen.");
		taskList = (ArrayList<Task>) input.readObject();
		input.close();
		fileIn.close();
		return;
		} catch(Exception e) {
		System.out.println(e.getMessage());
		return;
		}
	}
	
//-------------from here: (useless) methods fpr console output-----------------
	
	//List all tasks in the ToDo Array Object
	public void listAllTasks() {
		//Table Header
		System.out.println(
				this.countAllTasksInList() + " Task(s) insgesamt:\n" +
				"Titel          | Projekt  | Prio | Status   | erstellt am      | fällig bis \n"+
				"============================================================================="
				);	
		//Loop to generate a row String for each task
		for (Task t : taskList) {
			String DueDate_String = t.getDueDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
			String CreationDate_String = t.getCreationDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
			System.out.println(
					padRight(t.getTitle(), 15) + "| " + 
					padRight(t.getProject(), 9) + "| "+
					padRight(Integer.toString(t.getPriority()), 5) + "| "+
					padRight(t.isCompletion_status() ? "erledigt " : " " , 9) + "| "+
					padRight(CreationDate_String, 17) + "| "+
					DueDate_String
					);
		}
		System.out.println();
	}
	
	
	//List all uncompleted tasks in the ToDo Array Object
	public void listIncompleteTasks() {
		//Table Header
		System.out.println(
				this.countIncompleteTasksInList() + " Task(s) zu erledigen:\n" +
				"Titel          | Projekt  | Prio | erstellt am      | fällig bis \n"+
				"================================================================="
				);	
		//Loop to generate a row String for each task
		for (Task t : taskList) {
			if (t.isCompletion_status() == false) {
			String DueDate_String = t.getDueDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
			String CreationDate_String = t.getCreationDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
			System.out.println(
					padRight(t.getTitle(), 15) + "| " + 
					padRight(t.getProject(), 9) + "| "+
					padRight(Integer.toString(t.getPriority()), 5) + "| "+
					padRight(CreationDate_String, 17) + "| "+
					DueDate_String
					);
			}
		}
		System.out.println();
	}


    //Array Sorting Methods
    public void sortArrayByProjectThenTitle() {
    	Collections.sort(taskList, Comparator.comparing(Task::getProject).thenComparing(Task::getTitle));
    }
    public void sortArrayByTitle() {
    	Collections.sort(taskList, Comparator.comparing(Task::getTitle));
    }
    
    public void sortArrayByDueDateASC() {
    	Collections.sort(taskList, Comparator.comparing(Task::getDueDateYear).thenComparing(Task::getDueDateMonth).thenComparing(Task::getDueDateDay));
    }
    public void sortArrayByDueDateDESC() {
    	Collections.sort(taskList, Comparator.comparing(Task::getDueDateYear).thenComparing(Task::getDueDateMonth).thenComparing(Task::getDueDateDay));
    	Collections.reverse(taskList);
    }
    public void sortArrayByCreationDateASC() {
    	Collections.sort(taskList, Comparator.comparing(Task::getCreationDateYear).thenComparing(Task::getCreationDateMonth).thenComparing(Task::getCreationDateDay));
    }
    
    public void sortArrayByCompletionStatus() {
    	Collections.sort(taskList, Comparator.comparing(Task::isCompletion_status));
    }
	
	
	//Helper Methods for String Padding
	public static String padRight(String s, int n) {
	     return String.format("%-" + n + "s", s);  
	}
	public static String padLeft(String s, int n) {
	    return String.format("%" + n + "s", s);  
	}
	

}
