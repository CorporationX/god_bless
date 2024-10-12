package school.faang.bjs2_33146;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class BookShelfUtils {
    private Map<Book, String> bookShelfMap;


    public void addBookAndShelf(Book book, String shelf) {
        bookShelfMap.put(book, shelf);
    }

    public void removeBook(String title, String author, int year) {
        Book keyForRemoveBook = new Book(title, author, year);
        bookShelfMap.remove(keyForRemoveBook);
    }

    public void printBookLocation(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String shelfBookToFind = bookShelfMap.get(bookToFind);
        System.out.println(bookToFind + " = " + shelfBookToFind);
    }

    public void printAllBooksAndLocation() {
        for (Map.Entry<Book, String> bookStringEntry : bookShelfMap.entrySet()) {
            Book book = bookStringEntry.getKey();
            String shelf = bookStringEntry.getValue();
            System.out.println(book + " = " + shelf);
        }
    }
}
