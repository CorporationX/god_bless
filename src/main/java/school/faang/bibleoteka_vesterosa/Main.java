package school.faang.bibleoteka_vesterosa;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOKS_ON_SHELVES = new HashMap<>();

    public static void main(String[] args) {


        Book harryPotter = new Book("Harry Potter", "Rowling", 1997);
        Book gameOfThrones = new Book("Game of Thrones", "Martin", 1996);
        Book denskinyRasskazy = new Book("Deniskiny Rasskazy", "Dragunskiy", 1959);
        Book neznaika = new Book("Neznaika", "Nosov", 1953);
        Book lesMiserables = new Book("Les Miserables", "Hugo", 1862);

        BOOKS_ON_SHELVES.put(harryPotter, "English Shelf");
        BOOKS_ON_SHELVES.put(lesMiserables, "French Shelf");
        addBook(denskinyRasskazy, "Russian Shelf");
        addBook(gameOfThrones, "English Shelf");
        addBook(neznaika, "Russian Shelf");
        printAllInfo();
        System.out.println("----------------------------------------");
        deleteBook("Game of Thrones", "Martin", 1996);
        System.out.println("----------------------------------------");
        printAllInfo();
        System.out.println("----------------------------------------");
        findShelf("Harry Potter", "Rowling", 1997);

    }

    public static void addBook(Book book, String shelf) {
        BOOKS_ON_SHELVES.put(book, shelf);
    }

    public static void deleteBook(String title, String author, int year) {
        Book bookForRemoval = new Book(title, author, year);
        BOOKS_ON_SHELVES.remove(bookForRemoval);
        System.out.println("Book " + bookForRemoval + " was removed.");
    }

    public static void findShelf(String title, String author, int year) {
        System.out.println("This book is on: " + BOOKS_ON_SHELVES.get(new Book(title, author, year)));
    }

    public static void printAllInfo() {
        for (Map.Entry<Book, String> book : BOOKS_ON_SHELVES.entrySet()) {
            System.out.println(book.getKey() + " on " + book.getValue());
        }
    }
}
