package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java Библиотека Профессионала 1 Том", "К. Хорстманн", 2013);
        Book book2 = new Book("Паттерны ООП",
                "Э. Гамма, Р. Хелмб, Р. Джонсон, Дж. Влиссидес", 2020);
        Book book3 = new Book("Алгоритмы на Java", "Р. Седжвик", 2010);

        //3-4 пункты
        Map<Book, String> bookToPlace = new HashMap<>();
        bookToPlace.put(book1, "1");
        bookToPlace.put(book2, "2");
        bookToPlace.put(book3, "2");

        //5 пункт
        //добавление & печать
        Library library = new Library();
        library.add(book1, "1");
        library.add(book2, "2");
        library.add(book3, "3");
        System.out.println("Добавили пару книг");
        library.printBooks();

        //удаление & печать
        library.remove("Java Библиотека Профессионала 1 Том", "К. Хорстманн", 2013);
        System.out.println("Удалили книгу Хорстманна");
        library.printBooks();

        //поиск
        String place = library.getLocation("Алгоритмы на Java", "Р. Седжвик", 2010);
        System.out.println("Номер полки, на которой лежит книга Седжвика: " + place);
    }
}
