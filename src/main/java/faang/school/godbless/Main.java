package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();

        books.put(new Book("A Game of Thrones", "George R.R. Martin", 1996), "42A");
        books.put(new Book("The Hedge Knight", "George R.R. Martin", 1998), "3B");
        books.put(new Book("The Sworn Sword", "George R.R. Martin", 2003), "22G");

        Book.printAllBooks(books);
        System.out.println("_____________________________");


        Book.addNewBook(books, "The Princess and the Queen", "George R.R. Martin", 2013, "666B");
        System.out.println("_____________________________");

        Book.findBookByTitle(books, "The Hedge Knight");
        System.out.println("_____________________________");

        Book.findBookByAuthor(books, "George R.R. Martin");

        System.out.println("_____________________________");

        Book.findBookByYear(books, 2003);
        System.out.println("_____________________________");

        Book.deleteBookByTitle(books, "The Sworn Sword");
        System.out.println("_____________________________");
        Book.printAllBooks(books);

        System.out.println("_____________________________");
    }


}
