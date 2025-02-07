package school.faang.BJS2_56994;

import school.faang.BJS2_56994.data.BookData;
import school.faang.BJS2_56994.data.JsonLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BookData> books = JsonLoader.loadBooks("books.json");

        books.forEach(book ->
                LibrarySystem.addBook(book.title, book.author, book.year, book.shelf)
        );

        LibrarySystem.printAllBooks();
        LibrarySystem.findBook("Clean Code", "Robert C. Martin", 2008);
        LibrarySystem.removeBook("Clean Code", "Robert C. Martin", 2008);
        LibrarySystem.printAllBooks();
        LibrarySystem.findBook("Clean Code", "Robert C. Martin", 2008);
    }
}
