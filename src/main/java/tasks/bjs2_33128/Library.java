package tasks.bjs2_33128;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;

@Data
public class Library {
    private Map<Book, String> books = new HashMap<>();

    private final int MAX_SHELF = 12;
    private final int MAX_DIGITS = String.valueOf(MAX_SHELF).length();
    private int year;

    public Library(List<Book> books) {
        Create(books);
    }

    public void showBooks() {
        if (books.size() == 0) {
            System.out.println("На полках в библиотеке пока нет книг!");
            return;
        }

        System.out.println("Кол-во книг на полках : " + books.size() +
                ". Кол-во свободных полок : " + (MAX_SHELF - books.size())
        );

        for (Map.Entry<Book, String> entry : getBooksSortedByShelf(books).entrySet()) {
            System.out.println(String.format("Полка |%s|. %s", entry.getValue(), entry.getKey().getInformation()));
        }

        System.out.println();
    }

    public void addBook(String title, String author, int year) {
        System.out.println("Добавление книги в библиотеку по параметрам");
        System.out.println(String.format("Книга '%s', Автор '%s', год '%d'", title, author, year));

        try {
            System.out.println("Проверяем корректность книги...");

            if (Book.isValid(title, author, year)) {
                Book book = new Book(title, author, year);
                System.out.println("Пытаемся найти свободную полку...");
                String shelf = getFirstFreeShelf();
                System.out.println("Кладём книгу на полку...");
                books.putIfAbsent(book, shelf);
                System.out.println(
                        String.format("Книга '%s' теперь находится на полке : '%s' ", book.getTitle(), shelf)
                );
            }
        } catch (Exception e) {
            System.out.println("Ну удалось добавить книгу в библиотеку по причине : " + e.getMessage());
        }

        System.out.println();
    }

    public void removeBookByTitle(String title) {
        System.out.println("Удаление книги в библиотеке по названию : " + title);
        removeBookByPredicate(e -> e.getKey().getTitle().equalsIgnoreCase(title));
    }

    public void removeBookByAuthor(String author) {
        System.out.println("Удаление книги в библиотеке по автору : " + author);
        removeBookByPredicate(e -> e.getKey().getAuthor().equalsIgnoreCase(author));
    }

    public void removeBookByYear(int year) {
        System.out.println("Удаление книги в библиотеке по году издания : " + year);
        removeBookByPredicate(e -> e.getKey().getYear() == year);
    }

    private void Create(List<Book> books) {
        for (Book book : books) {
            addBook(book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    private String getFirstFreeShelf() {
        return IntStream.rangeClosed(1, MAX_SHELF)
                .mapToObj(i -> String.format("%0" + MAX_DIGITS + "d", i))
                .filter(shelf -> !books.containsValue(shelf))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Нет свободных полок в библиотеке"));
    }

    private Map<Book, String> getBooksSortedByShelf(Map<Book, String> books) {
        return books
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> Integer.parseInt(e.getValue())))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));
    }

    private void removeBookByPredicate(Predicate<Map.Entry<Book, String>> predicate) {
        try {
            System.out.println("Поиск книги в библиотеке...");
            Book book = books
                    .entrySet()
                    .stream()
                    .filter(predicate)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Данной книги нет на полках в библиотеке"))
                    .getKey();
            System.out.println("Пытаемся убрать книгу с полки...");
            books.remove(book);
            System.out.println(String.format("Книга '%s' была убрана с полки", book.getTitle()));
        } catch (Exception e) {
            System.out.println("Ну удалось убрать книгу в библиотеку по причине : " + e.getMessage());
        }

        System.out.println();
    }
}
