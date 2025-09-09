package school.faang.bjs2_86114;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LibrarySystem {
    private HashMap<Book, String> locationBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        locationBook.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookRemove = new Book(title, author, year);
        if (Objects.isNull(locationBook.remove(bookRemove))) {
            System.out.println("No such book has been found.");
        } else {
            System.out.println("The book was removed from the library");
        }
    }

    public void findBook(String title, String author, int year) {
        String location = locationBook.get(new Book(title, author, year));
        if (Objects.isNull(location)) {
            System.out.println("The book was not found!! Please specify the data!!");
        } else {
            System.out.printf("Your book is located at %s \n", location);
        }
    }

    public void printAllBook() {
        for (Map.Entry<Book, String> entry : locationBook.entrySet()) {
            System.out.print(entry.getKey().toString());
            System.out.println("location:" + entry.getKey().toString());
        }
    }
}