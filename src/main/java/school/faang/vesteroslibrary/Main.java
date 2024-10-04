package school.faang.vesteroslibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> bookMap = new HashMap<>();
    public static void main(String[] args) {

        bookMap.put(new Book("Таинственный остров", "Жюль Верн", 1978), "полка №14");
        addNewBook("Война и мир", "Лев Толстой", 1984, "полка №12");
        addNewBook("Улисс", "Джеймс Джойс", 1982, "полка №122");
        addNewBook("Гордость и предубеждение", "Джейн Остин", 1972, "полка №18");

        deleteBook("Звук и ярость", "Уильям Фолкнер", 1943); // такой книги нет
        searchingBook("Таинственный остров2", "Жюль Верн", 1978); // такой книги нет

        searchingBook("Гордость и предубеждение", "Джейн Остин", 1972);
        deleteBook("Гордость и предубеждение", "Джейн Остин", 1972);

        printAllbooks();
    }

    private static void addNewBook(String title, String author, Integer year, String shelf) {
        bookMap.put(new Book(title, author, year), shelf);
    }

    private static void deleteBook(String title, String author, Integer year) {
        if (!bookMap.containsKey(new Book(title, author, year))) {
            System.out.println("Мы не можем удалить такую книгу потому что ее нет");
        } else {
            System.out.println("Книга успешно удалена");
            bookMap.remove(new Book(title, author, year));
        }

    }

    private static void searchingBook(String title, String author, Integer year) {
        if (!bookMap.containsKey(new Book(title, author, year))) {
            System.out.println("Такой книги не нашлось");
        } else {
            System.out.println("Книга находится на " + bookMap.get(new Book(title, author, year)));
        }
    }

    private static void printAllbooks() {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            System.out.println("Книга: " + entry.getKey() + "находится на: " + entry.getValue());
        }
    }
}
