package school.faang.the_library_of_westeros_bjs2_79622;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LibrarySystem {
    HashMap<Book, String> map = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        map.put(book, location);
        System.out.printf("Книга %s добавлена\n", title);
    }

    public void removeBook(String title, String author, int year) {
        Book keyToRemove = new Book(title, author, year);
        map.remove(keyToRemove);
        System.out.printf("Книга %s удалена\n", title);
    }

    public void findBook(String title, String author, int year) {
        Book keyToFind = new Book(title, author, year);

        if (map.get(keyToFind) == null) {
            System.out.println("Книга не найдена\n");
        } else {
            System.out.println(map.get(keyToFind));
        }
    }

    public void printAllBooks() {
        Set<Map.Entry<Book, String>> entries = map.entrySet();

        for (Map.Entry<Book, String> entry : entries) {
            Book key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("%s %s\n", key.toString(), value);
        }
    }
}
