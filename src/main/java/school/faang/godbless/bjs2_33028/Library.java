package school.faang.godbless.bjs2_33028;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;


public class Library {

  private final Map<Book, String> map = new HashMap<>();

  public void addBook(Book book, String shelf) {
    map.put(book, shelf);
  }

  public void deleteBook(String author, String title, int year) {
    Book book = new Book(title, author, year);
    map.remove(book);
  }

  public Optional<String> getBookShelf(String author, String title, int year) {
    Book book = new Book(title, author, year);
    return map.containsKey(book) ? Optional.of(map.get(book)) : Optional.empty();
  }

  public List<Entry<Book, String>> getAllBookEntries() {
    return map.entrySet().stream().toList();
  }
}
