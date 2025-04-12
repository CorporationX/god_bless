package school.faang.westeroslibrary;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LibrarySystem {
    private final HashMap<Book, String> map = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        if (!map.containsKey(newBook)) {
            map.put(newBook, location);
            System.out.printf("Книга '%s' добавлена на полку %s\n", title, location);
        } else {
            System.out.printf("Ошибка: книга '%s' уже существует в системе\n", title);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (map.remove(book) != null) {
            System.out.printf("Книга '%s' удалена из системы\n", title);
        } else {
            System.out.printf("Ошибка: книга '%s' не найдена\n", title);
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return map.getOrDefault(book, "Книга не найдена");
    }

    public void printAllBooks() {
        if (map.isEmpty()) {
            System.out.println("Библиотека пуста");
            return;
        }

        System.out.println("\nСписок всех книг:");
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book book = entry.getKey();
            System.out.printf("▸ %s | Автор: %s | Год: %d | Полка: %s\n",
                    book.getTitle(), book.getAuthor(), book.getYear(), entry.getValue());
        }
    }
}