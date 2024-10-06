package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {

        List<User> userList = List.of(
                new User("Alice", 26, "IBM Technologies", "123 Main st, Seattle, WA 988003"),
                new User("Alice Johnson", 28, "Tech Corp", "123 Elm St, Springfield"),
                new User("Bob Smith", 34, "Health Inc", "456 Oak St, Springfield"),
                new User("Charlie Brown", 30, "Finance Co", "789 Pine St, Springfield"),
                new User("Daisy Miller", 25, "Education LLC", "101 Maple St, Springfield"),
                new User("Ethan Wright", 29, "Marketing Group", "202 Birch St, Springfield"),
                new User("Fiona Davis", 31, "Consulting Firm", "303 Cedar St, Springfield"),
                new User("George Wilson", 40, "Construction Corp", "404 Walnut St, Springfield"),
                new User("Hannah Clark", 25, "Retail Shop", "505 Cherry St, Springfield"),
                new User("Ian Lewis", 35, "Real Estate LLC", "606 Spruce St, Springfield"),
                new User("Jenna Hall", 27, "Software Solutions", "707 Willow St, Springfield")
        );

        System.out.println(User.groupUsers(userList).get(40));

        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949);
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        Book book5 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book6 = new Book("War and Peace", "Leo Tolstoy", 1869);
        Book book7 = new Book("Brave New World", "Aldous Huxley", 1932);
        Book book8 = new Book("The Odyssey", "Homer", -800); // Approximate date
        Book book9 = new Book("The Brothers Karamazov", "Fyodor Dostoevsky", 1880);
        Book book10 = new Book("Fahrenheit 451", "Ray Bradbury", 1953);

        BOOKS.put(book1, "shelf_1");
        BOOKS.put(book2, "shelf_1");
        BOOKS.put(book3, "shelf_3");
        BOOKS.put(book4, "shelf_4");
        BOOKS.put(book5, "shelf_8");
        BOOKS.put(book6, "shelf_7");
        BOOKS.put(book7, "shelf_5");
        BOOKS.put(book8, "shelf_115");
        BOOKS.put(book9, "shelf_5");


        addBook(book1, "shelf 33");
        removeBook("1984", "George Orwell", 1949);
        getAllBooksInfo();
        searchForBook("The Odyssey", "Homer", -800);

    }

    private static void addBook(Book book, String shelfNumber) {
        BOOKS.put(book, shelfNumber);
        System.out.println("Book " + book.getTitle() + " is added " + shelfNumber);
    }

    private static void removeBook(String title, String author, int year) {
        Book bookForRemoval = new Book(title, author, year);
        BOOKS.remove(bookForRemoval);
    }

    private static void searchForBook(String title, String author, int year) {
        Book bookSearcher = new Book(title, author, year);
        System.out.println(BOOKS.get(bookSearcher));
    }

    private static void getAllBooksInfo() {
        for (Map.Entry<Book, String> entry : BOOKS.entrySet()) {
            System.out.println("Book info: " + entry.getKey().getTitle() + " -> Shelf number" + entry.getValue());
        }
    }
}




