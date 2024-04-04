package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        Main library = new Main();

        Book book1 = new Book("Bible", "God", 500);
        Book book2 = new Book("Misery", "Stephen King", 1987);
        Book book3 = new Book("The Intelligent Investor", "Benjamin Graham", 1949);

        library.add(book1, "Shelf Nº12455");
        library.add(book2, "Shelf Nº34");
        library.add(book3, "Shelf Nº890");

        library.get(book1);

        library.delete(book2);

        library.getAll();

    }

    public void add(Book book, String bookLocation) {
        books.put(book, bookLocation);
    }

    public void delete(Book book) {
        books.remove(book);
    }

    public void get(Book book) {
        System.out.println(books.get(book));
    }

    public void getAll() {
        books.forEach((s, bookLocation) -> System.out.println(s + " : " + bookLocation));
    }
}
