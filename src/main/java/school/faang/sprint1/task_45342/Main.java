package school.faang.sprint1.task_45342;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOK_COLLECTION = new HashMap<>();

    public static void main(String[] args) {
        BOOK_COLLECTION.put(new Book("Сто лет одиночества", "Гариса Маркес", 1967), "Номер полки 24");
        BOOK_COLLECTION.put(new Book("Осень патриарха", "Габриэль Гарсиа", 1975), "Номер полки 3");
        BOOK_COLLECTION.put(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967), "Номер полки 34");

        addBook("Тихий Дон", "Михаил Шолохов", 1940, "Номер полки 66");

        removeBook("Мастер и Маргарита", "Михаил Булгаков", 1967);

        findBook("Осень патриарха", "Габриэль Гарсиа", 1975);

        findBook("сень патриарха", "Габриэль Гарсиа", 1975);

        printAllBooks();

    }

    private static void addBook(String title, String author, int year, String location) {
        BOOK_COLLECTION.put(new Book(title, author, year), location);
    }

    private static void removeBook(String title, String author, int year) {
        BOOK_COLLECTION.remove(new Book(title, author, year));
    }

    private static void findBook(String title, String author, int year) {
        if (BOOK_COLLECTION.containsKey(new Book(title, author, year))) {
            System.out.println("Книга тут " + BOOK_COLLECTION.get(new Book(title, author, year)));
        } else {
            System.out.println("Книги нет");
        }
    }

    private static void printAllBooks() {
        for (Map.Entry<Book, String> entry : BOOK_COLLECTION.entrySet()) {
            System.out.println(entry);
        }
    }
}
