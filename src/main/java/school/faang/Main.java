package school.faang.bjs2_79793;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + year + ")";
    }
}

class LibrarySystem {
    private final Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocations.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookLocations.containsKey(book)) {
            bookLocations.remove(book);
            System.out.println("Book removed: " + book);
        } else {
            System.out.println("Book not found: " + book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookLocations.get(book);
        if (location != null) {
            System.out.println("Book found: " + book + " is on shelf: " + location);
        } else {
            System.out.println("Book not found: " + book);
        }
    }

    public void printAllBooks() {
        if (bookLocations.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        System.out.println("Books in the library:");
        for (Map.Entry<Book, String> entry : bookLocations.entrySet()) {
            System.out.println(entry.getKey() + " - Shelf: " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Добавление книг (обновленные)
        library.addBook("Задача трёх тел", "Лю Цысинь", 2006, "SciFi-1");
        library.addBook("Дюна", "Фрэнк Герберт", 1965, "SciFi-2");
        library.addBook("Основание", "Айзек Азимов", 1951, "Classic-3");

        // Поиск книги
        library.findBook("Задача трёх тел", "Лю Цысинь", 2006);
        library.findBook("Дюна", "Фрэнк Герберт", 1965);
        library.findBook("Гарри Поттер", "Джоан Роулинг", 1997);

        // Удаление книги
        library.removeBook("Основание", "Айзек Азимов", 1951);

        // Вывод всех книг
        library.printAllBooks();

        // Попытка удалить несуществующую книгу
        library.removeBook("Властелин Колец", "Дж. Р. Р. Толкин", 1954);
    }
}