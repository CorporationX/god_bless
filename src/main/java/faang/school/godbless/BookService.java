package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookService {

    public static void addBook(Book book, String genre, HashMap<Book, String> bookShelfMap) {
        if (book != null) {
            bookShelfMap.putIfAbsent(book, genre);
        } else {
            throw new IllegalArgumentException("Book can't be null");
        }
    }

    public static void deleteBook(Book bookForDelete, HashMap<Book, String> bookShelfMap) {

        if (bookShelfMap.containsKey(bookForDelete)) {
            bookShelfMap.remove(bookForDelete);
            System.out.println("Book " + bookForDelete.getTitle() + " was deleted");
        } else {
            System.out.println("Bookshelf doesn't contain book " + bookForDelete);
        }
    }

    public static Book findBookAndPrintGenreByInfoBook(Book bookForSearching, HashMap<Book, String> bookShelfMap) {

        Optional<Book> book = bookShelfMap.keySet().stream()
                .filter(e -> e.equals(bookForSearching))
                .findFirst();

        book.ifPresentOrElse(b -> System.out.println("Book is in " + bookShelfMap.get(b) + " genre"),
                () -> System.out.println("Book not found"));

        return book.orElse(null);
    }

    public static void printBooksWithGenre(HashMap<Book, String> bookShelfMap) {
        for (Map.Entry<Book, String> book : bookShelfMap.entrySet()) {
            System.out.println(book.getKey() + " is in " + book.getValue() + " genre");
        }
    }
}
