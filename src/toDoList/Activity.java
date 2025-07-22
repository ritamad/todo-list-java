package toDoList;

import java.time.LocalDate;

public class Activity {
	private String name;
	private LocalDate expiryDate ;
	private String priority;
	private boolean completed;

	
	public Activity(String name, LocalDate expiryDate, String priority) {
		this.name = name;
        this.expiryDate = expiryDate;
        this.priority = priority;
        this.completed = false;
		
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed= completed;
	}
	
	@Override
	public String toString() {
		return "[" + (completed ? "✅" : "❌ ") + "] " + name + " | Expiry Date: " + expiryDate + " | Priority: " + priority;
	}
}
