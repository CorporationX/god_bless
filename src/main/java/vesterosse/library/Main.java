package vesterosse.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void addBook(Map<Book, String> map, Book book, String place) {
        map.put(book, place);
        System.out.println("Книга '" + book.getTitle() + "' добавлена в библиотеку!" + "\n");
    }

    public static void removeBook(Map<Book, String> map, String title, String author, int year) {
        map.remove(new Book(title, author, year));
        System.out.println("Вы удалили книгу '" + title + "' из библиотеки!" + "\n");
    }

    public static void searchBook(Map<Book, String> map, String title, String author, int year) {
        System.out.println("Ваша книга найдена! Она находится на полке № " + map.get(new Book(title, author, year)) + "\n");
    }

    public static void printBook(Map<Book, String> map) {
        System.out.println("Список всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", Полка № " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<Book, String> map = new HashMap<>();
        map.put(new Book("The Mythical Man-Month", "Frederick Brooks", 2020), "1");
        map.put(new Book("A Philosophy Of Software Design", "John Ousterhout", 2015), "3");
        map.put(new Book("Code Complete: A Practical Handbook of Software Construction", "Steve McConnell", 2017), "2");
        map.put(new Book("Working Effectively with Legacy Code", "Michael C. Feathers", 2023), "1");

        addBook(map, new Book("Clean Code", "Robert C. Martin", 2013), "2");
        removeBook(map, "Code Complete: A Practical Handbook of Software Construction", "Steve McConnell", 2017);
        searchBook(map, "A Philosophy Of Software Design", "John Ousterhout", 2015);
        printBook(map);
    }
}
