package library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Book {
    static Map<Book, String> books = new HashMap<>();
    private String title;
    private String author;
    private int year;

    public static void main(String[] args) {
        addBook(new Book("Мастер и Маргарита", "Михаил Булгаков", 1929), "Первая на 2 полке");
        addBook(new Book("Мёртвые души", "Николай Гоголь", 1845), "Вторая на 5 полке");
        addBook(new Book("Евгений Онегин", "Александр Пушкин", 1825), "Полседняя на 2 полке");

        printBookPlace("Мёртвые души", "Николай Гоголь", 1845);

        removeBook("Мёртвые души", "Николай Гоголь", 1845);
        printBookPlace("Мёртвые души", "Николай Гоголь", 1845);
        printBookPlace("Мастер и Маргарита", "Михаил Булгаков", 1928);

        printBooksAndPlaces();
    }

    static void addBook(Book book, String place) {
        books.put(book, place);
    }

    static void printBookPlace(String title, String author, int year) {
        String bookPlace = books.get(new Book(title, author, year));

        if (bookPlace != null) {
            System.out.printf("Книга '%s' находится на '%s' месте\n", title, bookPlace);
        } else {
            System.out.printf("Книга '%s' не найдена\n", title);
        }
    }

    static void removeBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    static void printBooksAndPlaces() {
        books.forEach((book, place) -> {
            System.out.printf("Книга '%s' находится на '%s' месте\n", book.getTitle(), place);
        });
    }
}
