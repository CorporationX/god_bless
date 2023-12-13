package LibraryOfWesterosse;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Main.addBook(new Book("Make It Stick", "Henry L.", 2014), "ThirdLine");
        Main.addBook(new Book("Scientific Materialism", "Torwald Olafsen", 2021), "FourLine");
        Main.addBook(new Book("Visual Intelligence", "Amy Herman", 2016), "ThirdLine");

        System.out.println(findBookByName("Make It Stick"));
        System.out.println(findBookByAuthor("Henry L."));
        System.out.println(findBookByYear(2014));

        Main.findAllBooks();

        Main.removeBookByName("Make It Stick");
        Main.removeBookByAuthor("Amy Herman");
        removeBookByYear(2016);

        Main.findAllBooks();
    }

    public static void addBook(Book book, String bookLocation) {
        library.put(book, bookLocation);
    }

    public static void removeBookByName(String bookName) {
        Book foundBook = null;
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            if (entry.getKey().getTitle().equals(bookName)) {
                foundBook = entry.getKey();
                break;
            }
        }
        library.remove(foundBook);
    }

    public static void removeBookByAuthor(String authorName) {
        Book foundBook = null;
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            if (entry.getKey().getAuthor().equals(authorName)) {
                foundBook = entry.getKey();
                break;
            }
        }
        library.remove(foundBook);
    }


    public static void removeBookByYear(Integer year) {
        Book foundBook = null;
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            if (entry.getKey().getYear() == year) {
                foundBook = entry.getKey();
                break;
            }
        }
        library.remove(foundBook);
    }


    public static String findBookByName(String bookName) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            if (entry.getKey().getTitle().equals(bookName)) {
                return entry.getValue();
            }
        }
        return "Not found";
    }

    public static String findBookByAuthor(String author) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            if (entry.getKey().getAuthor().equals(author)) {
                return entry.getValue();
            }
        }
        return "Not found";
    }

    public static String findBookByYear(Integer year) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            if (entry.getKey().getYear() == year) {
                return entry.getValue();
            }
        }
        return "Not found";
    }

    public static void findAllBooks() {
        library.forEach((book, location) -> {
            System.out.println(book.toString() + " " + location);
        });
    }
}
