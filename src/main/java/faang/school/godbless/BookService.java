package faang.school.godbless;

import java.util.Map;

import static faang.school.godbless.Main.bookShelfMap;

public class BookService {

    public static void addBook(Book book, String genre) {
        bookShelfMap.put(book, genre);
    }

    public static void deleteBook(String title, String author, int year) {
        Book bookForDelete = new Book(title, author, year);

        if (bookShelfMap.containsKey(bookForDelete)) {
            bookShelfMap.remove(bookForDelete);
            System.out.println("Book " + bookForDelete.getTitle() + " was deleted");
        } else {
            System.out.println("Bookshelf doesn't contain book " + bookForDelete);
        }
    }

    public static Book findBookAndPrintGenreByInfoBook(String title, String author, int year) {
        Book bookForSearching = new Book(title, author, year);

        if (bookShelfMap.containsKey(bookForSearching)) {
            System.out.println("Book is in " + bookShelfMap.get(bookForSearching) + " genre");
        } else {
            System.out.println("Book not found");
        }

        return bookShelfMap.keySet().stream()
                .filter(e -> e.equals(bookForSearching))
                .findFirst()
                .orElse(null);
    }

    public static void printBooksWithGenre() {
        for (Map.Entry<Book, String> book : bookShelfMap.entrySet()) {
            System.out.println(book.getKey() + " is in " + book.getValue() + " genre");
        }
    }
}
