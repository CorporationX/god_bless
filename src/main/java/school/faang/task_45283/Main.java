package school.faang.task_45283;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    @Getter
    private static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        books.put(new Book("Тихий дон", "Шелохов", 1932), "1");
        books.put(new Book("Треумфальная арка", "Ремарк", 1939), "2");
        books.put(new Book("Война и Мир", "Толстой", 1869), "3");
        books.put(new Book("Мастер и Маргарита", "Булгаков", 1928), "4");
        books.put(new Book("Капитанская дочка", "Пушкин", 1830), "5");
        books.put(new Book("Мертвые души", "Гоголь", 1842), "6");

        LibrarySystem.addBook("Вечера на хуторе", "Гоголь", 1863, "7");
        LibrarySystem.removeBook("Треумфальная арка", "Ремарк", 1939);
        System.out.println(LibrarySystem.findBook("Мастер и Маргарита", "Булгаков", 1928));
        LibrarySystem.printAllBooks();
    }
}
