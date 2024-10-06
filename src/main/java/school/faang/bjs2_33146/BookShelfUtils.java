package school.faang.bjs2_33146;

import java.util.Map;

public class BookShelfUtils {
    public static void addBookAndShelf(Book book, String shelf, Map<Book, String> bookShelfMap) {
        bookShelfMap.put(book, shelf);
    }

    public static void removeBook(String title, String author, int year, Map<Book, String> bookShelfMap) {
        Book keyForRemoveBook = new Book(title, author, year);
        bookShelfMap.remove(keyForRemoveBook);
    }

    public static void printBookLocation(String title, String author, int year, Map<Book, String> bookShelfMap) {
        Book bookToFind = new Book(title, author, year);
        String shelfBookToFind = bookShelfMap.get(bookToFind);
        System.out.println(bookToFind + " = " + shelfBookToFind);
    }

    public static void printAllBooksAndLocation(Map<Book, String> bookShelfMap) {
        for (Map.Entry<Book, String> bookStringEntry : bookShelfMap.entrySet()) {
            Book book = bookStringEntry.getKey();
            String shelf = bookStringEntry.getValue();
            System.out.println(book + " = " + shelf);
        }
    }
}
