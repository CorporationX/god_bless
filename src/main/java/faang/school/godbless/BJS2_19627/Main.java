package faang.school.godbless.BJS2_19627;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book gameOfThrones = new Book("game of thrones", "Джордж Р. Р. Мартин", 2000);
        Book java = new Book("JAVA", "Avaj", 1990);

        addBook(gameOfThrones, "полка 298");
        addBook(java, "избранное место");
        deleteBook("game of thrones", "Джордж Р. Р. Мартин", 2000);
        seachLocationBook("JAVA", "Avaj", 1990);
        outputAllBook();

    }

    public static void addBook(Book book, String location) {
        if (book != null) {
            if (!location.trim().isEmpty()) {
                library.put(book, location);
                System.out.println("книга: " + book.getTitle() + " добавлена в библиотеку");
            } else {
                System.out.println("Локация не может быть пустой");
            }
        } else {
            System.out.println("книги не существует");
        }
    }

    public static void deleteBook(String title, String author, int year) {
        Book bookToDelete = new Book(title, author, year);
        if (library.containsKey(bookToDelete)) {
            library.remove(bookToDelete);
            System.out.println("книга удалена: " + title);
        } else {
            System.out.println("книга не найдена: " + title);
        }
    }

    public static void seachLocationBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        if (library.containsKey(bookToFind)) {
            String location = library.get(bookToFind);
            System.out.println("книга найдена: " + title + ", местонахождение: " + location);
        } else {
            System.out.println("книга не найдена: " + title);
        }
    }

    public static void outputAllBook() {
        if (library.isEmpty()) {
            System.out.println("библиотека пуста.");
            return;
        }
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println("книга: " + book.getTitle() + ", автор: " + book.getAuthor() + ", год: " + book.getYear() + ", местонахождение: " + location);
        }
    }
}
