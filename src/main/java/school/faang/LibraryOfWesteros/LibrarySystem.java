package school.faang.LibraryOfWesteros;


import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public String removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return books.remove(book);

    }

    public boolean findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (books.containsKey(book)) {
            System.out.printf("Книжка %s находится на %s\n", book, books.get(book));
            return true;
        } else {
            System.out.println("Книги нет в библиотеке");
            return false;
        }

    }

    public void printAllBooks() {
        System.out.printf("%s\n", books);
    }

    @SuppressWarnings("checkstyle:LineLength")
    private void validateBookDetails(String title, String author, int year, String location) {
        if (title == null || title.isEmpty() || author == null || author.isEmpty() || year <= 0 || location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Invalid book details");
        }
    }
}

