package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
  private static Map<Book, String> books = new HashMap<>();
  public static void main(String[] args) {
    books.put(new Book("title", "author", "year"), "1");
    books.put(new Book("title1", "author1", "year1"), "2");
    books.put(new Book("title2", "author2", "year2"), "3");
    addBook(new Book("title3", "author3", "year3"), "4");
    deleteBook("title1", "author1", "year1");
    String bookPlace = findBookPlace("title2", "author2", "year2");
    findAllBooks().forEach(((book, place) -> System.out.println(book + " - " + place)));


  }
  public static void addBook(Book book, String place) {
    books.put(book, place);
  }
  public static void deleteBook(String title, String author, String year) {
    books.remove(new Book(title, author, year));
  }
  public static String findBookPlace(String title, String author, String year) {
    return books.get(new Book(title, author, year));
  }
  public static Map<Book, String> findAllBooks() {
    return books;
  }
}
