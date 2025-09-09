package school.faang.bjs2_87177;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final int EARLIEST_BOOK_YEAR = 1;

    private final Map<Book, String> library = new HashMap<>();

    public boolean addBook(String title, String author, int year, String location) {
        validateBookData(title, author, year);
        validateLocation(location);

        Book book = new Book(title.trim(), author.trim(), year);
        String previousLocation = library.put(book, location.trim());

        if (previousLocation != null) {
            System.out.printf("Книга уже есть в библиотеке. Местоположение обновлено с %s на %s%n",
                    previousLocation, location);
            return false;
        }

        System.out.printf("Книга добавлена: %s на место %s%n", book, location.trim());
        return true;
    }

    public boolean removeBook(String title, String author, int year) {
        validateBookData(title, author, year);

        Book book = new Book(title.trim(), author.trim(), year);
        String previousLocation = library.remove(book);

        if (previousLocation != null) {
            System.out.printf("Книга удалена: %s (была на %s)%n", book, previousLocation);
            return true;
        } else {
            System.out.printf("Книга для удаления не найдена: %s%n", book);
            return false;
        }
    }

    public boolean findBook(String title, String author, int year) {
        validateBookData(title, author, year);

        Book book = new Book(title.trim(), author.trim(), year);

        if (library.containsKey(book)) {
            System.out.println("Книга " + book + " находится на " + library.get(book) + ".");
            return true;
        } else {
            System.out.println("Книга " + book + " не найдена.");
            return false;
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Библиотека пуста.");
        } else {
            System.out.println("Список всех книг в библиотеке:");
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                System.out.printf("%s находится на %s%n", entry.getKey(), entry.getValue());
            }
        }
    }

    private void validateBookData(String title, String author, int year) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не может быть пустым или null.");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор не может быть пустым или null.");
        }
        if (year < EARLIEST_BOOK_YEAR) {
            throw new IllegalArgumentException("Год не может быть меньше " + EARLIEST_BOOK_YEAR + ".");
        }
    }

    private void validateLocation(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Локация не может быть пустой или null.");
        }
    }
}