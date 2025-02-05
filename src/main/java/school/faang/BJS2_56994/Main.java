package school.faang.BJS2_56994;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Map.Entry<Book, String>> books = Arrays.asList(
                Map.entry(new Book("Clean Code", "Robert C. Martin", 2008), "Shelf A1"),
                Map.entry(new Book("Effective Java", "Joshua Bloch", 2017), "Shelf B2"),
                Map.entry(new Book("The Pragmatic Programmer", "Andrew Hunt", 1999), "Shelf C3"),
                Map.entry(new Book("Refactoring", "Martin Fowler", 1999), "Shelf A1"),
                Map.entry(new Book("Head First Java", "Kathy Sierra", 2005), "Shelf D4"),
                Map.entry(new Book("Design Patterns", "Erich Gamma", 1994), "Shelf B2"),
                Map.entry(new Book("You Don't Know JS", "Kyle Simpson", 2014), "Shelf E5"),
                Map.entry(new Book("Introduction to Algorithms", "Thomas H. Cormen", 2009), "Shelf F6"),
                Map.entry(new Book("The Art of Computer Programming", "Donald Knuth", 1968), "Shelf G7")
        );

        books.forEach(entry ->
                LibrarySystem.addBook(
                        entry.getKey().getTitle(),
                        entry.getKey().getAuthor(),
                        entry.getKey().getYear(),
                        entry.getValue()
                )
        );

        LibrarySystem.printAllBooks();
        LibrarySystem.findBook("Clean Code", "Robert C. Martin", 2008);
        LibrarySystem.removeBook("Clean Code", "Robert C. Martin", 2008);
        LibrarySystem.printAllBooks();
        LibrarySystem.findBook("Clean Code", "Robert C. Martin", 2008);
    }
}
