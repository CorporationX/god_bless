package school.faang.sprint1.task_bjs245346;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class LibrarySystem {
    Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
        System.out.println("Добавлена книга: " + book + " на место: " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println("Список книг до удаления: ");
        printAllBooks();

        books.remove(book);
        System.out.println("Список книг после удаления: ");
        printAllBooks();
    }

    public boolean findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return books.get(book) != null;
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " находится на месте: " + entry.getValue());
        }
    }

}
