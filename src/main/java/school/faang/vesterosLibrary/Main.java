package school.faang.vesterosLibrary;

import java.util.HashMap;

public class Main {
    private static final HashMap<Book, String> library = new HashMap<>();

    private static void addBook(Book book, String location) {
        library.put(book, location);
    }

    private static void deleteBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        library.remove(bookToRemove);
    }

    private static void findBookLocation(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        System.out.println(library.get(bookToFind));
    }

    private static void getAllBooks() {
        library.forEach((book, s) -> System.out.println(book + ":" + s));
    }

    public static void main(String[] args) {
        Book book1 = new Book("Math", "Abzalkhan", 2000);
        Book book2 = new Book("Biology", "Nural", 2015);
        Book book3 = new Book("Physics", "Aida", 2009);
        Book book4 = new Book("Chemistry", "Olzhas", 2025);
        Book book5 = new Book("ICT", "Sanzhar", 2019);
        library.put(book1, "A1");
        library.put(book2, "A2");
        library.put(book3, "A3");
        library.put(book4, "A4");
        library.put(book5, "A5");

        Book book6 = new Book("Physical Culture", "Dame", 2019);
        addBook(book6, "A6");
        getAllBooks();

        deleteBook("Physical Culture", "Dame", 2019);
        getAllBooks();

        findBookLocation("Biology", "Nural", 2015);
    }
}
