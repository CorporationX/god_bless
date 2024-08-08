package faang.school.godbless.vesterosLibrary;

import java.util.Map;

public class BookService {

    public void addBook(Map<Book, String> library, Book book, String shelf) {
        library.put(book, shelf);
    }

    public void removeBook(Map<Book, String> library, String title, String author, int year) {
        var shelf = library.remove(new Book(title, author, year));
        if (shelf == null) {
            System.out.println("Book not found\n");
        }
    }

    public void bookLocation(Map<Book, String> library, String title, String author, int year) {
        var shelf = library.get(new Book(title, author, year));
        if (shelf != null) {
            System.out.println("Shelf: " + shelf);
        } else {
            System.out.println("Book not found\n");
        }
    }

    public void showLibrary(Map<Book, String> library) {
        library.forEach((book, shelf) ->
                System.out.println("Shelf: " + shelf +
                        ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() +
                        ", written in: " + book.getYear()));
    }
}
