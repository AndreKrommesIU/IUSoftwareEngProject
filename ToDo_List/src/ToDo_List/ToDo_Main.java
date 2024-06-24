package ToDo_List;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ToDo_Main {

	public static void main(String[] args) {

	
//		//Messages.Hauptmenü();
//		
//		
//		
//		//======================================
//		System.out.println("");
//		System.out.println("================Ausgabe-Test erstellter Tasks===============");
//		//======================================	
//		Task Task1 = new Task();
//		Task1.setTitle("Homework");
//		Task1.setProject("HOME");
//		Task1.setPriority(1);
//		Task1.setDueDate(LocalDate.of(2022, Month.APRIL, 5));
//		Task1.setCompletion_status(true);
//		
//		Task Task2 = new Task();
//		Task2.setTitle("Cleaning");
//		Task2.setProject("HOME");
//		Task2.setPriority(3);
//		Task2.setDueDate(LocalDate.of(2024, 9, 29));
//		
//		Task Task3 = new Task();
//		Task3.setTitle("GUI");
//		Task3.setProject("AT WORK");
//		Task3.setPriority(2);
//		Task3.setDueDate(LocalDate.of(2024, 8, 29));
//
//		
//		ToDo_Array my_taskList = new ToDo_Array();
//		my_taskList.addTaskToList(Task1);
//		my_taskList.addTaskToList(Task2);
//		my_taskList.addTaskToList(Task3);
//		
//		
//		
//		//my_taskList.writeToDoListFile();
//		
//		
//		
//		ToDo_Array read_taskList = new ToDo_Array();
//		read_taskList.readToDoListFile();
//		read_taskList.listAllTasks();
//		System.out.println(read_taskList.countCompleteTasksInList());
//		
//		read_taskList.deleteCompletedTasks();
//		
//		read_taskList.listAllTasks();
		

		new GUI();
		

		
	}
	

}
