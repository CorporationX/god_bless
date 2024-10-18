package libraryOfWesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> libraryMap = new HashMap<>();

        Book.addBook(libraryMap, new Book("Bridget Jones's Diary", "Helen Fielding", 1996), "Shelf A");
        Book.addBook(libraryMap, new Book("Charlotte's Web", "E.B. White", 1926), "Shelf B");
        Book.addBook(libraryMap, new Book("Alice in Wonderland", "Lewis Carroll", 1865), "Shelf C");
        Book.addBook(libraryMap, new Book("The Murder of Roger Ackroyd", "Agatha Christie", 1926), "Shelf A");


        Book.printMap(libraryMap);
        Book.removeBook(libraryMap, "Bridget Jones's Diary", "Helen Fielding", 1996);

        System.out.println();
        Book.printMap(libraryMap);

        System.out.println();
        Book.findBook(libraryMap, "The Murder of Roger Ackroyd", "Agatha Christie", 1926);
        Book.findBook(libraryMap, "Winnie-the-Pooh", "A.A. Milne", 1926);

    }
}
