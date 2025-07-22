package toDoList;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Activity {
	private String name;
	private LocalDate expiryDate ;
	private String priority;
	private boolean completed;
	private List<String> labels;

	public Activity(String name, LocalDate expiryDate, String priority) {
		this.name = name;
        this.expiryDate = expiryDate;
        this.priority = priority;
        this.completed = false;
        this.labels = new ArrayList<>();	
	}
	public Activity(String name, LocalDate expiryDate, String priority, List<String> labels) {
		this.name = name;
        this.expiryDate = expiryDate;
        this.priority = priority;
        this.completed = false;
        this.labels = labels;	
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
	
	//labels
	public void addLabel(String label) {
		labels.add(label.toLowerCase());
	}
	
	public void setLabels(List<String> labels) {
	    this.labels = labels.stream()
	                              .map(String::toLowerCase)
	                              .collect(Collectors.toList()); //Convert the stream back into a List after mapping each label to lowercase
	}															 // because .stream().map(...) returns a Stream, not a List

	public List<String> getLabels(){
		return labels;
	}
	
	@Override
	public String toString() {
		return "[" + (completed ? "✅" : "❌ ") + "] " 
				+ name 
				+ " | Expiry Date: " + expiryDate 
				+ " | Priority: " + priority 
				+ (labels.isEmpty() ? "" : " | Labels: " + labels);
	}
}
