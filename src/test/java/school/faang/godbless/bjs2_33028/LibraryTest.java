package school.faang.godbless.bjs2_33028;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LibraryTest {

  private Library library;

  @BeforeEach
  public void init() {
    this.library = new Library();
  }

  @Test
  @DisplayName("Test adding existing equal book")
  void testAddExistingEqualBooks() {
    Book oldBook = new Book("book", "author", 2011);
    Book newBook = new Book("book", "author", 2011);
    library.addBook(oldBook, "old shelf");
    library.addBook(newBook, "new shelf");

    List<Entry<Book, String>> entriesFromLibraryMap = library.getAllBookEntries();
    assertEquals(1, entriesFromLibraryMap.size());
    var entry = entriesFromLibraryMap.get(0);
    assertEquals(oldBook, entry.getKey());
    assertEquals(newBook, entry.getKey());
    assertEquals("new shelf", entry.getValue());
  }

  @Test
  @DisplayName("Test deleting existing book")
  void testDeleteExistingBook() {
    Book oldBook = new Book("old book", "author", 2011);
    Book newBook = new Book("new book", "author", 2011);
    library.addBook(oldBook, "old shelf");
    library.addBook(newBook, "new shelf");

    library.deleteBook(newBook);

    List<Entry<Book, String>> entriesFromLibraryMap = library.getAllBookEntries();
    assertEquals(1, entriesFromLibraryMap.size());
    var entry = entriesFromLibraryMap.get(0);
    assertEquals(oldBook, entry.getKey());
    assertEquals("old shelf", entry.getValue());
  }

  @Test
  @DisplayName("Test getting shelf for existing and not existing book")
  void testGetBookShelf() {
    Book book = new Book("book", "author", 2011);
    library.addBook(book, "shelf");

    assertTrue(library.getBookShelf(new Book("s", "s", 1)).isEmpty());
    assertTrue(library.getBookShelf(book).isPresent());
    assertEquals("shelf", library.getBookShelf(book).get());
  }
}