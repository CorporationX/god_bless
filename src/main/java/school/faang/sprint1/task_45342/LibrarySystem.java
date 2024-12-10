package school.faang.sprint1.task_45342;

import java.util.Map;

import static school.faang.sprint1.task_45342.Main.BOOK_COLLECTION;

public class LibrarySystem {
    protected static void addBook(String title, String author, int year, String location) {
        BOOK_COLLECTION.put(new Book(title, author, year), location);
    }

    protected static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (BOOK_COLLECTION.containsKey(book)) {
            System.out.println("Удалена книга - " + book);
        } else {
            System.out.println("Книга не найдена");
        }
    }

    protected static void findBook(String title, String author, int year) {
        if (BOOK_COLLECTION.containsKey(new Book(title, author, year))) {
            System.out.println("Книга тут " + BOOK_COLLECTION.get(new Book(title, author, year)));
        } else {
            System.out.println("Книги нет");
        }
    }

    protected static void printAllBooks() {
        for (Map.Entry<Book, String> entry : BOOK_COLLECTION.entrySet()) {
            System.out.println(entry);
        }
    }
}
