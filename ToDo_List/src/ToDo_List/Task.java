package ToDo_List;

import java.time.LocalDate;
import java.io.Serializable;

public class Task implements Serializable {
	
	public static int counter = 0;
	
	public String Project;
	public String Title;
	public int Priority;
	public LocalDate CreationDate = LocalDate.now();
	public LocalDate DueDate;
	public boolean completion_status = false; 
	
	Task() {
		//counstructor über Input Methoden
		counter++;
	}

	//function to check Title length (limit)
	//or generally: user inputs
	
	
	//Konstruktor-Methode zum Erstellen von Tasks
//	public Task(String project, String title, int priority, LocalDate dueDate) {
//		this.Project = project;
//		this.Title = title;
//		this.Priority = priority;
//		//später anpassen
//		this.DueDate = LocalDate.of(2022,1,8);
//		this.CreationDate = LocalDate.now();
//	}
	
}

