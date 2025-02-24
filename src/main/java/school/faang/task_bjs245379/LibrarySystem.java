package school.faang.task_bjs245379;

import java.util.Map;

public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location) {
        Main.books.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        Main.books.remove(new Book(title, author, year));
    }

    public static String findBook(String title, String author, int year) {
        if (!Main.books.containsKey(new Book(title, author, year))) {
            return "Такой книги нет в библиотеке";
        }
        return String.format("Книга %s находится в локации: %s",
                title, Main.books.get(new Book(title, author, year)));
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> book : Main.books.entrySet()) {
            System.out.println(book.getKey() + " " + book.getValue());
        }
    }
}
