package faang.school.godbless.task_007;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }

        Book book = (Book) o;

        if (this.getAuthor().equals(book.getAuthor())
                || this.getTitle().equals(book.getTitle())
                || this.getYear() == book.getYear()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        int hCode = 0;
        for (int i = 0; i < Math.min(author.length(), title.length()); i++) {
            hCode += title.charAt(i);
            hCode += author.charAt(i);
        }
        hCode += year;
        return hCode;
    }
}
