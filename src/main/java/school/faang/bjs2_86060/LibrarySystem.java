package school.faang.bjs2_86060;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Местоположение не может быть пустым");
        }

        library.put(new Book(title, author, year), location);
        System.out.println("Книга добавлена на местоположение: " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        boolean isRemoved = library.remove(bookToRemove) != null;
        if (isRemoved) {
            System.out.println("Книга " + bookToRemove + " удалена");
        } else {
            System.out.println("Книга " + bookToRemove + " не найдена");
        }
    }

    public Optional<String> findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String result = library.get(bookToFind);
        return Optional.ofNullable(result);
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Библиотека пустая.");
            return;
        }

        library.forEach((book, location) ->
                System.out.printf("%s (%d) - %s | Место: %s%n",
                        book.getTitle(), book.getYear(), book.getAuthor(), location));
    }
}
