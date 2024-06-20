package ToDo_List;

import java.util.*;
import java.time.*;

public class ToDo_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//changes are good x 4
	
		Messages.Hauptmenü();
		
		Scanner sc = new Scanner(System.in);
//		int input = sc.nextInt();
//		System.out.println(input);
		
		
		
		//======================================
		System.out.println("");
		System.out.println("================Ausgabe-Test erstellter Tasks===============");
		//======================================	
		Task Task1 = new Task();
		Task1.setTitle("Homework");
		Task1.setProject("HOME");
		Task1.setPriority(1);
		Task1.setDueDate(LocalDate.of(2022, Month.APRIL, 5));
		Task1.setCompletion_status(true);
		System.out.println("Task-Counter = " + Task.counter);	
		
		Task Task2 = new Task();
		Task2.setTitle("Cleaning");
		Task2.setProject("HOME");
		Task2.setPriority(3);
		Task2.setDueDate(LocalDate.of(2024, 9, 29));
		
		Task Task3 = new Task();
		Task3.setTitle("GUI");
		Task3.setProject("AT WORK");
		Task3.setPriority(2);
		Task3.setDueDate(LocalDate.of(2024, 8, 29));

		
		ToDo_Array my_taskList = new ToDo_Array();
		my_taskList.addTaskToList(Task1);
		my_taskList.addTaskToList(Task2);
		my_taskList.addTaskToList(Task3);
		
		my_taskList.writeToDoListFile();
		
		
		
		ToDo_Array read_taskList = new ToDo_Array();
		read_taskList.readToDoListFile();
		read_taskList.listAllTasks();
		
		read_taskList.sortArrayByProjectThenTitle();
		read_taskList.listAllTasks();
		read_taskList.listIncompleteTasks();
		
		read_taskList.sortArrayByCompletionStatus();
		read_taskList.listAllTasks();
		
		read_taskList.sortArrayByDueDateASC();
		read_taskList.listAllTasks();
		

		
		GUI myGUI = new GUI();
		myGUI.createGUI();
		
	}
	

}
