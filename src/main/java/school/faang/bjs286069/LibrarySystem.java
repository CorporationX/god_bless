package school.faang.bjs286069;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            books.remove(book);
            System.out.println("Книга  успешно удалена");
            return;
        }
        System.out.println("Книга не найдена!");
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
