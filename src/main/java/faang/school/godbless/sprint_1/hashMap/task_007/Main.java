package faang.school.godbless.sprint_1.hashMap.task_007;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static Map<Book, String> bookAddressMap = new HashMap<>();

    public static void main(String[] args) {
        bookAddressMap.put(new Book("Приключение Чипполино", "Джанни Радари", 1951), "J");
        bookAddressMap.put(new Book("Дубровский", "А.С. Пушкин", 1841), "P");
        bookAddressMap.put(new Book("Кому на Руси жить хорошо", "Н.А. Некрасов", 1982), "N");
        System.out.println("Книги в библиотеке (исходный список):");
        printAllBook();
        System.out.println();

        System.out.println("Добавление в библиотеку книги \"Колобок\" (полка F)");
        Book newBook = new Book("Колобок", "фольклор", 1000);
        String shelf = "F";
        addBook(newBook, shelf);

        System.out.println("Удаление из библиотеки книги \"Приключение Чипполино\"");
        removeBook("Приключение Чипполино", "Джанни Радари", 1951);

        System.out.println("Информация о полке с книгой \"Дубровский\" (полка-P)");
        System.out.println(findBookAddress("Дубровский", "А.С. Пушкин", 1841));

        System.out.println("Книги в библиотеке (обновлённый список):");
        printAllBook();
    }

    private static void removeBook(String title, String author, int year) {
        bookAddressMap.remove(new Book(title, author, year));
    }


    private static void printAllBook() {
        for (var entry : bookAddressMap.entrySet()) {
            System.out.println("book: " + entry.getKey() + " on shelf: " + entry.getValue());
        }
    }

    private static String findBookAddress(String title, String author, int year) {
        return bookAddressMap.get(new Book(title, author, year));
    }

    private static void addBook(Book newBook, String shelf) {
        bookAddressMap.put(newBook, shelf);
    }
}
