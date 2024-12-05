package school.faang.bjs245335;

import school.faang.bjs245335.books.BooksData;
import school.faang.bjs245335.books.Locations;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        books.put(BooksData.BOOK1.createBook(), Locations.LOCATION1.name());
        books.put(BooksData.BOOK2.createBook(), Locations.LOCATION2.name());
        books.put(BooksData.BOOK3.createBook(), Locations.LOCATION3.name());

        LibrarySystem library = new LibrarySystem(books);
        library.printAllBooks();
    }
}
