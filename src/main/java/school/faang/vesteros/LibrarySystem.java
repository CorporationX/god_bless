package school.faang.vesteros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        library.remove(book);
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Данная книга находится: " + library.get(book));
        } else {
            System.out.println("Данной книги нет в библиотеке");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : library.entrySet()) {
            System.out.println("=".repeat(30));
            System.out.println("Книга: " + book.getKey().getTitle() +
                    "\nАвтор: " + book.getKey().getAuthor() +
                    "\nГод издания: " + book.getKey().getYear() +
                    "\nНаходится на полке: " + book.getValue());
        }
        System.out.println("=".repeat(30));
    }
}
