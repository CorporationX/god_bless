package faang.school.godbless.Task_7;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Book, String> booksInLibrary = new HashMap<>();

        booksInLibrary.put(new Book("FirstTitle", "FirstAuthor", 666), "FirstBuilding");
        booksInLibrary.put(new Book("SecondTitle", "SecondAuthor", 777), "SecondBuilding");
        booksInLibrary.put(new Book("ThirdTitle", "ThirdAuthor", 888), "ThirdBuilding");

        System.out.println(booksInLibrary);
        addNewBook(booksInLibrary, new Book("FourthTitle", "FourthAuthor", 999), "FourthBuilding");

        removeBookFromLibrary(booksInLibrary, "FirstTitle", "FirstAuthor", 666);

        System.out.println(searchBookInLibrary(booksInLibrary, "SecondTitle", "SecondAuthor", 777));


    }

    static void addNewBook(Map<Book, String> booksInLibrary, Book book, String placeOfBook) {
        booksInLibrary.put(book, placeOfBook);
        System.out.println(booksInLibrary);
    }

    static void removeBookFromLibrary(Map<Book, String> booksInLibrary, String title, String author, int year) {
        booksInLibrary.remove(new Book(title, author, year));
        System.out.println(booksInLibrary);
    }
    static String searchBookInLibrary(Map<Book, String> booksInLibrary, String title, String author, int year) {
        return booksInLibrary.get(new Book(title, author, year));
    }

}
