package school.faang.task_45332;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();
        books.put(new Book("title1", "author1", 1999), "shelf1");
        books.put(new Book("title2", "author2", 1998), "shelf2");
        books.put(new Book("title3", "author3", 1997), "shelf3");
        books.put(new Book("title4", "author4", 1996), "shelf4");
        library.addBook("title5", "author5", 1995, "shelf5");
        library.removeBook("title2", "author2", 1998);
        library.findBook("title6", "author6", 2000);
        library.printAllBooks();
    }
}
