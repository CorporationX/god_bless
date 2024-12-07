package school.faang.task_45316;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final HashMap<Book, String> theLocationOfTheBook;

    public LibrarySystem(HashMap<Book, String> theLocationOfTheBook) {
        this.theLocationOfTheBook = theLocationOfTheBook;
    }

    public void addBook(String title, String author, int year, String location) {
        Book bookToAdd = new Book(title, author, year);

        if (!theLocationOfTheBook.containsKey(bookToAdd)) {
            theLocationOfTheBook.put(bookToAdd, location);
            System.out.println(bookToAdd + " add !!!\n");
        } else {
            System.out.println("This book already exists!!!\n");
        }

    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);

        if (theLocationOfTheBook.remove(bookToRemove) != null) {
            System.out.println(bookToRemove + " remove !!!\n");
        } else {
            System.out.println(bookToRemove + " don't find !!!\n");
        }
    }

    public void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);

        if (theLocationOfTheBook.get(bookToFind) != null) {
            System.out.println(bookToFind + " is located: " + theLocationOfTheBook.get(bookToFind) + "!!!\n");
            return;
        }
        System.out.println(bookToFind + " don't find !!!\n");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> pair : theLocationOfTheBook.entrySet()) {
            String location = pair.getValue();
            Book key = pair.getKey();
            System.out.println(key + ": " + location);
        }
        System.out.println();
    }
}
