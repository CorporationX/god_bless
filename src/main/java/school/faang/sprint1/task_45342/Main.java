package school.faang.sprint1.task_45342;

import java.util.HashMap;
import java.util.Map;

public class Main {
    protected static final Map<Book, String> BOOK_COLLECTION = new HashMap<>();

    LibrarySystem librarySystem = new LibrarySystem();

    public static void main(String[] args) {

        final LibrarySystem librarySystem = new LibrarySystem();

        BOOK_COLLECTION.put(new Book("Сто лет одиночества", "Гариса Маркес", 1967), "Номер полки 24");
        BOOK_COLLECTION.put(new Book("Осень патриарха", "Габриэль Гарсиа", 1975), "Номер полки 3");
        BOOK_COLLECTION.put(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967), "Номер полки 34");

        librarySystem.addBook("Тихий Дон", "Михаил Шолохов", 1940, "Номер полки 66");
        librarySystem.removeBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
        librarySystem.removeBook("Маст и Маргар", "Мих Булгв", 19);
        librarySystem.findBook("Осень патриарха", "Габриэль Гарсиа", 1975);
        librarySystem.findBook("сень патриарха", "Габриэль Гарсиа", 1975);
        librarySystem.printAllBooks();
    }
}
