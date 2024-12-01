package school.faang.bjs245234.model;

import java.util.Objects;

public class Book {
    /**
     * Создайте класс Book с полями:
     * title;
     * author;
     * year.
     */
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    /**
     * Переопределите методы equals и hashCode в классе Book,
     * чтобы учитывать название книги, автора и год издания при сравнении книг и расчёте их хэш-кода.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
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
