package school.faang.BJS233103;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<Book, String> BOOKS = new HashMap<>();

    public static void addBook(String title, String author, int year) {
        String place = generatePlace();
        Book newBook = new Book(title, author, year);
        BOOKS.put(newBook, place);
        System.out.println("ADDED " + newBook);
    }

    public static void deleteBookByTitle(String title, String author, int year) {
        Book removeBook = new Book(title, author, year);
        BOOKS.remove(removeBook);
        System.out.println("DELETED " + removeBook);
    }

    public static void findBook(String title, String author, int year) {
        Book findBook = new Book(title, author, year);
        for (Book book : BOOKS.keySet()) {
            if (book.equals(findBook)) {
                System.out.println("FOUNDED " + book + " Place: " + BOOKS.get(book));
            }
        }
    }

    public static void getBooks() {
        for (Map.Entry<Book, String> entry : BOOKS.entrySet()) {
            System.out.println(entry.getKey() + " Place: " + entry.getValue());
        }
    }

    public static String generatePlace() {
        char letter = (char) ((Math.random() * 25) + 65);
        int number = (int) (Math.random() * 20);
        return String.valueOf(letter) + number;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Думай и богатей", "Наполеон Хилл", 1937));
        books.add(new Book("Алхимик", "Пауло Коэльо", 1988));
        books.add(new Book("Осень в карманах", "Андрей Аствацатуров", 2015));
        books.add(new Book("Светила", "Элеанор Каттон", 2020));

        for (Book book : books) {
            BOOKS.put(book, generatePlace());
        }
        getBooks();
        addBook("New Age", "Christian Something", 2019);
        deleteBookByTitle("Светила", "Элеанор Каттон", 2020);
        findBook("Думай и богатей", "Наполеон Хилл", 1937);
        getBooks();
    }

}
