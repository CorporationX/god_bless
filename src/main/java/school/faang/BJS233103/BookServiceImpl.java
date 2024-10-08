package school.faang.BJS233103;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BookServiceImpl implements BookService {
    private final Map<Book, String> books = new HashMap<>();


    public void addBook(String title, String author, int year) {
        String place = generatePlace();
        Book newBook = new Book(title, author, year);
        books.put(newBook, place);
        System.out.println("ADDED " + newBook);
    }

    public void deleteBookByTitle(String title, String author, int year) {
        Book removeBook = new Book(title, author, year);
        books.remove(removeBook);
        System.out.println("DELETED " + removeBook);
    }

    public void findBook(String title, String author, int year) {
        Book findBook = new Book(title, author, year);
        System.out.println("FOUNDED " + findBook + " Place: " + books.get(findBook));
    }

    public void printBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " Place: " + entry.getValue());
        }
    }

    public String generatePlace() {
        char letter = (char) ((Math.random() * 25) + 65);
        int number = (int) (Math.random() * 20);
        return String.valueOf(letter) + number;
    }
}
