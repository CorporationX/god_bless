package school.faang.bjs2_86053;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> bookStringMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);

        // валидация
        if (title == null || author == null || location == null) {
            throw new IllegalArgumentException("Поля не могут быть null");
        }
        if (year < 0 || year > Year.now().getValue() + 1) {
            throw new IllegalArgumentException("Некорректный год");
        }

        // основная логика
        if (bookStringMap.containsKey(newBook)) {
            System.out.println("Книга '" + title + "' уже существует в библиотеке!");
            return;
        }

        bookStringMap.put(newBook, location);
        System.out.println("Книга '" + title + "' успешно добавлена.");
    }

    public void removeBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        String removedLocation = bookStringMap.remove(key);

        boolean removed = (removedLocation != null);
        if (removed) {
            System.out.println("Книга '" + title + "' успешно удалена из библиотеке.");
        } else {
            System.out.println("Книга '" + title + "' не найдена в библиотеке.");
        }
    }

    public void findBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        String location = bookStringMap.get(key);

        if (location != null) {
            System.out.println("Книга найдена: '" + title +
                    "' автора " + author +
                    " (" + year + " год)" +
                    " находится в: " + location);
        } else {
            System.out.println("Книга '" + title + "' автора " + author +
                    " (" + year + " год) не найдена в библиотеке.");
        }
    }

    public void printAllBooks() {
        if (bookStringMap.isEmpty()) {
            System.out.println("Библиотека пуста");
        } else {
            int num = 1;
            for (Book key : bookStringMap.keySet()) {
                String location = bookStringMap.get(key);
                System.out.println(num + ". '" + key.getTitle() + "' - " + key.getAuthor() +
                        " (" + key.getYear() + " год) [Место: " + location + "]");
                num++;
            }
        }
    }
}
