package school.faang.vesterosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Book, Integer> library= new HashMap<>();

    public void addNewBook(String title, String author, String year, int bookshelfNumber) {
        library.put(new Book(title, author, year), bookshelfNumber);
    }

    public void deleteBook(String title, String author, String year) {
        library.remove(new Book(title, author, year));
    }

    public void findBookPlace(String title, String author, String year) {
        int bookshelfNumber = library.get(new Book(title, author, year));
        System.out.println("The book is on the shelf number " + bookshelfNumber);
    }

    public void showLibrary() {
        for(Map.Entry<Book, Integer> book: library.entrySet()) {
            System.out.println(book.getKey() + ", shelf " + book.getValue());
        }
    }
}
