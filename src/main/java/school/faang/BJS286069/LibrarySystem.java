package school.faang.BJS286069;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private HashMap<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return books.getOrDefault(book, "Книга не найдена");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : books.entrySet()) {
            System.out.println("Наименование:" + book.getKey().getTitle() + "; Автор: "
                + book.getKey().getAuthor() + "; Год издания: "
                + book.getKey().getYear() + "; Место: " + book.getValue()
            );
        }
    }
}
