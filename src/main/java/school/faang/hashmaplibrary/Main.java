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

    public static void getShelf(Book book) {
        String valueResult = catalogue.get(book);

        if (valueResult == null) {
            System.out.println(book + " not exist!");
        } else {
            System.out.println(book + " is on " + valueResult);
        }
    }

    public static void deleteBookFromCatalogue(Book book) {
        catalogue.remove(book);
    }

    public static void printCatalogue() {
        int num = 1;
        for (Map.Entry<Book, String> entry : catalogue.entrySet()) {
            System.out.println(num + " " + entry.getKey() + " is on " + entry.getValue());
            num++;
        }
    }
}
