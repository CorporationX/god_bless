package VesterovsLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {
        LIBRARY.put(new Book("Чистый код", "Роберт Мартин", 2019), "22");
        LIBRARY.put(new Book("Изучаем Java", "Кэти Сьера && Берт Бейтс", 2004), "59");
        LIBRARY.put(new Book("Грокаем алгоритмы", "Адитья Бхаргава", 2020), "37");

        printLibrary();
        add("Искусство быть", "Эрих Фромм", 1976, "70");
        printLibrary();
        remove("Грокаем алгоритмы", "Адитья Бхаргава", 2020);
        printLibrary();
        System.out.println("Книга находится на полке № " +
                searchShelfNumber("Чистый код", "Роберт Мартин", 2019));
    }

    public static void add(String title, String author, int year, String shelfNumber) {
        LIBRARY.put(new Book(title, author, year), shelfNumber);
        System.out.println("Книга добавлена.");
    }

    public static void remove(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
        System.out.println("Книга удалена.");
    }

    public static String searchShelfNumber(String title, String author, int year) {
        return LIBRARY.get(new Book(title, author, year));
    }

    public static void printLibrary() {
        for (Map.Entry<Book, String> entry : LIBRARY.entrySet()) {
            System.out.println(entry.getKey() + ", номер полки - " + entry.getValue());
        }
    }
}
