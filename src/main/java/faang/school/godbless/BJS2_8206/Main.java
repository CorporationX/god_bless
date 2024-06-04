package faang.school.godbless.BJS2_8206;

import java.util.HashMap;
import java.util.Map;

public class Main {
  static Map<Book, String> books = new HashMap<>();

  public static void main(String[] args) {
    books.put(new Book("book1", "author1", 1999), "1");
    books.put(new Book("book2", "author2", 2000), "2");
    books.put(new Book("book3", "author3", 2010), "3");
    books.put(new Book("book4", "author4", 2015), "4");

    System.out.println(books);
    addBook(new Book("book5", "author5", 2001), "5");
    System.out.println(books);
    deleteBook("book3", "author3", 2010);
    System.out.println(books);
    System.out.println(findBook("book1", "author1", 1999));
    getAllBooks();
  }

  public static void addBook(Book book, String place) {
    books.put(book, place);
  }

  public static void deleteBook(String title, String author, int year) {
    books.remove(new Book(title, author, year));
  }

  public static String findBook(String title, String author, int year) {
    return books.get(new Book(title, author, year));
  }

  public static void getAllBooks() {
    for (Map.Entry<Book, String> entry : books.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}
