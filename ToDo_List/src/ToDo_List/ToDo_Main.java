package ToDo_List;

import java.util.*;

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
		
		Task Task2 = new Task();
		Task2.Title = "Cleaning";
		Task2.Project = "HOME";
		Task2.Priority = 2;
				
		ToDo_Array my_taskList = new ToDo_Array();
		my_taskList.addTaskToList(Task1);
		my_taskList.addTaskToList(Task2);
	
		
		my_taskList.listAllTasks(my_taskList);
	}
	

}
