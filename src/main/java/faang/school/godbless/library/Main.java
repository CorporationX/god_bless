package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {
  private static final Map<Book, String> books = new HashMap<>();
  public static void main(String[] args) {
    books.put(new Book("Разминка для ума", "Петров", 1999), "Б-52");
    books.put(new Book("Либеральный торт", "Варламов", 2024), "А-28");
    books.put(new Book("Gunners", "Венгер", 1905), "А-4");
    books.put(new Book("Бумажный дом", "Влад Бумага", 2020), "А-4");

    BookService.addBook(new Book("Счастливы вместе", "Букин Г.", 2005), "ТНТ-4");
    BookService.removeBookByBookInfo("Либеральный торт", "Варламов", 2024);
    log.info(BookService.getBookPlaceByInfo("Счастливы вместе", "Букин Г.", 2005));
    BookService.printBooksInfo();
  }

  private static class BookService {
    static void addBook(Book book, String place) {
      books.put(book, place);
      log.info(String.format("Added book: %s | %s", book.getTitle(), books));
    }
    static void removeBookByBookInfo(String title, String author, Integer year) {
      Book bookForRemove = new Book(title, author, year);
      books.remove(bookForRemove);
      log.info(String.format("Removed book: %s | %s", bookForRemove.getTitle(), books));
    }

    static String getBookPlaceByInfo(String title, String author, Integer year) {
      Book bookKey = new Book(title, author, year);
      return books.get(bookKey);
    }

    static void printBooksInfo() {
      books.forEach((book, place) -> log.info(String.format("%s: %s", book, place)));
    }
  }
}
