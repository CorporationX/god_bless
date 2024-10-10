package LibraryOfWesteros_BJS2_33119;

import java.util.Map;
import java.util.HashMap;

public class Main {
    private static HashMap<Book, String> library = new HashMap<>();

    // method of adding book to library
    public void addBook(Book book, String shelf) {
        library.put(book, shelf);

    }

    // method of deleting book by (title, name, year)
    public void deleteBook(String title, String author, int year) {
        Book bookForRemove = new Book(title, author, year);

        if (library.containsKey(bookForRemove)) {
            library.remove(bookForRemove);
            System.out.println("Book removed from library");
        } else {
            System.out.println("Book doesn't exist in library");
        }
    }
    // method of seaching postion of book in library;

    public void searchBook(String title, String author, int year) {
        Book bookToSearch = new Book(title, author, year);
        if (library.containsKey(bookToSearch)) {
            String location = library.get(bookToSearch);
            System.out.println("Book is found on the " + location);}
         else {
            System.out.println("Book doesn't exist in library");

        }
    }
    //  output all books, what we have in library

    public void listOfBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Main library1 = new Main();

        Book book1 = new Book("Theory of Economic", "Kayn", 1901);
        Book book2 = new Book("Investing", "Baffet", 2003);
        Book book3 = new Book("Princypes", "Ricardo", 1975);

        library1.addBook(book1, "Shelf 3");
        library1.addBook(book2, "Shelf 5");
        library1.addBook(book3, "Shelf 7");

        library1.listOfBooks();

        library1.searchBook("Princypes", "Ricardo", 1975);

        library1.deleteBook("Theory of Economic", "Kayn", 1901);


    }
}
