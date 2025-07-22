package toDoList;


import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ActivityHandler handler = new ActivityHandler();
		boolean cont = true;
		
		while (cont) {
			
				System.out.print(
				"\n ---TO DO LIST---\n"+
				"---------------------------------------\n"+
				"(1) Add activity\n"+
				"(2) Show activity\n"+
				"(3) Complete activity\n"+
				"(4) Delete activty\n"+
				"(5) Search activty\n"+
				"(6) Completed activities:\n"+
				"(0) Exit \n"+
				"\n Select > "
				);
				
				String input = scanner.nextLine();
				int choice;
				
				try {
					choice = Integer.parseInt(input);
				} catch (NumberFormatException e){
					System.out.println("Invalid input. Please enter a number!");
					continue;
					
				}
				
				switch(choice) {
					case 1:
						System.out.println("Activity name: ");
						String name = scanner.nextLine();
						System.out.println("Expiry Date (YYYY-MM-DD): ");
						LocalDate date = LocalDate.parse(scanner.nextLine());
						System.out.println("Priority (High|Medium|Low): ");
						String priority = scanner.nextLine();
						handler.addActivity(new Activity(name, date, priority));
						break;
					case 2:
						handler.showActivity();
						break;
					case 3:
						System.out.println("Activity index: ");
						int index = scanner.nextInt()-1;
						scanner.nextLine();
						handler.completeActivity(index);
						break;
					case 4:
						System.out.println("Index of the activity to be deleted: ");
						int indexDel = scanner.nextInt()-1;
						scanner.nextLine();
						handler.removeActivity(indexDel);
						break;
					case 5:
						System.out.println("Search by keyword: ");
						String keyword = scanner.nextLine();
						List<Activity> filteredAct = handler.searchByKeyWord(keyword);
						if (filteredAct.isEmpty()) {
							System.out.println("No activity found");
						} else {
							System.out.println("Activities found: ");
							filteredAct.forEach(System.out::println);
						}
						break;
					case 6:
						System.out.println("Completed activities : ");
						List<Activity> completed = handler.completedActivity();
						if (completed.isEmpty()) {
							System.out.println("No completed activity found");
						} else {
							completed.forEach(System.out::println);
						}
						break;
					case 0:
						cont = false;
						break;
					default:
						System.out.println("Invalid choice");		
				}	
		}	
		 scanner.close();
	        System.out.println("Goodbye!!");
	}
}




