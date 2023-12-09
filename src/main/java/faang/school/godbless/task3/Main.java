package faang.school.godbless.task3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();

        Book crimeAndPunishment = new Book("Crime and punishment", "F.Dostoevskii", 1866);
        Book prideAndPrejudice = new Book("Pride and Prejudice", "D. Ostin", 1813);
        Book transformation = new Book("Transformation", "F.Kafka", 1912);
        Book pictureOfDorianGray = new Book(" The Picture of Dorian Gray", "O. Wilde", 1890);

        books.put(crimeAndPunishment, "C-P");
        books.put(prideAndPrejudice, "P-P");
        books.put(pictureOfDorianGray, "P-D");

        Book.showInfo(books);
        Book.addBook(books, transformation, "y");
        Book.showInfo(books);
        System.out.println("________RAZDELITEL'__________");
        Book.findBook(books, "y");
        Book.findBook(books, "D. Ostin");
        Book.findBook(books, 1890);
        Book.removeBook(books, "Crime and punishment", "F.Dostoevskii", 1866);
        Book.showInfo(books);
    }
}
