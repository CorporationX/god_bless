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

  public void deleteBook(Book book) {
    map.remove(book);
  }

  public Optional<String> getBookShelf(Book book) {
    return map.containsKey(book) ? Optional.of(map.get(book)) : Optional.empty();
  }

  public List<Entry<Book, String>> getAllBookEntries() {
    return map.entrySet().stream().toList();
  }
}
