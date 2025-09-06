package school.faang;

import school.faang.bsj2_86086.Book;
import school.faang.bsj2_86086.LibrarySystem;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Book1", "Author1", 2000, "1-78");
        librarySystem.addBook("Book2", "Author2", 2001, "1-89");
        librarySystem.addBook("Book3", "Author3", 2002, "1-100");
        librarySystem.addBook("Book4", "Author4", 2003, "1-111");
        librarySystem.addBook("Book5", "Author5", 2004, "1-122");
        librarySystem.addBook("Book6", "Author6", 2005, "1-133");
        librarySystem.addBook("Book7", "Author7", 2006, "1-144");
        librarySystem.addBook("Book8", "Author8", 2007, "1-155");
        librarySystem.addBook("Book9", "Author9", 2008, "1-166");
        librarySystem.addBook("Book10", "Author10", 2009, "1-177");

        librarySystem.printAllBooks();
        System.out.println("");

        librarySystem.removeBook("Book9", "Author9", 2008);
        librarySystem.printAllBooks();
        System.out.println("");

        librarySystem.removeBook("Book0", "Author0", 1999);
        librarySystem.printAllBooks();
        System.out.println("");

        Book book;
        String location;

        book = new Book("Book1", "Author1", 2000);
        location = librarySystem.findBook(book.getTitle(), book.getAuthor(), book.getYear());
        System.out.println(book + " Локация: " + location);

        book = new Book("Book9", "Author9", 2008);
        location = librarySystem.findBook(book.getTitle(), book.getAuthor(), book.getYear());
        System.out.println(book + " Локация: " + location);

        book = new Book("Book8", "Author8", 2008);
        location = librarySystem.findBook(book.getTitle(), book.getAuthor(), book.getYear());
        System.out.println(book + " Локация: " + location);

        book = new Book("Book3", "Author4", 2002);
        location = librarySystem.findBook(book.getTitle(), book.getAuthor(), book.getYear());
        System.out.println(book + " Локация: " + location);

        book = new Book("Book5", "Author4", 2003);
        location = librarySystem.findBook(book.getTitle(), book.getAuthor(), book.getYear());
        System.out.println(book + " Локация: " + location);
    }
}

