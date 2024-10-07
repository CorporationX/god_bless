package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class Main {

  private final static Map<Book, String> BOOKS = new HashMap<>();

  public static void main(String[] args) {
    Book bookOne = new Book("War and Peace", "Leo Tolstoy", 1869);
    Book bookTwo = new Book("The Brothers Karamazov", "Fyodor Dostoevsky", 1880);
    Book bookThree = new Book("The Divine Comedy", "Dante Alighieri", 1308);
    registerBook(bookOne, "A01");
    registerBook(bookTwo, "A02");
    registerBook(bookThree, "A03");
    System.out.println("-------");
    findBook("The Divine Comedy", "Dante Alighieri", 1308);
    removeBook("The Divine Comedy", "Dante Alighieri", 1308);
    System.out.println("-------");
    listBooks();
    findBook("The Divine Comedy", "Dante Alighieri", 1308);
    removeBook("The Divine Comedy", "Dante Alighieri", 1308);
    removeBook("The Brothers Karamazov", "Dante Alighieri", 1308);
    removeBook("The Brothers Karamazov", "Fyodor Dostoevsky", 1880);
    findBook("War and Peace", "Leo Tolstoy", 1869);
    System.out.println("-------");
    registerBook(bookThree, "A03");
    listBooks();
  }

  private static void registerBook(Book book, String shelf) {
    BOOKS.put(book, shelf);
    System.out.println("[Registered]: " + book);
  }

  private static void removeBook(String title, String author, int year) {
    Book bookToRemove = new Book(title, author, year);
    if (!BOOKS.containsKey(bookToRemove)) {
      System.out.println("[Not found to remove]:" + bookToRemove);
      return;
    }
    BOOKS.remove(bookToRemove);
    System.out.println("[Removed]: "  + bookToRemove);
  }

  private static void findBook(String title, String author, int year) {
    Book bookToFind = new Book(title, author, year);
    String shelf = BOOKS.get(bookToFind);
    if (!BOOKS.containsKey(bookToFind)) {
      System.out.println("[Not found]:" + bookToFind);
      return;
    }
    System.out.println("[Found at " + shelf + "]: " + bookToFind);
  }

  private static void listBooks() {
    System.out.println("[Printing out the book list]:");
    for (Map.Entry<Book, String> entry : BOOKS.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
    System.out.println("[end]");
  }

}
