package school.faang.task_45368;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        final Book harryPotter = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997);
        final Book sherlockHolmes = new Book("The Complete Sherlock Holmes", "Arthur Conan Doyle", 1892);
        final Book aliceAdventures = new Book("Alice's Adventures in Wonderland", "Lewis Carroll", 1864);
        final Book orwellBook = new Book("1984", "George Orwell", 1949);
        books.put(harryPotter, "first");
        books.put(sherlockHolmes, "second");
        books.put(aliceAdventures, "third");

        LibrarySystem librarySystem = new LibrarySystem(books);

        librarySystem.printAllBooks();

        librarySystem.addBook(harryPotter.getTitle(), harryPotter.getAuthor(), harryPotter.getYear(), "first");
        librarySystem.addBook(sherlockHolmes.getTitle(), sherlockHolmes.getAuthor(), sherlockHolmes.getYear(), "first");
        librarySystem.addBook(aliceAdventures.getTitle(), aliceAdventures.getAuthor(),
                aliceAdventures.getYear(), "first");
        librarySystem.addBook(orwellBook.getTitle(), orwellBook.getAuthor(), orwellBook.getYear(), "fourth");

        librarySystem.findBook(harryPotter.getTitle(), harryPotter.getAuthor(), harryPotter.getYear());

        librarySystem.removeBook(aliceAdventures.getTitle(), aliceAdventures.getAuthor(), aliceAdventures.getYear());

        librarySystem.findBook(aliceAdventures.getTitle(), aliceAdventures.getAuthor(), aliceAdventures.getYear());

        librarySystem.printAllBooks();
    }
}
