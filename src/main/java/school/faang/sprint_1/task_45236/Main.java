package school.faang.sprint_1.task_45236;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        LibrarySystem librarySystem = new LibrarySystem(library);

        String[][] bookData = {
                {"Скамерство как смысл жизни", "Елена Блиновская", "2022", "1 полка"},
                {"Как заходить в хату", "Аяз Шабутдинов", "2023", "1 полка"},
                {"Попускатор", "Дмитрий Портнягин", "2018", "1 полка"},
                {"Мастер и Маргарита", "Михаил Булгаков", "1967", "2 полка"},
                {"Война и мир", "Лев Толстой", "1869", "2 полка"},
                {"1984", "Джордж Оруэлл", "1949", "2 полка"},
                {"Преступление и наказание", "Федор Достоевский", "1866", "3 полка"},
                {"Анна Каренина", "Лев Толстой", "1877", "3 полка"},
                {"Убить пересмешника", "Харпер Ли", "1960", "4 полка"},
                {"Три товарища", "Эрих Мария Ремарк", "1936", "5 полка"},
        };
        for (String[] data : bookData) {
            String title = data[0];
            String author = data[1];
            int year = Integer.parseInt(data[2]);
            String shelf = data[3];

            Book book = new Book(title, author, year);
            library.put(book, shelf);
        }

        librarySystem.addBook("Улыбайтесь друзья", "Обладатель виниров", 2024, "1 полка");
        librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "1 полка");
        librarySystem.printAllBook();
        librarySystem.removeBook("Три товарища", "Эрих Мария Ремарк", 1936);
        librarySystem.removeBook("Три товарища", "Эрих Мария Ремарк", 1936);
        librarySystem.printAllBook();
        librarySystem.findBook("Анна Каренина", "Лев Толстой", 1877);

    }
}
