package school.faang.task_45256;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LibrarySystem {
    private HashMap<Book, String> booksLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        booksLocation.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        booksLocation.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (booksLocation.containsKey(book)) {
            System.out.println(String.format("Книга %s на полке %s.", book.getTitle(), booksLocation.get(book)));
        } else {
            System.out.println(String.format("Книга '%s' не найдена.", book.getTitle()));
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : booksLocation.entrySet()) {
            System.out.println(String.format("Книга '%s' на полке %s.", entry.getKey().getTitle(), entry.getValue()));
        }
    }
}
