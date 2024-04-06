package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        books.put(new Book("Гарри Поттер и Узник Азкабана", "Джоан Роулинг", 2004), "115");
        books.put(new Book("Хоббит", "Джон Толкин", 1937), "159");
        books.put(new Book("Хребты Безумия", "Говард Лавкрафт", 1931), "93");
        books.put(new Book("Житель Каркозы", "Амброз Пирс", 1886), "88");

        allBooks(books);

        System.out.println("===================>>>>>>>>>>>>>>>");
        addBook(books, new Book("Хоббит", "Джон Толкин", 1937), "12");
        addBook(books, new Book("Ворон", "Эдгар Алан По", 1845), "311");
        allBooks(books);

        System.out.println("===================>>>>>>>>>>>>>>>");
        removeBook(books, new Book("Приключения Пиноккио", "Карло Коллоди", 1881));
        removeBook(books, new Book("Гарри Поттер и Узник Азкабана", "Джоан Роулинг", 2004));
        allBooks(books);

        System.out.println("===================>>>>>>>>>>>>>>>");
        bookSearch(books, new Book("Приключения Пиноккио", "Карло Коллоди", 1881));
        bookSearch(books, new Book("Житель Каркозы", "Амброз Пирс", 1886));
    }

    public static void addBook(Map<Book, String> books, Book book, String shelfNumber) {
        if (!books.containsKey(book)) {
            books.put(book, shelfNumber);
            System.out.println("Книга " + book.getTitle() + " добавлена на полку " + shelfNumber);
        } else {
            System.out.println("Книга " + book.getTitle() + " уже есть в коллекции");
        }
    }

    public static void removeBook(Map<Book, String> books, Book book) {
        if (books.containsKey(book)) {
            books.remove(book);
            System.out.println(book.toString() + " удалена");
        } else {
            System.out.println("Указанной книги не найдено");
        }
    }

    public static void bookSearch(Map<Book, String> books, Book book) {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста");
            return;
        }
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().equals(book)) {
                System.out.println(book + " найдена на полке " + entry.getValue());
                return;
            }
        }
        System.out.println(book + " не найдена");
    }
    public static void allBooks(Map<Book, String> books){
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста");
            return;
        }
        for (Map.Entry<Book, String> entry : books.entrySet()){
            System.out.println(entry.getKey() + " на полке " + entry.getValue());
        }
    }
}
