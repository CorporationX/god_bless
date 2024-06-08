package faang.school.godbless.module1.sprint1.task7;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<Book, String> LIBRARY_OF_WESTEROS = new HashMap<>();

    public static void main(String[] args) {
        LIBRARY_OF_WESTEROS.put(new Book("Dragons", "Ary", 1115), "first shelf");
        LIBRARY_OF_WESTEROS.put(new Book("Rivers", "Linger", 1210), "second shelf");
        LIBRARY_OF_WESTEROS.put(new Book("Sigils", "Big Po", 18), "third shelf");
        Book book = new Book("History of 2 Towers", "Frey", 175);
        addBookInLibrary(book, "fifth shelf");
        deleteBookByTitleAuthorYear("Rivers", "Linger", 1210);
        findBookByTitleAuthorYear("Rivers", "Linger", 1210);
        listAllBooks();
    }

    public static void addBookInLibrary(Book book, String shelf) {
        LIBRARY_OF_WESTEROS.put(book, shelf);
    }

    public static void deleteBookByTitleAuthorYear(String title, String author, int year) {
        LIBRARY_OF_WESTEROS.remove(new Book(title,author,year));
    }

    public static void findBookByTitleAuthorYear(String title, String author, int year) {
        LIBRARY_OF_WESTEROS.get(new Book(title, author, year));
    }

    public static void listAllBooks() {
        System.out.println(LIBRARY_OF_WESTEROS);
    }

}
