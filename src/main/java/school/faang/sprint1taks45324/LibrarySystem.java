package school.faang.sprint1taks45324;

import java.util.HashMap;

public class LibrarySystem {
    HashMap<Book, String> books = new HashMap<>();

    public LibrarySystem(HashMap<Book, String> books) {
        this.books = books;
    }

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book newBook = new Book(title, author, year);
        if (!books.containsKey(newBook)) {
            throw new IllegalArgumentException("Книга не найдена");
        }
        books.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book newBook = new Book(title, author, year);

        if (!books.containsKey(newBook)) {
            throw new IllegalArgumentException("книга не найдена");
        }
        String location = books.get(newBook);
        System.out.println(location);
    }

    public void printAllBooks() {
        System.out.println(books);
    }

}
