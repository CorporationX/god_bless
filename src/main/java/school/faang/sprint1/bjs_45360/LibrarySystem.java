package school.faang.sprint1.bjs_45360;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> books;

    public LibrarySystem(Map<Book, String> books) {
        this.books = books;
    }

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        String removedBookStatus = books.remove(new Book(title, author, year));

        if (removedBookStatus == null) {
            System.out.println("Такой книги нет в библиотеке");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            String location = books.get(book);
            System.out.println("Книга \"" + book.getTitle() + "\" находится в ряду " + location + "\n");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println("Название книги: " + entry.getKey().getTitle());
            System.out.println("Автор книги: " + entry.getKey().getAuthor());
            System.out.println("Год издания книги: " + entry.getKey().getYear());
            System.out.println("Ряд книги в библиотеке: " + entry.getValue());
            System.out.println("-----------");
        }
    }
}
