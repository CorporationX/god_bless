package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Book, String> bookPlace = new HashMap<>();

    public static void mainStart() {
        Scanner in = new Scanner(System.in);

        Book headFirstJava = new Book("Head First Java", "Katie Sierra and Bert Bates", 2003);
        Book javaForDummies = new Book("Java for dummies", "Barry Bird", 2006);
        Book javaBeginnersGuide = new Book("Java. Beginner's Guide", "Herbert Shildt", 2002);
        System.out.print("Enter a location for the book" + headFirstJava.getTitle() + ":");
        String place = in.nextLine();
        additionBookPlace(headFirstJava, place);
        System.out.print("\nEnter a location for the book" + javaForDummies.getTitle() + ":");
        place = in.nextLine();
        additionBookPlace(javaBeginnersGuide, place);
        System.out.print("\nEnter a location for the book" + javaBeginnersGuide.getTitle() + ":");
        place = in.nextLine();
        additionBookPlace(javaForDummies, place);
        removeBook("Java for dummies", "Barry Bird", 2006);
        searchBook("Java. Beginner's Guide", "Herbert Shildt", 2002);
        printAllBooks();
    }

    private static void additionBookPlace(Book book, String place) {
        bookPlace.put(book, place);
    }

    private static void removeBook(String name, String author, int year) {
        bookPlace.remove(new Book(name, author, year));
    }

    private static void searchBook(String name, String author, int year) {
        System.out.println("place book with title: " + name + " in library: " + bookPlace.get(new Book(name, author, year)));
    }

    private static void printAllBooks() {
        bookPlace.forEach(
                (book, place) -> {
                    System.out.println(book.toString() + " Book place in the library: " + place);
                }
        );
    }
}
