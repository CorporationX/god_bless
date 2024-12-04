package school.faang.task_45272;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private HashMap<Book, String> hashMapBook;

    public LibrarySystem(HashMap<Book, String> hmBook) {
        this.hashMapBook = hmBook;
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = createBook(title, author, year);
        if (hashMapBook.containsValue(location)) {
            // Вызываем ошибку
        }
        hashMapBook.put(book, location);

    }

    public void removeBook(String title, String author, int year) {
        Book book = createBook(title, author, year);
        hashMapBook.remove(book);
    }

    public void findBook(String title, String author, int year) {
        Book book = createBook(title, author, year);
        if (!hashMapBook.containsKey(book)) {
            System.out.println("Данной книги нет в бибилотеке");
        }
        System.out.println(hashMapBook.get(book));
    }

    public void printAllBooks() {

    }

    private Book createBook(String title, String author, int year) {
        Book newBook = new Book(title, author, year);
        return newBook;
    }
}
