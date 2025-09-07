package school.faang.bjs2_86096;

import lombok.ToString;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

@ToString
public class LibrarySystem {
    private Map<Book, String> library;

    public LibrarySystem() {
        this.library = new HashMap<>();
    }

    public boolean addBook(String title, String author, int year, String location) {
        validationBook(title, author, year);
        Book book = new Book(title, author, year);
        String oldPlace = library.putIfAbsent(book, location);

        if (oldPlace != null) {
            System.out.println("Книга уже была на месте " + oldPlace + " Перекладываем книгу на " + location);
            return false;
        }
        System.out.println("Книга добавлена на " + location);
        return true;
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String remove = library.remove(book);
        if (remove != null) {
            System.out.println("Книга найдена и удалена: " + title + " " + author + " " + year);
            return false;
        }
        System.out.println("Такой книги нету, предоставьте полную информацию о книге: название, автор и год");
        return true;
    }

    public boolean findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String find = library.get(book);
        if (find != null) {
            System.out.println("Книга находится на " + find);
            return true;
        }
        System.out.println("Такой книги нету");
        return false;
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " находится на полке: " + entry.getValue());
        }
    }

    private void validationBook(String title, String author, int year) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не может быть пустым");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        if (year <= 0 || year > Year.now().getValue()) {
            throw new IllegalArgumentException("Год не может быть меньше 0 и больше 2025 года");
        }
    }
}
