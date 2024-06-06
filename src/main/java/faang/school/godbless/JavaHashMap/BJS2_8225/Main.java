package faang.school.godbless.JavaHashMap.BJS2_8225;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.JavaHashMap.BJS2_8225.Main.bookList;

public class Main {
    static Map<Book, String> bookList = new HashMap<>();
    public static void main(String[] args) {
        bookList.put(new Book("Rasteniya", "Balabaeva", 2001), "Biologiya");
        bookList.put(new Book("Animals", "Bibikova", 2003), "Biologiya");
        bookList.put(new Book("Numbers", "Ramazamov", 2002), "Matematica");
        Book.addBook("Geometry", "Salanov", 2005, "Matematica");
        Book.removeBook("Animals", "Bibikova", 2003);
        Book.searchBook("Rasteniya", "Balabaeva", 2001);
        Book.printAllBook();
    }
}
@AllArgsConstructor
@Data
class Book {
    private String title;
    private String author;
    private int year;
    public static void addBook(String titleName, String authorName, int yearWritten, String section) {
        Book book = new Book(titleName, authorName, yearWritten);
        bookList.put(book, section);
    }
    public static void removeBook(String titleName, String authorName, int yearWritten) {
        Book bookToRemove = new Book(titleName, authorName, yearWritten);
        bookList.remove(bookToRemove);
    }
    public static void searchBook(String titleName, String authorName, int yearWritten) {
        System.out.println("Book found: " + bookList.get(new Book(titleName, authorName, yearWritten)));
    }

    public static void printAllBook() {
        for (Map.Entry<Book, String> entry : bookList.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}