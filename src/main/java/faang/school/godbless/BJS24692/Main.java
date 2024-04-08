package faang.school.godbless.BJS24692;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();

        Book.addBook(library, new Book("Война и мир", "Л. Толстой", 1869), "Полка 1");
        Book.addBook(library, new Book("Преступление и наказание", "Ф. Достоевский", 1866), "Полка 2");
        Book.addBook(library, new Book("1984", "Дж. Оруэлл", 1949), "Полка 3");

        System.out.println("Список всех книг в библиотеке:");
        Book.printBooks(library);

        Book.removeBook(library, new Book("1984", "Дж. Оруэлл", 1949));

        Book.findBook(library, new Book("Преступление и наказание", "Ф. Достоевский", 1866));

        System.out.println("\nСписок всех книг после удаления:");
        Book.printBooks(library);
    }
}
