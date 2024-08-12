package faang.school.godbless.bjs219520;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        Book book1 = new Book("title1", "author1", 1900);
        Book book2 = new Book("title2", "author2", 1950);
        Book book3 = new Book("title3", "author3", 2000);

        books.put(book1, "1");
        books.put(book2, "2");
        books.put(book3, "3");

        BookManager.addBook(books, "title4", "author4", 2010, "4");
        BookManager.deleteBook(books, "title1", "author1", 1900);
        BookManager.findBook(books, "title2", "author2", 1950);
        BookManager.findAll(books);
    }
}
