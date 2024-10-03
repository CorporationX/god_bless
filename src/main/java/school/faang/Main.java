package school.faang;

import java.util.HashMap;
import java.util.Map;


public class Main {
    private Map<Book, String> booksMap;

    public Main() {
        booksMap = new HashMap<>();
    }

    public void printAllBooks() {
        if (booksMap.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            booksMap.forEach((book, place) -> System.out.println(book + " Place: " + place));
        }
    }

    public String addBook(Book book, String location) {
        return booksMap.put(book, location);
    }

    public String removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        return booksMap.remove(bookToRemove);
    }

    public String findBook(String title, String author, Integer year) {
        Book newBook = new Book(title, author, year);
        return booksMap.get(newBook);
    }

    public static void main(String[] args) {

        Main library = new Main();
        library.booksMap.put(new Book("World", "Drizer K.", 1999), "A1");
        library.booksMap.put(new Book("Wolf", "Tolstoy K.", 1871), "B2");
        library.booksMap.put(new Book("Anna K.", "Mirabel K.", 2016), "A2");

        System.out.println(library.findBook("World", "Drizer K.", 1999));

        String location = library.removeBook("Anna K.2", "Mirabel K.", 2016);
        if (location == null) {
            System.out.println("Book was not find");
        } else {
            System.out.println("Book deleted from location: " + location);
        }
        library.printAllBooks();
    }

}
