package school.faang.task45246;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class LibrarySystem {
    private Map<Book, String> library;

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);

        if (!library.containsKey(book)) {
            library.put(book, location);
            System.out.println(book + " добавлена.\n");
        } else {
            System.out.println("Такая книга уже есть.\n");
        }
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.remove(book) != null;
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (library.containsKey(book)) {
            System.out.println("Найдена " + book + " Полка: " + library.get(book) + '\n');
        } else {
            System.out.println(book + " не найдена.\n");
        }
    }

    public void printAllBooks() {
        for (var entry : library.entrySet()) {
            System.out.println(entry.getKey() + " Полка: " + entry.getValue());
        }
        System.out.println();
    }
}
