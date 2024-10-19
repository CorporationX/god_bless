package school.faang.hashmaplibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> catalogue = new HashMap<Book, String>();

    public static void main(String[] args) {
        catalogue.put(new Book("Robinson Crusoe", "Daniel Deffo", 1719), "shelf 12");
        catalogue.put(new Book("Jane Air", "Charlotta Bronte", 1847), "shelf 10");
        catalogue.put(new Book("David Copperfield", "Charles Dickens", 1850), "shelf 4");

    }

    public static void addBookToCatalogue(Book book, int numShelf) {
        catalogue.put(book, "shelf " + numShelf);
    }

    public static void getShelf(String title, String author, int year) {
        Book searchBook = new Book (title, author, year);
        String valueResult = catalogue.get(searchBook);

        if (valueResult == null) {
            System.out.println(searchBook + " not exist!");
        } else {
            System.out.println(searchBook + " is on " + valueResult);
        }
    }

    public static void deleteBookFromCatalogue(String title, String author, int year) {
        catalogue.remove(new Book (title, author, year));
    }

    public static void printCatalogue() {
        int num = 1;
        for (Map.Entry<Book, String> entry : catalogue.entrySet()) {
            System.out.println(num + " " + entry.getKey() + " is on " + entry.getValue());
            num++;
        }
    }
}
