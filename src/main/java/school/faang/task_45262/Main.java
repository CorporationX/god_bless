package school.faang.task_45262;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<Book, String> books = new HashMap<>();
        books.put(new Book("TestBook1", "Maximilian", 1999), "5");
        books.put(new Book("TestBook2", "Blob", 1990), "4");
        books.put(new Book("TestBook3", "Bob", 1980), "3");

        LibrarySystem librarySystem = new LibrarySystem(books);

        Book newBook = new Book("TestBook4", "Bob", 1994);
        librarySystem.addBook(newBook, "2");

        String bookPosition = librarySystem.findBook("TestBook4", "Bob", 1994);
        System.out.println(bookPosition);

        String nonExistedBookPosition = librarySystem.findBook("NonExistedBook", "Bob", 1994);
        System.out.println(nonExistedBookPosition);
        
        librarySystem.printAllBooks();
        System.out.println("removing book...");
        librarySystem.removeBook("TestBook4", "Bob", 1994);
        librarySystem.printAllBooks();
    }

}
