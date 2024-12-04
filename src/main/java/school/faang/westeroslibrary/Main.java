package school.faang.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        books.put(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925),
                "4 полка во 2 ряду");
        books.put(new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                "где-то в конце");
        books.put(new Book("1984", "George Orwell", 1949),
                "у меня в столе");


        LibrarySystem library = new LibrarySystem();
        library.addBook("Pride and Prejudice", "Jane Austen", 1813, "центральная полка");
        library.printAllBooks();
        System.out.println("------------------------------------------------------");
        System.out.println(library.findBook("1984", "George Orwell", 1949));
        System.out.println("------------------------------------------------------");
        library.removeBook("1984", "George Orwell", 1949);
        library.printAllBooks();
        System.out.println("------------------------------------------------------");
        System.out.println(library.findBook("1984", "George Orwell", 1949));
    }
}
