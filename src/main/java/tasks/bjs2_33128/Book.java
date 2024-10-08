package tasks.bjs2_33128;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public static boolean isValid(String title, String author, int year) {
        if (year < 0) {
            System.out.println("Год книги не может быть отрицательным!");
            return false;
        }

        if (title.isBlank()) {
            System.out.println("Название книги не может быть пустым!");
            return false;
        }

        if (author.isBlank()) {
            System.out.println("Автор книги не может быть пустым!");
            return false;
        }

        return true;
    }

    public String getInformation() {
        return String.format("Книга %-30s. Автор %-30s. Год издания : %-5d", title, author, year);
    }
}
