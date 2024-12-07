package school.faang.task_45336;

import java.util.HashMap;

public class LibrarySystem {

    private final HashMap<Book, String> books;

    public LibrarySystem(HashMap<Book, String> books) {
        this.books = books;
    }

    public void addBook(String title, String author, int year, String location) {
        try {
            Book book = new Book(title, author, year);
            books.put(book, location);
            System.out.println("Книга " + title + " добавлена на полку №" + location + "!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Книга " + title + " не может быть добавлена: " + ex.getMessage());
            throw ex;
        }
    }

    public boolean removeBook(String title, String author, int year) {
        try {
            Book book = new Book(title, author, year);
            return books.remove(book) != null;
        } catch (IllegalArgumentException ex) {
            System.out.println("Книга не может быть удалена, так как такой книги не существует!");
            return false;
        }
    }

    public String findBook(String title, String author, int year) {
        try {
            Book book = new Book(title, author, year);
            return books.getOrDefault(book, "Книга не найдена!");
        } catch (IllegalArgumentException ex) {
            return "Такой книги не существует!";
        }
    }

    public void printAllBooks() {
        books.forEach(
            (book, shelfNumber) -> {
                System.out.println(book + " находится на полке №" + shelfNumber);
            });
    }
}
