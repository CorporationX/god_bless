package faang.school.godbless.vesterosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library;

    public static void main(String[] args) {
        library = new HashMap<>(Map.of(new Book("игра престолов", "Джордж Мартин", 1965), "Пятая полка",
                new Book("Гарри Поттер и философский камень", "Джоан Роулинг", 1987), "Вторая полка"));
        print();
        addBook(new Book("Гарри Поттер и Тайная комната", "Джоан Роулинг", 1991), "Вторая полка");
        print();
        removeBook("игра престолов", "Джордж Мартин", 1967);
        print();
        removeBook("игра престолов", "Джордж Мартин", 1965);
        print();
        System.out.println(findBook("Гарри Поттер и философский камень", "Джоан Роулинг", 1987));
        System.out.println("------------------------------------");
        System.out.println(findBook("Гарри Поттер и философский камень", "Роулинг", 1987));
    }

    public static void print() {
        printInformationAboutLibrary();
        System.out.println("------------------------------------");
    }


    public static void addBook(Book book, String location) {
        library.put(book, location);
    }

    public static void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static String findBook(String title, String author, int year) {
        return library.getOrDefault(new Book(title, author, year), "Такой книги в библиотеке не найдено");
    }

    public static void printInformationAboutLibrary() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.printf("%s; Местонахождение: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
