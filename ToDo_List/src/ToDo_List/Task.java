package ToDo_List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

public class Task implements Serializable {
	
	private String Project;
	private String Title;
	private int Priority;
	private LocalDate CreationDate = LocalDate.now();
	private LocalDate DueDate;
	private boolean completion_status = false; 
	
	//Haupt-Konstruktor
	public Task(String title, String project, int priority, LocalDate dueDate) {
		Title = title;
		Project = project;
		Priority = priority;
		DueDate = dueDate;
	}

	Task() {
		//leerer Test counstructor für Main Methoden
	}

	public String getProject() {
		return Project;
	}

	public String getTitle() {
		return Title;
	}

	public int getPriority() {
		return Priority;
	}

	public LocalDate getCreationDate() {
		return CreationDate;
	}

	public LocalDate getDueDate() {
		return DueDate;
	}

	public boolean isCompletion_status() {
		return completion_status;
	}

	public void setProject(String project) {
		Project = project;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public void setCreationDate(LocalDate creationDate) {
		CreationDate = creationDate;
	}

	public void setDueDate(LocalDate dueDate) {
		DueDate = dueDate;
	}

	public void setCompletion_status(boolean completion_status) {
		this.completion_status = completion_status;
	}
	
	//Date-Parts Getter
	public int getDueDateYear() {
		LocalDate due = this.getDueDate();
		return due.getYear();
	}
	public int getDueDateMonth() {
		LocalDate due = this.getDueDate();
		return due.getMonthValue();
	}
	public int getDueDateDay() {
		LocalDate due = this.getDueDate();
		return due.getDayOfMonth();
	}
	
	public int getCreationDateYear() {
		LocalDate cre = this.getCreationDate();
		return cre.getYear();
	}
	public int getCreationDateMonth() {
		LocalDate cre = this.getCreationDate();
		return cre.getMonthValue();
	}
	public int getCreationDateDay() {
		LocalDate cre = this.getCreationDate();
		return cre.getDayOfMonth();
	}

	@Override
	public String toString() {
		return "Task [Title=" + Title + ", Project=" + Project+ ", Priority=" + Priority + ", CreationDate="
				+ CreationDate + ", DueDate=" + DueDate + ", completion_status=" + completion_status + "]";
	}
	
	public int getAttributeCount() {
		return getClass().getDeclaredFields().length;
	}
	
	public Object[] turnTaskIntoArray(){
		String CreationDate_String = this.getCreationDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));		
		String DueDate_String = this.getDueDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
		
		
		Object[] taskArr = {
				this.getTitle(),
				this.getProject(),
				this.getPriority(),
				this.isCompletion_status() ? "erledigt" : " ", 
				CreationDate_String,
				DueDate_String};
		return taskArr;
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

