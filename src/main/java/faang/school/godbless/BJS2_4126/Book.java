package faang.school.godbless.BJS2_4126;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    public static void addBook(Book book, String address, Map<Book, String> target) {
        target.put(book, address);
    }

    public static void removeBook(String title, String author, int year, Map<Book, String> target) {
        Book bookBeingDeleted = new Book(title, author, year);
        target.remove(bookBeingDeleted);
    }

    public static String findAddressByBook(String title, String author, int year, Map<Book, String> target) {
        Book bookToFind = new Book(title, author, year);
        String address = target.get(bookToFind);

        if (address == null) {
            throw new IllegalArgumentException(String.format("Книга \"%s\", Автор \"%s\", Год издания \"%s\" не найдена", title, author, year));
        }

        return address;
    }

    public static void printAllBooks(Map<Book, String> target) {
        System.out.println("Список всех книг и их местонахождений:");
        for (Map.Entry<Book, String> entry : target.entrySet()) {
            Book book = entry.getKey();
            String address = entry.getValue();
            System.out.printf("Книга \"%s\", Автор \"%s\", Год издания \"%s\", Адрес \"%s\"", book.getTitle(), book.getAuthor(), book.getYear(), address);
            System.out.println();
        }
    }
}
