package faang.school.godbless.library;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * POJO класс для Книги Весткроса.
 */
@Getter
@ToString
@AllArgsConstructor
public class Book {

  /**
   * название книги
   */
  private String title;

  /**
   * автор книги
   */
  private String author;

  /**
   * год издания
   */
  private Integer year;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book book)) {
      return false;
    }
    return Objects.equals(title, book.title) && Objects.equals(author,
        book.author) && Objects.equals(year, book.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, year);
  }
}
