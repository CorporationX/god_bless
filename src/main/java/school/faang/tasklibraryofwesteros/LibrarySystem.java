package school.faang.tasklibraryofwesteros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> locationBookMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        locationBookMap.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (locationBookMap.remove(bookToRemove) != null) {
            System.out.println("Книга удалена" + bookToRemove);
        } else {
            System.out.println("Книга не найдена " + bookToRemove);
        }
    }

    public void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = locationBookMap.get(bookToFind);
        if (location != null) {
            System.out.println("Книга найдена " + bookToFind + " местонахождение " + location);
        }
    }

    public void printAllBooks() {
        if (locationBookMap.isEmpty()) {
            System.out.println("Библиотека пуста");
        } else {
            System.out.println("Список всех книг в библиотеке:");
            for (Map.Entry<Book, String> entry : locationBookMap.entrySet()) {
                System.out.println(entry.getKey() + " местонахождение: " + entry.getValue());
            }
        }
    }
}
