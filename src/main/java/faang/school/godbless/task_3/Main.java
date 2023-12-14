package faang.school.godbless.task_3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> booksInLibrary = new HashMap<>();

    public static void main(String[] args) {

        Book book1 = new Book("Poor Folk", "Dostoyevsky F.M.", 1846);
        Book book2 = new Book("The Idiot", "Dostoyevsky F.M.", 1869);
        Book book3 = new Book("Taras Bulba", "Gogol N.V.", 1835);
        Book book4 = new Book("Childhood", "Tolstoy L.N.", 1852);

        addBookInLibrary(book1, "rack-2");
        addBookInLibrary(book2, "rack-1");
        addBookInLibrary(book3, "rack-4");
        addBookInLibrary(book4, "rack-4");

        getAllBooksInLibrary();

        searchBookInLibrary(book2);

        removeBookInLibrary(book2);

        searchBookInLibrary(book2);

        getAllBooksInLibrary();
    }

    public static void addBookInLibrary(Book book, String rackInLibrary) {
        booksInLibrary.put(book, rackInLibrary);
    }

    public static void removeBookInLibrary(Book book) {
        if (booksInLibrary.containsKey(book)) {
            booksInLibrary.remove(book);
            System.out.println("Remove from library: " + book.getTittle() + '\n');
        } else {
            System.out.println("There is no such book in the library");
        }
    }

    public static void searchBookInLibrary(Book book) {
        if (booksInLibrary.containsKey(book)) {
            System.out.println("Find book: " + book.getTittle() + " - " + booksInLibrary.get(book));
        } else {
            System.out.println("Book: " + book.getTittle() + " there is no such in the library");
        }
    }

    public static void getAllBooksInLibrary() {
        booksInLibrary.forEach((key, value) -> System.out.println(key.getTittle() + " - " + value));
    }
}
