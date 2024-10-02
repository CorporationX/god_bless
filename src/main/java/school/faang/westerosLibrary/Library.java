package school.faang.westerosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Library {

  Map<Book, String> library = new HashMap<>();

  public void addNewBook(Book book, String shelf) {
    library.put(book, shelf);
  }

  public String deleteBook(Book book) {
    return library.remove(book);
  }

  public String searchBook(Book book) {return library.get(book); }

  public String getAllBook() {
    StringBuilder allBooks = new StringBuilder();
    for (Book book : library.keySet()) {
      allBooks.append(book.toString());
      allBooks.append(" - ");
      allBooks.append(library.get(book));
      allBooks.append("\n");
    }

    return allBooks.toString();
  }
}
