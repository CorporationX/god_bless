package school.faang.sprint_1.task_45389;

import java.util.HashMap;
import java.util.Map;

//import static school.faang.sprint_1.task_45389.Main.books;

public class LibrarySystem {
    private Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
        System.out.println("Книга добавлена: " + book + " местонахождение: " + location);
        System.out.println();
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
        System.out.println("Книга " + book + " удалена ");
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            String location = books.get(book);
            System.out.println("Книга найдена " + book + " местоположение " + location);
        } else {
            System.out.println("Книга не найдена");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println("имя: " + entry.getKey() + " находится на полке: " + entry.getValue());
        }
    }
}
