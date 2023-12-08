package LibraryOfWesterosse;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library = new HashMap<>();
    private static Map<String, Book> bookTitleMap = new HashMap<>();
    private static Map<String, Book> bookAuthorMap = new HashMap<>();
    private static Map<Integer, Book> bookYearMap = new HashMap<>();

    public static void main(String[] args) {
        Main.addBook(new Book("Make It Stick", "Henry L.", 2014), "ThirdLine");
        Main.addBook(new Book("Scientific Materialism", "Torwald Olafsen", 2021), "FourLine");
        Main.addBook(new Book("Visual Intelligence", "Amy Herman", 2016), "ThirdLine");

        System.out.println(Main.findBookByName("Make It Stick"));
        System.out.println(Main.findBookByAuthor("Henry L."));
        System.out.println(Main.findBookByYear(2014));

        Main.findAllBooks();

        Main.removeBookByName("Make It Stick");
        Main.removeBookByAuthor("Amy Herman");
        Main.removeBookByYear(2016);

        Main.findAllBooks();
    }

    public static void addBook(Book book, String bookLocation) {
        bookTitleMap.put(book.getTitle(), book);
        bookAuthorMap.put(book.getAuthor(), book);
        bookYearMap.put(book.getYear(), book);
        library.put(book, bookLocation);
    }

    public static void removeBookByName(String bookName) {
        Book bookToRemove = bookTitleMap.get(bookName);
        if (bookToRemove == null) {
            return;
        }

        library.remove(bookToRemove);
        bookTitleMap.remove(bookToRemove.getTitle());
        bookAuthorMap.remove(bookToRemove.getAuthor());
        bookYearMap.remove(bookToRemove.getYear());
    }

    public static void removeBookByAuthor(String authorName) {
        Book bookToRemove = bookAuthorMap.get(authorName);
        if (bookToRemove == null) {
            return;
        }

        library.remove(bookToRemove);
        bookTitleMap.remove(bookToRemove.getTitle());
        bookAuthorMap.remove(bookToRemove.getAuthor());
        bookYearMap.remove(bookToRemove.getYear());
    }

    public static void removeBookByYear(Integer year) {
        Book bookToRemove = bookYearMap.get(year);
        if (bookToRemove == null) {
            return;
        }

        library.remove(bookToRemove);
        bookTitleMap.remove(bookToRemove.getTitle());
        bookAuthorMap.remove(bookToRemove.getAuthor());
        bookYearMap.remove(bookToRemove.getYear());
    }

    public static String findBookByName(String bookName) {
        Book bookToFind = bookTitleMap.get(bookName);
        return library.get(bookToFind);
    }

    public static String findBookByAuthor(String author) {
        Book bookToFind = bookAuthorMap.get(author);
        return library.get(bookToFind);
    }

    public static String findBookByYear(Integer year) {
        Book bookToFind = bookYearMap.get(year);
        return library.get(bookToFind);
    }

    public static void findAllBooks() {
        library.forEach((book, location) -> {
            System.out.println(book.toString() + " " + location);
        });
    }
}
