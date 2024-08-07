package faang.school.godbless.javahashmap.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private final static Map<Book, Integer> booksMap = new HashMap<>();

    public static void main(String[] args) {
        booksMap.put(new Book("1984", "Джордж Оруэлл", 1949), 4);
        booksMap.put(new Book("Гордость и предубеждение", "Джейн Остин", 1813), 10);
        booksMap.put(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967), 40);

        addBook(new Book("1984", "Джордж Оруэлл", 20000000));
        removeBook(new Book("Гордость и предубеждение", "Джейн Остин", 1813));
        findBook(new Book("Гордость и предубеждение", "Джейн Остин", 1813));
        findBook(new Book("1984", "Джордж Оруэлл", 20000000));
        System.out.println();
        printAll();
    }

    public static void addBook(Book book) {
        Random random = new Random();
        booksMap.put(book, random.nextInt(25));
    }

    public static Integer removeBook(Book book) {
        return booksMap.remove(book);
    }

    public static Integer findBook(Book book) {
        Integer index = booksMap.get(book);
        if (index != null) {
            System.out.println("Книга " + book.getTitle() + " на полке " + index);
        } else {
            System.out.println("Книга не найдена");
        }
        return index;
    }

    public static void printAll() {
        for (Map.Entry<Book, Integer> entry : booksMap.entrySet()) {
            System.out.println("Книга " + entry.getKey() + " на полке " + entry.getValue());
        }
    }
}
