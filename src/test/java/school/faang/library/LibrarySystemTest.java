package school.faang.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class LibrarySystemTest {

    private final LibrarySystem librarySystem = new LibrarySystem();
    private final String title = "Война и Мир";
    private final String author = "Толстой";
    private final int year = 1821;
    private final String location = "полка1";

    @Test
    void testAddBook() {
        Book book = new Book(title, author, year);

        String response = librarySystem.addBook(title, author, year, location);
        Assertions.assertEquals(response, book + " was successfully added");
        response = librarySystem.addBook(title, author, year, location);
        Assertions.assertEquals(response, book + " was already in library");

        Map<String, List<Book>> allBooks = librarySystem.printAllBooks();
        Assertions.assertEquals(1, allBooks.size());
        List<Book> booksOnLocation = allBooks.get(location);
        Assertions.assertIterableEquals(booksOnLocation, List.of(book));
    }

    @Test
    void testRemoveBook() {
        Book book = new Book(title, author, year);
        String response = librarySystem.removeBook(title, author, year);
        Assertions.assertEquals(response, book + " does not exist");
        Map<String, List<Book>> allBooks = librarySystem.printAllBooks();
        Assertions.assertTrue(allBooks.isEmpty());

        librarySystem.addBook(title, author, year, location);
        response = librarySystem.removeBook(title, author, year);
        Assertions.assertEquals(response, book + " was successfully removed");
        allBooks = librarySystem.printAllBooks();
        Assertions.assertTrue(allBooks.isEmpty());
    }

    @Test
    void findBookTest() {
        String response = librarySystem.findBook(title, author, year);
        Assertions.assertEquals("not found", response);

        librarySystem.addBook(title, author, year, location);
        response = librarySystem.findBook(title, author, year);
        Assertions.assertEquals(location, response);
    }

    @Test
    void testPrintAllBooksTest() {
        Book book1 = new Book("Мцыри", "Лермонтов", 1821);
        Book book2 = new Book("Мартин Иден", "Лондон", 1905);
        Book book3 = new Book("Три товарища", "Ремарк", 1954);
        Book book4 = new Book("Песнь льда и пламени", "Мартин", 2000);
        Book book5 = new Book("Толстый и тонкий", "Чехов", 1821);
        Book book6 = new Book("История времени", "Хоккинг", 1821);

        librarySystem.addBook(book1.title(), book1.author(), book1.year(), "полка1");
        librarySystem.addBook(book2.title(), book2.author(), book2.year(), "полка1");
        librarySystem.addBook(book3.title(), book3.author(), book3.year(), "полка2");
        librarySystem.addBook(book4.title(), book4.author(), book4.year(), "полка3");
        librarySystem.addBook(book5.title(), book5.author(), book5.year(), "полка4");
        librarySystem.addBook(book6.title(), book6.author(), book6.year(), "полка1");

        Map<String, List<Book>> allBooks = librarySystem.printAllBooks();
        Assertions.assertTrue(allBooks.get("полка1").containsAll(List.of(book1, book2, book6)));
        Assertions.assertTrue(allBooks.get("полка2").contains(book3));
        Assertions.assertTrue(allBooks.get("полка3").contains(book4));
        Assertions.assertTrue(allBooks.get("полка4").contains(book5));
    }

}