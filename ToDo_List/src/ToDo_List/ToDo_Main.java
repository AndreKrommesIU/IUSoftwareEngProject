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
		Task1.Title = "Homework";
		Task1.Project = "HOME";
		Task1.Priority = 1;
		Task1.DueDate = LocalDate.of(2022, Month.APRIL, 5);
		Task1.completion_status = true;
		System.out.println("Task-Counter = " + Task.counter);	
		
		Task Task2 = new Task();
		Task2.Title = "Cleaning";
		Task2.Project = "HOME";
		Task2.Priority = 2;
		Task2.DueDate = LocalDate.of(2024, 9, 29);
				

		
		ToDo_Array my_taskList = new ToDo_Array();
		my_taskList.addTaskToList(Task1);
		my_taskList.addTaskToList(Task2);
		
		my_taskList.writeToDoListFile();
		
		
		
		ToDo_Array read_taskList = new ToDo_Array();
		read_taskList.readToDoListFile();
		read_taskList.listAllTasks();
		
		
		
	}
	

}
