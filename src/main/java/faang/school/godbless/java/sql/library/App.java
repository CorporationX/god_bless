package faang.school.godbless.java.sql.library;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<Book, String> libraryMap = new HashMap<>();
        Book book1 = new Book("Voina i mir", "Lev Tolstoi", 1869);
        Book book2 = new Book("Prestuplenie i nakazanie", "Fedor Dostoevskii", 1866);
        Book book3 = new Book("Master i Margarita", "Mihail Bulgakov", 1967);

        libraryMap.put(book1, "shelf_2");
        libraryMap.put(book2, "shelf_4");
        libraryMap.put(book3, "shelf_7");
        addBookToLibrary(libraryMap, "shelf_7", "Master i Margarita", "Mihail Bulgakov", 1968);
        removeBookFromLibrary(libraryMap, "Master i Margarita", "Mihail Bulgakov", 19678);
        findBookInLibrary(libraryMap, "Master i Margarita", "Mihail Bulgakov", 1968);
        showAllBooksInLibrary(libraryMap);
    }

    public static void addBookToLibrary(Map<Book, String> libraryMap, String shelf, String title, String author, int year) {
        libraryMap.put(new Book(title, author, year), shelf);
    }

    public static void removeBookFromLibrary(Map<Book, String> libraryMap, String title, String author, int year) {
        String shelf = libraryMap.remove(new Book(title, author, year));
        if (shelf != null) {
            System.out.println("The book \"" + title + "\" has been removed from library");
        } else {
            System.out.println("No such book \"" + title + "\" was found");
        }
    }

    public static void findBookInLibrary(Map<Book, String> libraryMap, String title, String author, int year) {
        String shelf = libraryMap.get(new Book(title, author, year));
        if (shelf != null) {
            System.out.println("The book \"" + title + "\" on the bookshelf: " + shelf);
        } else {
            System.out.println("No such book \"" + title + "\" was found");
        }
    }

    public static void showAllBooksInLibrary(Map<Book, String> libraryMap) {
        for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
            System.out.printf("The book \"%s\", author \"%s\" (year %d) is on the bookshelf - %s%n",
                    entry.getKey().getTitle(), entry.getKey().getAuthor(), entry.getKey().getYear(), entry.getValue());
        }
    }
}
