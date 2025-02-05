package school.faang.task_56952;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static Map<Book, String> library = new HashMap<>();

    static {
        library.put(new Book("It", "Steven King", 1986), "Shelf1");
        library.put(new Book("The withcer", "Andrzej Sapkowski", 1990), "Shelf2");
    }

    public void addBook(String title, String author, int year, String location) {
        for (var entry : library.entrySet()) {
            var key = entry.getKey();
            if (key.getTitle().equals(title) && key.getAuthor().equals(title)) {
                throw new IllegalArgumentException("This book is already in the library");
            } else {
                library.put(new Book(title, author, year), location);
                System.out.println("The book has been added to the library");
            }
        }
    }

    public void removeBook(String title, String author, int year) {
        for (var entry : library.entrySet()) {
            var key = entry.getKey();
            if (key.getTitle().equals(title) && key.getAuthor().equals(author)) {
                library.remove(key, entry.getValue());
                System.out.println("The book has been removed from the library");
            }
        }
    }

    public void findBook(String title, String author, int year) {
        for (var entry : library.entrySet()) {
            var key = entry.getKey();
            if (key.getTitle().equals(title) && key.getAuthor().equals(author)) {
                System.out.printf("Title: %s \nAuthor: %s \nYear: %d \nLocation: %s\n",
                        key.getTitle(), key.getAuthor(), key.getYear(), entry.getValue());
            }
        }
    }

    public void printAllBooks() {
        for (var entry : library.entrySet()) {
            var key = entry.getKey();
            System.out.printf("Title: %s \nAuthor: %s \nYear: %d \n Location: %s\n",
                    key.getTitle(), key.getAuthor(), key.getYear(), entry.getValue());
            System.out.println();
        }
    }
}
