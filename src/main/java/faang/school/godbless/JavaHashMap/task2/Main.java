package faang.school.godbless.JavaHashMap.task2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOK_STRING_MAP = new HashMap<>();

    public static void main(String[] args) {
        Book pushkin = new Book("Евгений Онегин", "А. С. Пушкин", 1833);
        Book dostoevsky = new Book("Преступление и наказание", "Ф. М. Достоевский", 1866);
        Book martin = new Book("Игра престолов", "Джордж Р. Р. Мартин", 1996);

        add(pushkin, "1");
        add(dostoevsky, "22");
        add(martin, "333");
        printAll();
        remove("Игра престолов", "Джордж Р. Р. Мартин", 1996);
        findInfo(BOOK_STRING_MAP, "Преступление и наказание", "Ф. М. Достоевский", 1866);
        printAll();
    }

    private static void add(Book book, String shelf) {
        BOOK_STRING_MAP.put(book, shelf);
    }

    private static void remove(String title, String author, int year) {
        BOOK_STRING_MAP.remove(new Book(title, author, year));
    }

    private static void findInfo(Map<Book, String> books, String title, String author, int year) {
        Book bookFind = new Book(title, author, year);
        System.out.println(books.get(bookFind));
    }

    private static void printAll() {
        for (Map.Entry<Book, String> entry : BOOK_STRING_MAP.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " : " + entry.getValue());

        }
    }
}
