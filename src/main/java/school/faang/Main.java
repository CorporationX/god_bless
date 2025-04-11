package school.faang;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();
        LibrarySystem.Book book = new LibrarySystem.Book("Sophia","Pol Brosnan", 1990);
        book.addBook("Sunny night", "Pol Brosnan", 1990, "Comedy");
        book.addBook("Very cold night", "Pol Brosnan", 1990, "Comedy");
        book.addBook("Summary", "Pol Brosnan", 1990, "Comedy");
        book.addBook("Little night", "Pol Brosnan", 1990, "Comedy");
        book.addBook("Funny night", "Pol Brosnan", 1990, "Comedy");


        librarySystem.printAllBooks();


    }
}
