package school.faang.bjs2_86123;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.remove(book) != null) {
            System.out.printf("Книга %s удалена%n%n", book);
        } else {
            System.out.printf("Книга %s не найдена. Книга не удалена%n%n", book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = books.get(book);
        if (location != null) {
            System.out.printf("Книга %s найдена. Её местонахождение: %s%n%n", book, location);
        } else {
            System.out.printf("Книга %s не найдена%n%n", book);
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.printf("%s%nМестоположение: %s%n%n", entry.getKey(), entry.getValue());
        }
    }
}
