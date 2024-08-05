package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static void addBook(Book book, String place) {
        library.put(book, place);
    }

    public static void deleteBook(Book book) {
        if (library.containsKey(book)) {
            library.remove(book);
        } else {
            System.out.println("Book not found");
        }
    }

    public static void deleteBook(String title, String author, int year) {
        Book expectedBookToDelete = new Book(title, author, year);
        if (library.containsKey(expectedBookToDelete)) {
            library.remove(expectedBookToDelete);
        }
        else {
            System.out.println("Book not found");
        }
    }

    public static void printAllBooks(){
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey().getTitle() + ", " + entry.getKey().getAuthor()
                    + ", " + entry.getKey().getYear() + " (" + entry.getValue() + ")");
        }
    }

    public static String findBookPlace(Book book) {
        if (library.containsKey(book)) {
            return library.get(book);
        }
        return "There is no book with title " + book.getTitle() + " and author "
                + book.getAuthor() + " published in year " + book.getYear() + " in the library";
    }

    public static String findBookPlace(String title, String author, int year) {
        Set<Book> books = library.keySet();
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getYear() == year) {
                return library.get(book);
            }
        }
        return "There is no book with title " + title + " and author "
                + author + " published in year " + year + " in the library";
    }

    public static void main(String[] args) {
        Book book1 = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 2012);
        Book book2 = new Book("The Pragmatic Programmer: Your Journey to Mastery", "Andrew Hunt, David Thomas", 2000);
        Book book3 = new Book("Soft Skills: The Software Developer's Life Manual", "John Sonmez", 2014);
        Book book4 = new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 1994);
        Book book5 = new Book("Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones", "James Clear", 2018);
        Book book6 = new Book("Emotional Intelligence 2.0", "Travis Bradberry, Jean Greaves", 2009);
        Book book7 = new Book("How to Win Friends and Influence People", "Dale Carnegie", 1936);

        addBook(book1, "1");
        addBook(book2, "2");
        addBook(book3, "3");
        addBook(book4, "4");
        addBook(book5, "5");
        addBook(book6, "6");
        addBook(book7, "7");

        deleteBook(book3);
        deleteBook("Emotional Intelligence 2.0", "Travis Bradberry, Jean Greaves", 2009);

        //books in place 3 and 6 are deleted
        printAllBooks();

        System.out.println(findBookPlace(book1));
        System.out.println(findBookPlace("How to Win Friends and Influence People", "Dale Carnegie", 1936));

        //trying to find place of not existing book
        System.out.println(findBookPlace("some book", "some author", 2024));

        //trying to delete not existing book from the library
        deleteBook("some book", "some author", 2024);
    }
}
