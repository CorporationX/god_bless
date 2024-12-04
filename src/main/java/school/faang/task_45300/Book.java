package school.faang.task_45300;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper=false)
public class Book extends LibrarySystem {
    private String title;
    private String author;
    private Integer year;

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;
        return ((title == book.title)
                || (title != null && title.equals(book.title)))
                && (author == book.author
                || (author != null && author.equals(book.author)))
                && (year == book.year
                || (year != null && year.equals(book.year)));
    }

    @Override
    public int hashCode() {
        String tay = this.title + this.author + this.year;
        return tay.hashCode();
    }
}
