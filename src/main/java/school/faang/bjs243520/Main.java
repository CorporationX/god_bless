package school.faang.bjs243520;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Book, String> booksLibrary = new HashMap<>();

        Book book1 = new Book("Title1", "Author1", 1900);
        booksLibrary.put(book1, "Shelve 1");
    }
}
