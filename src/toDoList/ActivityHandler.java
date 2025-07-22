package toDoList;

import java.util.ArrayList;
import java.util.List;

public class ActivityHandler {
	
	private List<Activity> list;
	
	public ActivityHandler() {
		list = new ArrayList<>();
	}
	
	public void addActivity(Activity activity) {
		list.add(activity);
	}
	
	public void showActivity() {
		if (list.isEmpty()) {
			System.out.println("No activity found!");
		} else {
			for (Activity activity : list) {
				System.out.println((list.indexOf(activity)+1) + "- " + activity);
			}
		}
	}
	
	public void completeActivity(int index) {
		if(index >= 0 && index < list.size()) {
			list.get(index).setCompleted(true);
			System.out.println("Activity completed!");
		} else {
			System.out.println("Index not found!");
		}
	}
	
	public void removeActivity(int index) {
		if(index >= 0 && index < list.size()) {
			list.remove(index);
			System.out.println("Activity removed");
		} else {
			System.out.println("Index not found!");
		}
	}
	
	
	

}
