package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null||getClass() != o.getClass()){
            return false;
        }
        Book book1 = (Book) o;
        return year == book1.year &&
                Objects.equals(title, book1.title) &&
                Objects.equals(author, book1.author);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
