package school.faang.BJS2_33139;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Book other = (Book) obj;
        return (title.equals(other.title)
                && author.equals(other.author)
                && (year == (other.year)) );
    }
    /*вопрос, а можно делать return в который запихивать сразу все проверки? Если нет, то почему?
    *   return (obj != null
                && this.getClass() == obj.getClass()
                && title.equals(((Book)obj).title)
                && author.equals(((Book)obj).author)
                && (year == (((Book)obj).year));
    * */

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Book Title:  '" + title + '\'' +
               ", Author: '" + author + '\'' +
               ", Year: " + year;
    }
}
