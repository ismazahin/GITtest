//header
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for program execution preferences
        System.out.println("How would you like your program to run with?");
        System.out.println("1. LinkedList");
        System.out.println("2. Queue");
        System.out.print("Enter your choice (1 or 2): ");

        // Retrieve user's choice
        int choice = scanner.nextInt();

        // Switch statement to determine program flow based on user's choice
        switch (choice) {
            case 1:
                PlatformAdmiApp.main(args); // Run PlatformAdmiApp for LinkedList
                break;
            case 2:
                PlatformAdmiAppQueue.main(args); // Run PlatformAdmiAppQueue for Queue
                break;
            default:
                System.out.println("Invalid choice. Exiting."); // Handling invalid input
        }

        scanner.close(); // Closing the scanner to release resources
    }
}
