package faang.school.godbless.VesterousLibraryService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {
        Main library = new Main();

        Book book1 = new Book("Bible", "God", 500);
        Book book2 = new Book("Misery", "Stephen King", 1987);
        Book book3 = new Book("The Intelligent Investor", "Benjamin Graham", 1949);

        library.add(book1, "Shelf Nº12455");
        library.add(book2, "Shelf Nº34");
        library.add(book3, "Shelf Nº890");

        System.out.println(library.get(book1));

        library.delete(book2);

        Map<Book, String> allBooks = library.getAll();
        allBooks.forEach((book, bookLocation) -> System.out.println(book + " : " + bookLocation));
    }

    public void add(Book book, String bookLocation) {
        BOOKS.put(book, bookLocation);
    }

    public void delete(Book book) {
        BOOKS.remove(book);
    }

    public String get(Book book) {
        return BOOKS.get(book);
    }

    public Map<Book, String> getAll() {
        return new HashMap<>(BOOKS);
    }
}

//
