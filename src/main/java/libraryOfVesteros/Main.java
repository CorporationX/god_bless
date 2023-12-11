package libraryOfVesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> addressBook = new HashMap<>(
                Map.of(
                        new Book("Book1", "Tom Rick", 2000), "line10",
                        new Book("Book2", "John", 2022), "Line20",
                        new Book("Book3", "Peter", 1999), "Line20"
                ));

        addBook(addressBook, "Book New", "New", 1500, "Line100");
        System.out.println(addressBook.toString());
        removeBook(addressBook, "Book New", "New", 1500);
        System.out.println(addressBook.toString());
        searchBook(addressBook, "Book1", "Tom Rick", 2000);
        getListBook(addressBook);
    }

    public static void addBook(Map<Book, String> listBook, String title, String author, int year, String line) {
        listBook.put(new Book(title, author, year), line);
    }

    public static void removeBook(Map<Book, String> listBook, String title, String author, int year) {
        listBook.remove(new Book("Book New", "New", 1500));
    }

    public static void searchBook(Map<Book, String> listBook, String title, String author, int year) {
        System.out.println("The book '" + title + "' is located: " + listBook.get(new Book(title, author, year)));
    }

    public static void getListBook(Map<Book, String> listBook) {
        System.out.println("Full list of books:");
        for (Map.Entry<Book, String> book : listBook.entrySet()) {
            System.out.println(book);
        }
    }
}