package school.faang.godbless.bjs2_33028;

import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Book {

  private String title;
  private String author;
  private int year;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book book)) {
      return false;
    }
    return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, year);
  }
}
