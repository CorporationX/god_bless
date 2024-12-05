package school.faang.task_45236;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>(Map.of(
                new Book("Скамерство как смысл жизни", "Елена Блиновская", 2022), "1 пока",
                new Book("Как заходить в хату", "Аяз Шабутдинов", 2023), "1 полка",
                new Book("Попускатор", "Дмитрий Портнягин", 2018), "1 полка",
                new Book("Мастер и Маргарита", "Михаил Булгаков", 1967), "2 полка",
                new Book("Война и мир", "Лев Толстой", 1869), "2 полка",
                new Book("1984", "Джордж Оруэлл", 1949), "2 полка",
                new Book("Преступление и наказание", "Федор Достоевский", 1866), "3 полка",
                new Book("Анна Каренина", "Лев Толстой", 1877), "3 полка",
                new Book("Убить пересмешника", "Харпер Ли", 1960), "4 полка",
                new Book("Три товарища", "Эрих Мария Ремарк", 1936), "5 полка"
        ));

        LibrarySystem librarySystem = new LibrarySystem(library);

        librarySystem.addBook("Улыбайтесь друзья", "Обладатель виниров", 2024, "1 полка");
        librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "1 полка");
        librarySystem.printAllBook();
        librarySystem.removeBook("Три товарища", "Эрих Мария Ремарк", 1936);
        librarySystem.removeBook("Три товарища", "Эрих Мария Ремарк", 1936);
        librarySystem.printAllBook();
        librarySystem.findBook("Анна Каренина", "Лев Толстой", 1877);

    }
}
