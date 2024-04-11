package faang.school.godbless.module.first.hashmap.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOK_TO_ACTIVITY = new HashMap<>();

    public static void main(String[] args) {
        Book java = new Book("Java book", "Joshua Bloch", 1994);
        Book sport = new Book("Sport book", "Huseyn Bolt", 2010);
        Book javaEfficiency = new Book("Java Efficiency Book", "Kto-to tam", 2015);
        addBook(java, "Programming");
        addBook(sport, "Sport");
        addBook(javaEfficiency, "Programming");
        printActivityByBookParameters(java.getTitle(), java.getAuthor(), java.getYear());
        printAllBooks(BOOK_TO_ACTIVITY);
        deleteBook(sport.getTitle(), sport.getAuthor(), sport.getYear());
        printAllBooks(BOOK_TO_ACTIVITY);
    }

    public static void addBook(Book book, String activity) {
        BOOK_TO_ACTIVITY.putIfAbsent(book, activity);
    }

    public static void deleteBook(String title, String author, int year) {
        BOOK_TO_ACTIVITY.remove(new Book(title, author, year));
    }

    public static void printActivityByBookParameters(String title, String author, int year) {
        String activity = BOOK_TO_ACTIVITY.get(new Book(title, author, year));
        if (activity == null) {
            System.out.println("Такой книги не существует");
            return;
        }
        System.out.printf("Book activity is %s \n", activity);
    }

    public static void printAllBooks(Map<Book, String> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("Не добавлено ни одной книги");
            return;
        }
        for (var entry : books.entrySet()) {
            Book key = entry.getKey();
            System.out.printf(
                    "Book title: %s. Book author: %s. Book year: %d. Book activity: %s \n",
                    key.getTitle(),
                    key.getAuthor(),
                    key.getYear(),
                    entry.getValue()
            );
        }
    }
}
