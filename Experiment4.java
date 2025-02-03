import java.util.ArrayList;
import java.util.Scanner;

public class Experiment4 {

    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert\n2. Search\n3. Delete\n4. Display\n5. Exit");
            System.out.print("Enter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to be inserted: \n");
                    String insertItem = scanner.nextLine();
                    items.add(insertItem);
                    System.out.println("Inserted successfully");
                    break;

                case 2:
                    System.out.print("Enter the item to search : \n");
                    String searchItem = scanner.nextLine();
                    if (items.contains(searchItem)) {
                        System.out.println("Item found in the list.");
                    } else {
                        System.out.println("Item not found in the list.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the item to delete : \n");
                    String deleteItem = scanner.nextLine();
                    if (items.remove(deleteItem)) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Item does not exist.");
                    }
                    break;

                case 4:
                    System.out.println("The Items in the list are :");
                    for (String item : items) {
                        System.out.println(item);
                    }
                    break;

                case 5:
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}