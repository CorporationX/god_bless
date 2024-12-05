package school.faang.sprint1.task_45309;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class LibrarySystem {
    private HashMap<Book, String> books = new HashMap<>();

    public LibrarySystem(HashMap<Book, String> map) {
        this.books = map;
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public void findBook(String title, String author, int year) {
        String location = books.get(new Book(title, author, year));
        if (location != null) {
            System.out.println(location);
        } else {
            System.out.println("book not found");
        }
    }

    public void printAllBooks() {
        System.out.println("----- BOOKS -----");
        for (Map.Entry<Book, String> book : books.entrySet()) {
            System.out.printf(
                    "%s is on %s location \n",
                    book.getKey().getTitle(),
                    book.getValue()
            );
        }
    }
}
