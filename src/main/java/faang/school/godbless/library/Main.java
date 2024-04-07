package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("The Hunger Games", "Suzanne Collins", 2008);
        Book book2 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book4 = new Book("The Book Thief", "Markus Zusak", 2005);

        addBook(book1, "T");
        addBook(book2, "P");
        addBook(book3, "T");
        addBook(book4, "T");
        removeBook("The Hunger Games", "Suzanne Collins", 2008);
        findBook("The Book Thief", "Markus Zusak", 2005);
        getAllBooks();
    }

    public static void addBook(Book book, String location) {
        library.put(book, location);
    }

    public static void removeBook(String bookTile, String bookAuthor, int publicationYear) {
        library.remove(new Book(bookTile, bookAuthor, publicationYear));
    }

    public static void findBook(String bookTile, String bookAuthor, int publicationYear) {
        Book bookToFind = new Book(bookTile, bookAuthor, publicationYear);
        if (library.get(bookToFind) != null) {
            System.out.println(bookToFind + " is located in area " + library.get(new Book(bookTile, bookAuthor, publicationYear)));
        }
    }

    public static void getAllBooks() {
        for (Map.Entry<Book, String> book : library.entrySet()) {
            System.out.println(book.getKey() + " is located in area " + book.getValue());
        }
    }

}
