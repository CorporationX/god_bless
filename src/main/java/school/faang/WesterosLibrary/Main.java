package school.faang.WesterosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Title1", "Author1", 2001);
        Book book2 = new Book("Title2", "Author2", 2002);
        Book book3 = new Book("Title3", "Author3", 2003);

        LIBRARY.put(book1, "Shelf 1");
        LIBRARY.put(book2, "Shelf 2");
        LIBRARY.put(book3, "Shelf 3");

        addBook(new Book("Title4", "Author4", 2004), "Shelf 4");

        removeBook("Title2", "Author2", 2002);
        getShelf("Title2", "Author2", 2002);

        getShelf("Title4", "Author4", 2004);

        System.out.println();
        printAllBooks();
    }

    public static void addBook(Book book, String position) {
        LIBRARY.put(book, position);
    }

    public static void removeBook(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }

    public static void getShelf(String title, String author, int year) {
        String shelf = LIBRARY.get(new Book(title, author, year));
        if (shelf != null) {
            System.out.println(shelf);
        }
    }

    public static void printAllBooks(){
        LIBRARY.entrySet().forEach((e) -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
