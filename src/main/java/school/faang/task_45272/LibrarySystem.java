package school.faang.task_45272;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private HashMap<Book, String> hashMapBook;

    public LibrarySystem(HashMap<Book, String> hmBook) {
        this.hashMapBook = hmBook;
    }

    public void addBook(String title, String author, int year, String location) {
        hashMapBook.put(createBook(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = createBook(title, author, year);
        if (hashMapBook.containsKey(book)) {
            hashMapBook.remove(book);
        } else {
            System.out.println("Книги " + book.getTitle() + " нет в библиотеки");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = createBook(title, author, year);
        if (!hashMapBook.containsKey(book)) {
            System.out.println("Данной книги нет в бибилотеке");
        } else {
            System.out.println("Запрашиваеммая книга в разделе: " + hashMapBook.get(book));
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : hashMapBook.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Раздел: " + entry.getValue());
        }
    }

    private Book createBook(String title, String author, int year) {
        Book newBook = new Book(title, author, year);
        return newBook;
    }
}
