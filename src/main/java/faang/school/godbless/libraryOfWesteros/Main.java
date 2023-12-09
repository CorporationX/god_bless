package faang.school.godbless.libraryOfWesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> library;

    public static void main(String[] args) {

        library = new HashMap<>();
        Main.addBook(new Book("Том Сойер", "Марк Твен", 2020), "10-1");
        Main.addBook(new Book("Гекльберри Финн", "Марк Твен", 2022), "11-1");
        Main.addBook(new Book("Том Сойер - сыщик", "Марк Твен", 2017), "10-2");
        Main.showAllBook();
        Main.removeBook("Том Сойер", "Марк Твен", 2020);
        System.out.println();
        Main.showAllBook();
        System.out.println();
        System.out.println(Main.findBy("Гекльберри Финн", "Марк Твен", 2022));
    }

    private static String findBy(String bookName, String author, int year) {
        return library.get(new Book(bookName, author, year));
    }

    private static void removeBook(String bookName, String author, int year) {
        library.remove(new Book(bookName, author, year));
    }

    private static void showAllBook() {
        for (Map.Entry<Book, String> book : library.entrySet()) {
            System.out.println(book);
        }
    }

    private static void addBook(Book book, String location) {
        library.put(book, location);
    }
}