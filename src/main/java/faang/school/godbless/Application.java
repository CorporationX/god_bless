package faang.school.godbless;
import java.util.HashMap;
import java.util.Map;




public class Application {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();

        Book book1 = new Book("The song of ice and fire", "J. Martin", 2008);

        Book book2 = new Book("Prisoner of Azkaban", "J. Rowling", 2005);


        addBook(library, book1, "1");
        addBook(library, book2, "2");


        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        findBook(library, book2, "2");
        findBook(library, book2, "2");

    }

    static void getAllBooks(Map<Book, String> library) {
        System.out.println(library.keySet());

    }

    static void addBook(Map<Book, String> library, Book book, String value) {
        library.put(book, value);
    }

    static void findBook(Map<Book, String> library, Book book, String value) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            if (entry.getValue().equals(value)) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    static void removeBook(Map<Book, String> library, Book book, String value) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            if (entry.getValue().equals(value)) {
                library.remove(entry.getKey());
            }
        }

    }
}