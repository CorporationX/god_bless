package school.faang.sprint1.task45319vesterosa;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static school.faang.sprint1.task45319vesterosa.Main.library;

@Slf4j
public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location) {
        try {
            var book = new Book(title, author, year);
            library.put(book, location);
            System.out.printf("Книга: %s добавлена в %s", book.getTitle(), location);
        } catch (Exception e) {
            log.error("Ошибка в addBook");
            throw new RuntimeException(e);
        }

    }

    public static void addBook(Book book, String location) {
        library.put(book, location);
        System.out.printf("%s locatio: %s", book.getTitle(), location);
        System.out.println();
    }

    public static void removeBook(String title, String author, int year) {
        var book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
        } else {
            System.out.println("Нет такой книжки");
        }
    }

    public static void removeBook(Book book) {
        if (library.containsKey(book)) {
            library.remove(book);
        } else {
            System.out.println("Нет такой книжки");
        }
    }

    public static void findBook(String title, String author, int year) {
        var book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.get(book);
        } else {
            System.out.println("Нет такой книжки");
        }
    }

    public static void findBook(Book book) {
        if (library.containsKey(book)) {
            library.get(book);
        } else {
            System.out.println("Нет такой книжки");
        }
    }

    public static void printAllBooks() {
        int bookNumber = 1;
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            Book book = entry.getKey();
            System.out.printf("%d. %s - %s - %d. Location %s%n",
                    bookNumber, book.getTitle(), book.getAuthor(), book.getYear(), entry.getValue());
            System.out.println();
            bookNumber++;
        }
    }
}
