package school.faang;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> bookMap = new HashMap<>();
        bookMap.put(new Book("Rowling", 1997, "harryPotter"), "5");
        bookMap.put(new Book("Pushkin", 1833, "theQueenOfSpades"), "1");
        bookMap.put(new Book("Dahl", 1964, "theChocolateFactory"), "3");

        addNewBook(bookMap, "5");

        deleteBook(bookMap, "Pushkin", 1833, "theQueenOfSpades");

        searchBook(bookMap, "Dahl", 1964, "theChocolateFactory");

        getAllBooks(bookMap);

    }

    public static void addNewBook(Map<Book, String> bookMap, String bookshelf) {
        bookMap.put(new Book("Gosling", 2049, "gostRunner"), "5");
    }

    public static void deleteBook(Map<Book, String> bookMap, String author,
                                  int year, String title) {
        Book bookToDelete = new Book(author, year, title);
        bookMap.remove(bookToDelete);
    }

    public static void searchBook(Map<Book, String> bookMap, String author,
                                  int year, String title) {
        Book bookToSearch = new Book(author, year, title);
        System.out.println(bookMap.get(bookMap.containsKey(bookToSearch)));
    }

    public static void getAllBooks(Map<Book, String> bookMap) {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            System.out.println("Книга: "+ entry.getKey().getTitle() + " Положение на полке " + entry.getValue());
        }
    }

}
