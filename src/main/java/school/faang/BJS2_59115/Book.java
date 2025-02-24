package school.faang.BJS2_59115;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Book {
    private String title;
    private String author;
    private int year;

    public Book() {
    }

    public Book(String title, String author, int year) {
        if (validateYear(year)) {
            this.year = year;
        }else {
            throw new IllegalArgumentException("Некорректный год");
        }

        this.title = title;
        this.author = author;
    }

    private boolean validateYear(int year) {
        if (!(year > 0 && year <= 2025)) {
            return false;
        }

        return true;
    }
}