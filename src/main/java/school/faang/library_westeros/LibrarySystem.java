package school.faang.library_westeros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.printf("Книга \"%s\" добавлена на полку %s\n", book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (library.remove(bookToRemove)!=null) {
            System.out.printf("Книга \"%s\" удалена из библиотеки.\n",bookToRemove);
        } else {
            System.out.printf("Книга \"%s\" не найдена в библиотеке.\n", bookToRemove);
        }
    }

    public void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = library.get(bookToFind);
        if (location != null) {
            System.out.printf("Книга \"%s\" находится на полке %s.\n", bookToFind, location);
        } else {
            System.out.printf("Книга \"%s\" не найдена в библиотеке.\n", bookToFind);
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Библиотека пуста.\n");
            return;
        }

        System.out.println("Список всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.printf("\"%s\" - полка: %s.\n", entry.getKey(), entry.getValue());
        }
    }
}
