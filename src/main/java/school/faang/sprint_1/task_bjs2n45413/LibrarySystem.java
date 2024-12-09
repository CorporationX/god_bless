package school.faang.sprint_1.task_bjs2n45413;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookStringMap;

    public LibrarySystem(Map<Book, String> bookStringMap) {
        this.bookStringMap = bookStringMap;
    }

    public LibrarySystem() {
        this.bookStringMap = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        try {
            this.bookStringMap.put(new Book(title, author, year), location);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    public void removeBook(String title, String author, int year) {
        try {
            this.bookStringMap.remove(new Book(title, author, year));
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    public void findBook(String title, String author, int year) {
        try {
            Book book = new Book(title, author, year);
            if (this.bookStringMap.containsKey(book)) {
                System.out.printf("Book \"%s\" %s %s ---> %s\n", title, author, year, bookStringMap.get(book));
            } else {
                System.out.printf("Book \"%s\" %s %s is not found \n", title, author, year);
            }
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : bookStringMap.entrySet()) {
            System.out.println(book);
        }
    }
}
