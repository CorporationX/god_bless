package faang.school.godbless.VesterossLibrary;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Book {
    private String title;
    private String author;
    private int year;

    //ПЕРЕОПРЕДЕЛЯЛ ИХ ВРУЧНУЮ А НЕ ЧЕРЕЗ ЛОМБОК, ПОТОМУ ЧТО ВРОДЕ ТАК НАДО ПО ЗАДАНИЮ

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        if (this.title == other.title && this.author == other.author && this.year == other.year) return true;
        return false;
     }
}
