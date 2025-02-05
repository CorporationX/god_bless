package school.faang.sprint.first.vesterosslibrary.model;

import java.util.HashMap;

public class LibrarySystem {
    private static final HashMap<Book, String> BOOK_LOCATION_IN_LIBRARY = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        String existingLocation = BOOK_LOCATION_IN_LIBRARY.putIfAbsent(book, location);
        if (existingLocation != null) {
            System.out.println("Книга уже располагается в разделе: " + existingLocation);
        }
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String existingLocation = BOOK_LOCATION_IN_LIBRARY.remove(book);
        if (existingLocation == null) {
            System.out.println("Такой книги нет");
        }
    }

    public static void findBook(String title, String author, int year) {
        String bookLocation = BOOK_LOCATION_IN_LIBRARY.get(new Book(title, author, year));
        if (bookLocation != null) {
            System.out.println("Книга распологается в разделе: " + bookLocation);
        } else {
            System.out.println("Книга не найдена");
        }
    }

    public static void printAllBooks() {
        if (BOOK_LOCATION_IN_LIBRARY.isEmpty()) {
            System.out.println("Библиотека пуста");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (var book : BOOK_LOCATION_IN_LIBRARY.entrySet()) {
            stringBuilder
                    .append("Книга: ")
                    .append(book.getKey())
                    .append(" распологается в локации: ")
                    .append(book.getValue())
                    .append("\r\n");
        }

        System.out.println(stringBuilder);
    }
}
