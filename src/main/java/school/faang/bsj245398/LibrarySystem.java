package school.faang.bsj245398;


import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final Map<Book, String> placeByBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        placeByBook.put(new Book(title, author, year), location);
    }

    public String removeBook(String title, String author, int year) {
        Book book = getBookByInfomation(title, author, year);

        if (book != null) {
            placeByBook.remove(new Book(title, author, year));
            return "The book was deleted";
        }
        return "The book was not found";
    }

    public void findBook(String title, String author, int year) {
        Book book = getBookByInfomation(title, author, year);

        if (book != null) {
            printBookInformation(book, placeByBook.get(book));
        } else {
            System.out.println("There is no such book in the library!");
        }
    }

    private Book getBookByInfomation(String title, String author, int year) {

        Book book = new Book(title, author, year);
        if (placeByBook.containsKey(book)) {
            return book;
        }
        return null;
    }

    public void printAllBooks() {
        placeByBook.forEach(this::printBookInformation);
    }

    private void printBookInformation(Book book, String location) {
        System.out.println(book + ",  location:" + location);
    }

}
