package faang.school.godbless.BJS2_19315;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Book, String> books = new HashMap<Book, String>();

    public static void main(String[] args) {


        books.put(new Book("The Echoes of Tomorrow", "Emily Harrington", 2021), "21c");
        books.put(new Book("Beneath the Starlit Veil", "Marcus Eldridge", 2018), "48a");
        books.put(new Book("Whispers in the Wind", "Clara Thompson", 2015), "5h");
        books.put(new Book("Fragments of a Forgotten Past", "James Wellington", 2023), "153g");
        books.put(new Book("The Clockwork Alchemist", "Lydia Grayson", 2020), "156g");

        System.out.println(findBook("Beneath the Starlit Veil", "Marcus Eldridge", 2018));

        deleteBook("Beneath the Starlit Veil", "Marcus Eldridge", 2018);

        System.out.println(findBook("Beneath the Starlit Veil", "Marcus Eldridge", 2018));


        addBook(new Book("Beneath the Starlit Veil", "Marcus Eldridge", 2018), "321g");

        System.out.println(findBook("Beneath the Starlit Veil", "Marcus Eldridge", 2018));


    }

    public static void addBook(Book book, String place) {
        books.put(book, place);
    }

    public static void deleteBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public static String findBook(String title, String author, int year) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().equals(new Book(title, author, year))) {
                return title + "\t" + author + "\t" + year + "\t" + entry.getValue();
            }
        }
        return "Book not found";
    }
}
