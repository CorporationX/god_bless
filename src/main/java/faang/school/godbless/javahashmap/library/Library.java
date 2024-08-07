package faang.school.godbless.javahashmap.library;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private final HashMap<Book, String> store = new HashMap<>();

    public void addBook(Book book, String location) {
        store.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        store.remove(bookToRemove);
    }

    public void findAndPrintBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = store.get(bookToFind);
        printBookInfo(bookToFind, location);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : store.entrySet()) {
            printBookInfo(entry.getKey(), entry.getValue());
        }
    }

    public HashMap<Book, String> getStore() {
        HashMap<Book, String> storeToReturn = new HashMap<>();
        store.forEach((book, location) -> storeToReturn.put(
                new Book(book.getTitle(), book.getAuthor(), book.getYear()), location));
        return storeToReturn;
    }

    private void printBookInfo(Book book, String location) {
        System.out.println("Book: " + book + ", Location: " + location);
    }
}
