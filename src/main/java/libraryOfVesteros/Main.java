package libraryOfVesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {

        Book dragons = new Book("All about the Dragons", "Daenerys", 1300);
        Book swords = new Book("All about the Sword", "Jaime Lannister ", 1280);
        Book government = new Book("All about Government", "Tyrion Lannister", 1290);

        addBook(dragons, "Полка 1");
        addBook(swords, "Полка 2");
        addBook(government, "Полка 3");
        findAllBooks();

        deleteBook(swords);
        findAllBooks();

        System.out.println(findBook(government));
    }

    public static void addBook(Book book, String storage) {
        LIBRARY.put(book, storage);
    }

    public static void deleteBook(Book book) {
        LIBRARY.remove(book);
    }

    public static String findBook(Book book) {
        if (!LIBRARY.containsKey(book)) {
            return "There is no such book";
        } else {
            return "The book is stored on '" + LIBRARY.get(book) + "'";
        }
    }

    public static void findAllBooks() {
        for (Map.Entry<Book, String> entry : LIBRARY.entrySet()) {
            System.out.println("Info about book: " + entry.getKey());
            System.out.println("Storage: " + entry.getValue() + "\n");

        }
    }


}
