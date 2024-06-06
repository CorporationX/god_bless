package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
  private static final String SHELF_NUMBER_VALUE = "Полка №: ";

  private static final Map<Book, String> bookStringMap = new HashMap<>();

  /**
   * Метод для добавления новой книги и её местонахождения в библиотеке.
   * @param book Объект "Книги Вестероса"
   * @param shelfNumber Номер полки
   */
  private static void addBook(Book book, String shelfNumber) {
    bookStringMap.put(book, shelfNumber);
  }

  /**
   * Метод для удаления книги по её названию, автору и году издания.
   * @param bookTitle название книги
   * @param bookAuthor автор книги
   * @param bookYear год издания
   */
  private static void remoteBook(String bookTitle, String bookAuthor, Integer bookYear) {
    bookStringMap.remove(new Book(bookTitle, bookAuthor, bookYear));
  }

  /**
   * Метод для поиска книги и вывода информации о её местонахождении в библиотеке,
   * используя название книги, автора и год издания.
   * @param bookTitle название книги
   * @param bookAuthor автор книги
   * @param bookYear год издания
   */
  private static void findBook(String bookTitle, String bookAuthor, Integer bookYear) {
    Optional.ofNullable(bookStringMap.get(new Book(bookTitle, bookAuthor, bookYear)))
        .ifPresent(System.out::println);
  }

  /**
   * Метод для выводв списка всех книг и их местонахождения в библиотеке.
   */
  private static void showAllBook() {
    bookStringMap.forEach((key, value) -> System.out.println(key.getTitle() + " " +
        key.getAuthor() + " " + key.getYear() + " " + SHELF_NUMBER_VALUE + value));
  }

  public static void main(String[] args) {
    Book book1 = new Book("Белые ходоки", "Старк", 900);
    Book book2 = new Book("Правление безумного корорля", "Таргариен", 300);
    addBook(book1, "Первая полка");
    addBook(book2, "Вторая полка");
    remoteBook("кровавая свадьба", "Неизвестен", 1000);
    findBook("Правление безумного корорля", "Таргариен", 300);
    showAllBook();
  }

}
