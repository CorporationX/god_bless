package school.faang.task_45295;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString() {
        return String.format("Book{title='%s', author='%s', year=%d}", title, author, year);
    }


}


