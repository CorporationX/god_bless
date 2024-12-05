package school.faang.task_45281;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Book, String> library = new HashMap<>();
        library.put(new Book("Робинзон Крузо", "Даниэль Дефо", 1719), "table");
        library.put(new Book("Война и мир", "Лев Толстой", 1869), "Floor");
        library.put(new Book("Преступление и наказание", "Фёдор Достоевский", 1866), "table");
        library.put(new Book("1984", "Джордж Оруэлл", 1949), "table");
        library.put(new Book("Унесённые ветром", "Маргарет Митчелл", 1936), "Floor");
        library.put(new Book("Гордость и предубеждение", "Джейн Остин", 1813), "Chair");
        library.put(new Book("О дивный новый мир", "Олдос Хаксли", 1932), "Chair");

        LibrarySystem lib = new LibrarySystem(library);

        lib.addBook("Собачье сердце", "Михаил Булгаков", 1925, "Desk");
        lib.printAllBooks();

        String location = lib.findBook("1984", "Джордж Оруэлл", 1949);
        System.out.println("Книга " + location + "\n");

        lib.removeBook("Война и мир", "Лев Толстой", 1869);
        lib.printAllBooks();
    }
}
