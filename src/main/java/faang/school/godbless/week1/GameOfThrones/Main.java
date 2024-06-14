package faang.school.godbless.week1.GameOfThrones;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // HashMap to store houses with house name as key
    private static Map<String, House> houses = new HashMap<>();
    private static Library library = new Library();

    public static void main(String[] args) {
        // Adding initial houses to the HashMap
        addHouse(new House("Stark", "A grey direwolf on a white field"));
        addHouse(new House("Lannister", "A golden lion on a crimson field"));
        addHouse(new House("Baratheon", "A crowned black stag on a gold field"));
        addHouse(new House("Targaryen", "A red three-headed dragon on a black field"));

        // Adding initial books to the Library
        library.addBook(new Book("A Game of Thrones", "George R. R. Martin", 1996), "Shelf 1");
        library.addBook(new Book("A Clash of Kings", "George R. R. Martin", 1998), "Shelf 2");
        library.addBook(new Book("A Storm of Swords", "George R. R. Martin", 2000), "Shelf 3");
        library.addBook(new Book("A Feast for Crows", "George R. R. Martin", 2005), "Shelf 4");

        // Scanner for reading user input
        Scanner scanner = new Scanner(System.in);

        // Infinite loop to keep the program running until the user chooses to exit
        while (true) {
            // Display menu options
            System.out.println("1. Manage Houses\n2. Manage Library\n3. Exit");
            System.out.print("Choose an option: ");

            // Read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Perform an action based on the user's choice
            switch (choice) {
                case 1:
                    manageHouses(scanner);
                    break;
                case 2:
                    manageLibrary(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // Exit the main method, thus ending the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageHouses(Scanner scanner) {
        while (true) {
            System.out.println("1. Add House\n2. Remove House\n3. Find House\n4. List Houses\n5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Perform an action based on the user's choice
            switch (choice) {
                case 1:
                    System.out.print("Enter house name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter house sigil: ");
                    String sigil = scanner.nextLine();
                    addHouse(new House(name, sigil));
                    break;
                case 2:
                    System.out.print("Enter house name to remove: ");
                    name = scanner.nextLine();
                    removeHouse(name);
                    break;
                case 3:
                    System.out.print("Enter house name to find: ");
                    name = scanner.nextLine();
                    findHouse(name);
                    break;
                case 4:
                    listHouses();
                    break;
                case 5:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageLibrary(Scanner scanner) {
        while (true) {
            System.out.println("1. Add Book\n2. Remove Book\n3. Find Book\n4. List Books\n5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter book location: ");
                    String location = scanner.nextLine();
                    library.addBook(new Book(title, author, year), location);
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter book year: ");
                    year = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    library.removeBook(new Book(title, author, year));
                    break;
                case 3:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter book year: ");
                    year = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    library.findBook(new Book(title, author, year));
                    break;
                case 4:
                    library.listBooks();
                    break;
                case 5:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a house to the HashMap
    public static void addHouse(House house) {
        houses.put(house.getName(), house);
        System.out.println(house.getName() + " has been added.");
    }

    // Method to remove a house by its name
    public static void removeHouse(String name) {
        House removedHouse = houses.remove(name);
        if (removedHouse != null) {
            System.out.println(name + " has been removed.");
        } else {
            System.out.println("House " + name + " not found.");
        }
    }

    // Method to find a house by its name and print its sigil
    public static void findHouse(String name) {
        House house = houses.get(name);
        if (house != null) {
            System.out.println("House " + name + "'s sigil: " + house.getSigil());
        } else {
            System.out.println("House " + name + " not found.");
        }
    }

    // Method to list all houses and their sigils
    public static void listHouses() {
        if (houses.isEmpty()) {
            System.out.println("No houses available.");
        } else {
            System.out.println("Listing all houses:");
            for (House house : houses.values()) {
                System.out.println(house);
            }
        }
    }
}
