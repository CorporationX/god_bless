package school.faang.task_45287;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> lib = new HashMap<Book, String>();
        Book book1 = new Book("war of wor", "Dostoevski", 1998);
        Book book2 = new Book("title2", "author2", 1995);
        Book book3 = new Book("title3", "author3", 1891);
        Book book4 = new Book("title4", "author4", 1334);
        Book book5 = new Book("title5", "author5", 2015);
        Book book6 = new Book("title6", "author6", 2023);
        Book book7 = new Book("title7", "author7", 2001);

        lib.put(book1, "Polka2");
        lib.put(book2, "Polka5");
        lib.put(book3, "Polka7");
        lib.put(book4, "Polka9");
        lib.put(book5, "Polka2");
        lib.put(book6, "Polka15");
        lib.put(book7, "Polka28");

        LibrarySystem.findPolka("title2", "author2", 1995, (HashMap<Book, String>) lib);
        LibrarySystem.booksList((HashMap<Book, String>) lib);
        LibrarySystem.addBook("title15", "author16", 2024, "polka15", (HashMap<Book, String>) lib);
        LibrarySystem.removeBook("title2", "author2", 1995, (HashMap<Book, String>) lib);
        LibrarySystem.booksList((HashMap<Book, String>) lib);
    }
}
