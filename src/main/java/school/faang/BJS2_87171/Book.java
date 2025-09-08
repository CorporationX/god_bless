package school.faang.BJS2_87171;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    //Прошу обратить внимание, правильно ли я переопределил все эти методы, поскольку сделал это просто
    //автоматически через alt+insert. Так всегда можно делать? Или надо как-то высчитывать тут комбинации
    //вручную?
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
