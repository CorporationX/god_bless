package hasmap.library;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Book, String> libraryMap = new HashMap<>();
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
        addBook(libraryMap, book1, "section 1");
        addBook(libraryMap, book2, "section 2");
        addBook(libraryMap, book3, "section 1");
        searchBook(libraryMap, "Tyrion Lannister's dragonlore", "Tyrion Lannister", 270);
        searchBook(libraryMap, "Somebook", "idk", 1);
        printAllBook(libraryMap);
        removeBook(
                libraryMap,
                "Sea Demons: A History of the Children of the Drowned God of the Isles",
                "Archmaester Mancaster",
                131
        );
        removeBook(libraryMap, "Bible", "God", -6000);
        printAllBook(libraryMap);
    }

    public static void addBook(@NonNull Map<Book, String> libraryMap, @NonNull Book book, @NonNull String section) {
        if (libraryMap.containsKey(book)) {
            System.out.println("This book is already in library");
        } else {
            libraryMap.put(book, section);
        }
    }

    public static void removeBook(@NonNull Map<Book, String> libraryMap, @NonNull String title, @NonNull String author, int year) {
        Book book = new Book(title, author, year);
        if (!libraryMap.containsKey(book)) {
            System.out.println("There is no such book in library");
        } else {
            libraryMap.remove(book);
            System.out.println("Book was removed from library");
        }
    }

    public static Book searchBook(@NonNull Map<Book, String> libraryMap, @NonNull String title, @NonNull String author, int year) {
        Book book = new Book(title, author, year);
        if (!libraryMap.containsKey(book)) {
            System.out.println("There is no such book in library");
            return null;
        } else {
            System.out.println("The book " + book.getTitle() + " in " + libraryMap.get(book));
            return book;
        }
    }

    public static void printAllBook(@NonNull Map<Book, String> libraryMap) {
        for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
