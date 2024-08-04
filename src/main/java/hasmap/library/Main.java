package hasmap.library;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<Book, String> LIBRARY_MAP = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book(
                "Dragons, Wyrms, and Wyverns: Their Unnatural History",
                "Septon Barth",
                55
        );
        Book book2 = new Book(
                "Sea Demons: A History of the Children of the Drowned God of the Isles",
                "Archmaester Mancaster",
                131
        );
        Book book3 = new Book(
                "Tyrion Lannister's dragonlore",
                "Tyrion Lannister",
                270
        );
        addBook(book1, "section 1");
        addBook(book2, "section 2");
        addBook(book3, "section 1");
        searchBook("Tyrion Lannister's dragonlore", "Tyrion Lannister", 270);
        searchBook("Somebook", "idk", 1);
        printAllBook();
        removeBook(
                "Sea Demons: A History of the Children of the Drowned God of the Isles",
                "Archmaester Mancaster",
                131
        );
        removeBook("Bible", "God", -6000);
        printAllBook();
    }

    public static void addBook(@NonNull Book book, @NonNull String section) {
        if (LIBRARY_MAP.containsKey(book)) {
            System.out.println("This book is already in library");
        } else {
            LIBRARY_MAP.put(book, section);
        }
    }

    public static void removeBook(@NonNull String title, @NonNull String author, int year) {
        Book book = new Book(title, author, year);
        if (!LIBRARY_MAP.containsKey(book)) {
            System.out.println("There is no such book in library");
        } else {
            LIBRARY_MAP.remove(book);
            System.out.println("Book was removed from library");
        }
    }

    public static Book searchBook(@NonNull String title, @NonNull String author, int year) {
        Book book = new Book(title, author, year);
        if (!LIBRARY_MAP.containsKey(book)) {
            System.out.println("There is no such book in library");
            return null;
        } else {
            System.out.println("The book " + book.getTitle() + " in " + LIBRARY_MAP.get(book));
            return book;
        }
    }

    public static void printAllBook() {
        for (Map.Entry<Book, String> entry : LIBRARY_MAP.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
