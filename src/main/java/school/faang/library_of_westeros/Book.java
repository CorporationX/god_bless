package school.faang.library_of_westeros;

import lombok.Data;

@Data
public class Book {

    private static final int MIN_YEAR = 0;
    private static final int MAX_YEAR = 2025;

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не может быть пустым или null");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Имя автора не может быть пустым или null");
        }
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException(
                    "Год выпуска книги не может быть отрицательным или больше текущего года");
        }

        this.title = title;
        this.author = author;
        this.year = year;
    }
}
