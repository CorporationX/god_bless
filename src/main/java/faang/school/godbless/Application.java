package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Application {

    static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("God Bless!");

        Book book1 = new Book("Math", "Nuthon", 1698);
        Book book2 = new Book("History", "Morua", 1934);
        Book book3 = new Book("Manifest", "VKPb", 1934);
        Book book4 = new Book("Bizan", "Sophia", 1698);
        Book book5 = new Book("Alchimia", "Pascal", 1789);

        addBook(book1, "1");
        addBook(book2, "1");
        addBook(book3, "2");
        addBook(book4, "3");
        addBook(book5, "3");

        allLibrary();

        System.out.println();

        researchBook("Math", "Nuthon", 1698);
        researchBook( "Manifest", "VKPb", 1934);

        delBook("Bizan", "Sophia", 1698);

        System.out.println();

        allLibrary();
    }


    public static void addBook(Book book, String number) {
        library.put(book, number);
    }

    public static void delBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static void researchBook(String title, String author, int year) {
        for (Map.Entry<Book, String> pair : library.entrySet()) {
            if (pair.getKey().getTitle().equals(title)) {
                System.out.println("Книга на полке под номером: " + library.get(pair.getKey()));
            }
        }

    }

    public static void allLibrary() {
        for (Map.Entry<Book, String> pair : library.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

}