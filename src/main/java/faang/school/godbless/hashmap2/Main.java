package faang.school.godbless.hashmap2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> bookArrangement = new HashMap<>();

    public static void main(String[] args) {
        addBook("Book1", "author1", 2003, "полка 1, место 5");
        addBook("Book2", "author2", 2010, "полка 1, место 6");
        addBook("Book3", "author3", 2010, "полка 2, место 2");
        addBook("Book4", "author3", 2011, "полка 2, место 3");
        addBook("Book5", "author4", 2005, "полка 3, место 6");
        findBook("Book3", "author3", 2010);
        displayAllBook();
        deleteBook("Book3", "author3", 2010);
        displayAllBook();

    }

    public static boolean checkBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return bookArrangement.containsKey(book);
    }

    public static void addBook(String title, String author, int year, String location) {
        bookArrangement.put(new Book(title, author, year), location);
    }

    public static void deleteBook(String title, String author, int year) {
        if (checkBook(title, author, year)) {
            bookArrangement.remove(new Book(title, author, year));
        } else {
            System.out.println("Книга не найдена");
        }
    }

    public static void findBook(String title, String author, int year) {
        if (checkBook(title, author, year)) {
            System.out.println(bookArrangement.get(new Book(title, author, year)));
        } else {
            System.out.println("Такой книги нет в библиотеке");
        }

    }

    public static void displayAllBook() {
        for (Map.Entry<Book, String> entry : bookArrangement.entrySet()) {
            System.out.println(entry.getKey().toString() + ": " + entry.getValue());
        }
    }
}
