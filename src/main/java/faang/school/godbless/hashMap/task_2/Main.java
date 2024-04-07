package faang.school.godbless.hashMap.task_2;

import faang.school.godbless.hashMap.task_2.model.Book;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {
        Book historyBook = new Book("история Вестероса", "историк Вестероса", 20);
        Book mathBook = new Book("математика Вестероса", "математик Вестероса", 3);
        Book fairyTalesBook = new Book("сказки Вестероса", "сказочник Вестероса", 6);
        add(historyBook, "Полка 3");
        add(mathBook, "Полка 6");
        add(fairyTalesBook, "Полка 6");
        System.out.println("Мапа до удаления: ");
        printAll();
        remove(mathBook);
        System.out.println("Мапа после удаления: ");
        printAll();
        System.out.printf("информация о расположении книги %s :%n", historyBook.getTitle());
        printInfo(historyBook);
    }

    private static void add(Book book, String shelf) {
        BOOKS.put(book, shelf);
    }

    private static void remove(Book book) {
        BOOKS.remove(book);
    }

    private static void printInfo(Book book) {
        System.out.println(BOOKS.get(book));
    }

    private static void printAll() {
        BOOKS.forEach((book, shelf) -> System.out.println(book + " : " + shelf));
        System.out.println();
    }
}