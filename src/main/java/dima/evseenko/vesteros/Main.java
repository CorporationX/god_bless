package dima.evseenko.vesteros;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        getBooks().forEach(lib::addBook);

        lib.printBooks();

        System.out.println();

        lib.addBook(new Book("Title5", "Author5", 1999), "5 полка");

        lib.printBooks();

        System.out.println();

        System.out.println(lib.findBook("Title2", "Author2", 2001));

        lib.deleteBook("Title1", "Author1", 2000);

        lib.printBooks();
    }

    private static Map<Book, String> getBooks(){
        return Map.of(
                new Book("Title1", "Author1", 2000), "1 полка",
                new Book("Title2", "Author2", 2001), "2 полка",
                new Book("Title3", "Author3", 2002), "3 полка",
                new Book("Title4", "Author4", 2003), "4 полка"
        );
    }
}
