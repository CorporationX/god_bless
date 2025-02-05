package school.faang;

import school.faang.bjs2_56986.Book;
import school.faang.bjs2_56986.LibrarySystem;

import java.util.HashMap;
import java.util.Map;

public class LibraryMain {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Map<Book, String> library = new HashMap<>();

        Book book1 = new Book("Book1", "Author1", 1897);
        Book book2 = new Book("Book2", "Author2", 1890);
        Book book3 = new Book("Book3", "Author3", 1997);

        librarySystem.addBook(book1, "Box1", library);
        librarySystem.addBook(book2, "Box2", library);
        librarySystem.addBook(book3, "Box3", library);
        librarySystem.printAllBooks(library);
        separator();

        librarySystem.removeBook(book2, library);
        librarySystem.findBook(book2, library);
        separator();

        librarySystem.findBook(book1, library);
        separator();
        librarySystem.printAllBooks(library);
    }

    static void separator() {
        System.out.println("=====================================");
    }
}
