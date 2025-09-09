package school.faang.bjs2_86189;

import java.time.Year;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LibrarySystem {

    private Map<Book, String> books = new HashMap<>();
    private Set<String> shelf = new HashSet<>();


    public void addBook(String title, String author, int year, String location) {
        validateBook(title, author, year);
        validationLocation(location);
        Book book = new Book(title, author, year);
        if (shelf.contains(location)) {
            System.out.printf("Извиниете, %s - это полка занята другой книгой\n", location);
            return;
        }
        if (!books.containsKey(book)) {
            books.put(book, location);
            shelf.add(location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        boolean isRemoved = books.remove(book) != null;
        if (isRemoved) {
            System.out.println("Ваша книга удалена");
        } else {
            System.out.println("Ваша книга не найдена");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println(books.getOrDefault(book, "Ваша книга не найдена"));

    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().toString() + entry.getValue());
        }
    }

    private void validateBook(String title, String author, int year) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не может быть пустым");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Поле автор не может быть пустым");
        }
        if (year <= 0 || year > Year.now().getValue()) {
            throw new IllegalArgumentException("Год не может быть меньше нуля и больше текущего");
        }
    }

    private void validationLocation(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Полка книги не может быть пустым");
        }
    }

}
