package school.faang.bjs2_79666;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
        System.out.println("Книга добавлена: " + book + " на местонахождение: " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.remove(book) != null) {
            System.out.println("Книга удалена: " + book);
        } else {
            System.out.println("Книга не найдена: " + book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = books.get(book);
        if (location != null) {
            System.out.println("Книга найдена: " + book + " на полке: " + location);
        } else {
            System.out.println("Книга не найдена: " + book);
        }
    }

    public void printAllBooks() {
        for (Book book : books.keySet()) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("Cosmonaut", "Gagarin", 1999, "Shelf 1");
        library.addBook("Navigator", "Adams", 1888, "Shelf 2");
        library.addBook("Tester", "William", 1777, "Shelf 3");

        library.printAllBooks();
        library.findBook("Navigator", "Adams", 1888);
        library.removeBook("Navigator", "Adams", 1888);
        library.findBook("Navigator", "Adams", 1888);
        library.printAllBooks();
    }
}