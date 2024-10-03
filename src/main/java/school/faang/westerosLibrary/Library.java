package school.faang.westerosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Library {

  Map<Book, String> library = new HashMap<>();

  public void addNewBook(Book book, String shelf) {
    library.put(book, shelf);
  }

  public String deleteBook(String title, String author, int year) {
    Book book = new Book(title, author, year);
    return library.remove(book);
  }

  public String searchBook(String title, String author, int year) {
    Book book = new Book(title, author, year);
    return library.get(book);
  }

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
