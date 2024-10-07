package school.faang.library_of_westeros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book firstBook = new Book("Clean code", "Robert Martin", 2008);
        Book secondBook = new Book("High Load Applications", "Martin Klepman", 2018);
        library.put(firstBook, "first Place");
        library.put(secondBook, "second Place");

        Book newBook = new Book("Ok", "Maks russ", 2024);
        addBook(newBook, "third");
        findBookInLibrary("Ok", "Maks russ", 2024);
    }

    public static void addBook(Book book, String place) {
        library.put(book, place);
    }

    public static void removeBookFromLibrary(String title, String author, int year) {
        Book book = new Book(title, author, year);
        library.remove(book);
    }

    public static void findBookInLibrary(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String placeOfBook = library.get(book);
        System.out.println(placeOfBook);
    }

    public static void showLibrary() {
        for (Map.Entry<Book, String> tokenBook : library.entrySet()) {
            Book book = tokenBook.getKey();
            String place = tokenBook.getValue();
            System.out.println("книга: " + book.getTitle() + ", автор: " + book.getAuthor() + ", год издания: "
                    + book.getYear() + ". Находится на: " + place);
        }
    }
}
