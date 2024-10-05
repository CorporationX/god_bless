package school.faang;


import school.faang.classes.Book;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> booksMap = new HashMap<>();

    public static void addNewBook(Book book, String location) {
        booksMap.put(book, location);
    }

    public static void displayAllBooks() {
        for(Map.Entry<Book, String> book : booksMap.entrySet()) {
            System.out.println("Книга " + book.getKey() + " находится в " + book.getValue());
        }
    }

    public static void displayOneBook(String title, String author, Integer year) {
        Book necessaryBook = new Book(title, author, year);
        System.out.println(booksMap.getOrDefault(necessaryBook, "Not find"));
    }

    public static void deleteBook(String title, String author, Integer year) {
        Book deleteBook = new Book(title, author, year);
        booksMap.remove(deleteBook);
    }

    public static void main(String[] args) {
        booksMap.put(new Book("Навыки высокоэффективных людей", "С. Кови", 1989), "18K");
        booksMap.put(new Book("Философия Java", "Б. Эккель", 2010), "12A");
        booksMap.put(new Book("Атомные привычки", "Дж. Клир", 2017), "05B");

        displayAllBooks();
        addNewBook(new Book("Проект Аве Мария", "Э. Уир", 2021), "44Z");
        deleteBook("Навыки высокоэффективных людей", "С. Кови", 1989);
        displayAllBooks();
        displayOneBook("Философия Java", "Б. Эккель", 2010);
    }
}