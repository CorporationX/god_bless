package school.faang.lib_of_westeros;

import java.util.HashMap;

public class Main {
    static HashMap<Book, String> books = new HashMap<>() ;

    public static void main(String[] args) {
        books.put(new Book("Lost Wisdom", "Varg Vikernes", 1991), "Second shelf");
        books.put(new Book("Eternal life", "Øystein Aarseth", 1993), "Second shelf");
        books.put(new Book("Freezing Moon", "Øystein Aarseth", 1993), "Third shelf");



        addBook("Freezing Moon", "Øystein Aarseth", 1993,"Second shelf",books );
        addBook("Freezing Moon", "Øystein Aarseth", 1999,"Second shelf",books );

        findBook("Lost Wisdom", "Varg Vikernes", 1991);

        deleteBook("Eternal life", "Øystein Aarseth", 1993);

        showAllBooksOnShelf("Third shelf");

        showAllBooks();
    }

    private static void addBook(String title, String author, int year, String shelf, HashMap<Book, String> books) {
        if (title == null || author == null || year == 0 || shelf == null) {
            System.out.println("Invalid arguments");
        }
        if (findBook(title,author,year) != null) {
            System.out.println("Book \"" + title + "\", by " + author + " (" + year + ") already exists");
        } else {
            Book book = new Book(title, author, year);
            books.put(book, shelf);
            System.out.println("Book \"" + title + "\", by " + author + " (" + year + ") succesfully added");
        }
    }


    private static Book findBook(String title, String author, int year) {
        Book seeking = new Book(title, author, year);
        String shelf = books.get(seeking);

        if (shelf == null || shelf.isEmpty()){
            System.out.println("Book \"" + title + "\", by " + author + " (" + year + ") not found");
            return null;
        } else {
            System.out.println("Book \"" + title + "\", by " + author + " (" + year + ") succesfully found on " + shelf);
            return seeking;
        }
    }

    public static void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found");
        } else {
            books.forEach((book, shelf) -> {
                System.out.println(book.toString() + " " + shelf);
            });
        }
    }

    private static void deleteBook(String title, String author, int year) {
        books.remove(findBook(title, author, year));
        System.out.println("Book  \"" + title + "\", by " + author + " (" + year + ") succesfully deleted");
    }

    //additional
    private static void showAllBooksOnShelf(String shelf) {
        if (shelf == null || shelf.isEmpty()) {
            System.out.println("Shelf not found");
        } else {
            books.forEach((book, shelfBook) -> {
                System.out.println("Book " + book.toString() + " succesfully found on " + shelf);
            });
        }
    }
}