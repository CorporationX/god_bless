package faang.school.godbless.BJS2_4950;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();

        Book atlasShrugged = new Book("Atlas shrugged", "Ayn Rand", 1957);
        Book toKillMockingbird = new Book("To kill mockingbird", "Harper Lee", 1960);
        Book iRobot = new Book("I Robot", "Isaac Asimov", 1950);

        Book.addBook(books, atlasShrugged, "shelf-1");
        Book.addBook(books, toKillMockingbird, "shelf-2");
        Book.addBook(books, iRobot, "shelf-3");
        Book.printAllBooks(books);

        Book.deleteBook(books, toKillMockingbird);
        Book.printAllBooks(books);

        System.out.println(Book.findBookByName(books, atlasShrugged));

        System.out.println(Book.findBookByName(books, iRobot));
    }
}
