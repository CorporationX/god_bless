package school.faang.sprintone.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final HashMap<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        if (!library.containsKey(newBook)) {
            library.put(newBook, location);
            System.out.printf("Книга '%s' добавлена на полку %s\n", title, location);
        } else {
            System.out.printf("Ошибка: книга '%s' уже существует в системе\n", title);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.remove(book) != null) {
            System.out.printf("Книга '%s' удалена из системы\n", title);
        } else {
            System.out.printf("Ошибка: книга '%s' не найдена\n", title);
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.getOrDefault(book, null);
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Библиотека пуста");
            return;
        }

        System.out.println("\nСписок всех книг:");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            Book book = entry.getKey();
            System.out.printf("▸ %s | Автор: %s | Год: %d | Полка: %s\n",
                    book.getTitle(), book.getAuthor(), book.getYear(), entry.getValue());
        }
    }
}