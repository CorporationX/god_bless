package faang.school.godbless.library_of_westerose;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        run();

    }

    public static void run() {
        Map<Book, String> mapOfLibrary = new HashMap<>();

        Book book1 = new Book("Don Quixote", "Miguel de Cervantes", 1605);
        Book book2 = new Book("Moby-Dick", "Herman Melville", 1851);
        Book book3 = new Book("The Great Gatsby", "Scott Fitzgerald", 1925);

        mapOfLibrary.put(book1, "1234");
        mapOfLibrary.put(book2, "3456");
        mapOfLibrary.put(book3, "5678");

        System.out.println(mapOfLibrary);

        while (true) {

            menu();
            System.out.println("Enter number: ");
            int number = Util.getIntegerInput();

            if (number == 1) {
                printAllBooksWithShelfNumber(mapOfLibrary);

            } else if (number == 2) {
                addNewBook(mapOfLibrary);

            } else if (number == 3) {
                searchTheBookInLibrary(mapOfLibrary);

            } else if (number == 4) {
                removeTheBook(mapOfLibrary);

            } else if (number == 5) {
                System.out.println("You are QUIT");
                break;

            } else {
                System.out.println("Unknown command! Try again!");
            }
        }
    }

    private static void removeTheBook(Map<Book, String> mapOfLibrary) {
        System.out.println("Enter book name: ");
        String name = Util.readLine();
        System.out.println("Enter author: ");
        String author = Util.readLine();
        System.out.println("Enter year:");
        int year = Util.getIntegerInput();
        Book book = new Book(name, author, year);
        if (mapOfLibrary.containsKey(book)) {
            System.out.println("The Book: " + book.getTitle() + " was remove.");
            mapOfLibrary.remove(book);
        } else {
            System.out.println("The Book: " + book.getTitle() + " not found!");
        }
    }

    private static void searchTheBookInLibrary(Map<Book, String> mapOfLibrary) {
        System.out.println("Enter book name: ");
        String name = Util.readLine();
        System.out.println("Enter author: ");
        String author = Util.readLine();
        System.out.println("Enter year:");
        int year = Util.getIntegerInput();

        Book book = new Book(name, author, year);

        if (mapOfLibrary.containsKey(book)) {
            System.out.println("The Book: " + book.getTitle() + " is in shelf number: " + mapOfLibrary.get(book));
        } else {
            System.out.println("The Book: " + book.getTitle() + " not found in the library!");
        }
    }

    private static void addNewBook(Map<Book, String> mapOfLibrary) {
        System.out.println("Enter book name:");
        String name = Util.readLine();
        System.out.println("Enter author:");
        String author = Util.readLine();
        System.out.println("Enter year:");
        int year = Util.getIntegerInput();

        Book newBook = new Book(name, author, year);
        String shelf = String.valueOf(Util.randomNumberShelf());
        mapOfLibrary.put(newBook, shelf);
    }

    private static void printAllBooksWithShelfNumber(Map<Book, String> mapOfLibrary) {
        System.out.println("All BOOKS: ");
        for (Map.Entry<Book, String> entry : mapOfLibrary.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static void menu() {
        System.out.println("***MENU***");
        System.out.println("1 - print all books and shelfs");
        System.out.println("2 - add new book");
        System.out.println("3 - search a book shelf number");
        System.out.println("4 - remove the book");
        System.out.println("5 - QUIT");
    }
}
