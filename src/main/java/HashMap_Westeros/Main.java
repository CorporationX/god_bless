package HashMap_Westeros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        library.put(new Book("1984", "George Orwell", 1949), "29");
        library.put(new Book("Pride and Prejudice", "Jane Austen", 1813), "45");
        library.put(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1851), "13");
        library.put(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1851), "25");
        library.put(new Book("Moby-Dick", "Herman Melville", 1851), "25");

        library.remove(new Book("1984", "George Orwell", 1949));

        String cellNumber1 = library.get(new Book("Pride and Prejudice", "Jane Austen", 1813));
        System.out.println(cellNumber1);

        String cellNumber2 = library.get(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1851));
        System.out.println(cellNumber2);

        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey().getInfo() + " " + entry.getValue());
        }
    }
}
