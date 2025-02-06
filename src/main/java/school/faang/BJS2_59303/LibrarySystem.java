package school.faang.BJS2_59303;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> books = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {

        //я не думаю что тут нужна валидация, так как локация у книги может быть другая, да и тем более дублекация книги
        // должно быть допустимым, но из-за того что hashmap, она все равно не допустит дубликацию
        // типа нету смысла проверять есть ли книга //

        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!books.containsKey(book)) {
            System.out.println("Ошбка! Книга не найдена!");
        } else {
            books.remove(book);
            System.out.println("Книга успешно удалена!");
        }
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!books.containsKey(book)) {
            System.out.println("Книга не найдена");
        } else {
            System.out.println("Название книги " + book.title() + " Найдена! Ее локация: " + books.get(book));
        }
    }

    public static void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пустая!");
        }
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println("Книга: \"" + entry.getKey().title() + "\" " + "Находится: " + entry.getValue());
        }
    }
}


