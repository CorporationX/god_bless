package faang.school.godbless.Library;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void addNewBook(Map<Book, String> books, Book book, String placeLibrary) {
        books.put(book, placeLibrary);
    }

    public static void deleteBook(Map<Book, String> books, String title, String author, int year) {
        Book book = new Book(title, author, year);
        int size = books.size();
        books.remove(book);
        if (size == books.size()) {
            System.out.println("Book not found");
        }
    }

    public static void outputListHouses(Map<Book, String> books) {
        if (books.isEmpty()) {
            System.out.println("There are no entries");
        } else books.forEach((key, value) -> System.out.println(key.toString() + ": " + value));
    }

    public static void searchByName(Map<Book, String> books, String title, String author, int year) {
        Book book = new Book(title, author, year);

        String place = books.get(book);

        if (place != null) {
            System.out.println("title " + book.getTitle() + ", place: " + place);
        } else System.out.println("There is no such house");
    }

    public static void main(String[] args) {

        Map<Book, String> books = new HashMap<>();

        books.put(new Book("A", "John", 1999), "2 shelf");
        books.put(new Book("B", "Alen", 1891), "4 shelf");
        books.put(new Book("C", "John", 1793), "6 shelf");
        books.put(new Book("D", "Vlad", 1959), "1 shelf");

        Book newBook = new Book("G", "Nikita", 1876);

        addNewBook(books, newBook, "12 shelf");

        deleteBook(books, "A", "John", 1989);

        searchByName(books, "D", "Vlad", 1959);

        outputListHouses(books);
    }
}
