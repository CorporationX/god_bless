package school.faang.sprint1.task_bjs245346;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Book firstBook = new Book("Гарри Поттер и философский камень", "Джоан Роулинг", 1997);
        Book secondBook = new Book("Гарри Поттер и Тайная комната", "Джоан Роулинг", 1998);
        Book thirdBook = new Book("Гарри Поттер и узник Азкабана", "Джоан Роулинг", 1999);

        Map<Book, String> books = new HashMap<>();
        books.put(firstBook, "1234");
        books.put(secondBook, "4321");
        books.put(thirdBook, "7777");

        var library = new LibrarySystem(books);
        library.addBook("Новая книга", "Неизвестный автор", 2024, "5555");
        System.out.println("Книга найдена: " + library.findBook("Новая книга", "Неизвестный автор", 2024));
        System.out.println("Книга найдена: " + library.findBook("Несуществующая книга", "Неизвестный автор", 2025));
        library.removeBook("Новая книга", "Неизвестный автор", 2024);
    }

}
