package school.faang.task_45356;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();

        Book first = new Book("Bunin", "Human", 1948);
        Book second = new Book("Akunin", "Gambit", 1999);
        Book third = new Book("Borisov", "Life", 2005);

        library.put(first, "12");
        library.put(second, "8");
        library.put(third, "123");

    }
}
