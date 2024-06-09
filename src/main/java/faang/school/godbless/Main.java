package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();

        books.put(new Book("A Game of Thrones", "George R.R. Martin", 1996), "42A");
        books.put(new Book("The Hedge Knight", "George R.R. Martin", 1998), "3B");
        books.put(new Book("The Sworn Sword", "George R.R. Martin", 2003), "22G");

        printAllBooks(books);
        System.out.println("_____________________________");


        addNewBook(books,"The Princess and the Queen","George R.R. Martin",2013,"666B");
        System.out.println("_____________________________");

        findBookByTitle(books,"The Hedge Knight");
        System.out.println("_____________________________");

        findBookByAuthor(books,"George R.R. Martin");

        System.out.println("_____________________________");

        findBookByYear(books,2003);
        System.out.println("_____________________________");

        deleteBookByTitle(books,"The Sworn Sword");
        System.out.println("_____________________________");
        printAllBooks(books);

        System.out.println("_____________________________");
    }

    private static void addNewBook(Map<Book, String> books, String title, String author, int year, String place) {
        books.put(new Book(title, author, year), place);
        System.out.println("The book has been added to place " + place);
    }

    private static void deleteBookByTitle(Map<Book, String> books, String title) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getTitle().equals(title)) {
                books.remove(entry.getKey());
                System.out.println("The book was successfully deleted");
            }
        }
    }

    private static void deleteBookByAuthor(Map<Book, String> books, String author) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getAuthor().equals(author)) {
                books.remove(entry.getKey());
                System.out.println("The book was successfully deleted");
            }
        }
    }

    private static void deleteBookByYear(Map<Book, String> books, int year) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getYear() == year) {
                books.remove(entry.getKey());
                System.out.println("The book was successfully deleted");
            }
        }
    }

    private static void printAllBooks(Map<Book, String> books) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println("Title: " + entry.getKey().getTitle() + " | Author: " + entry.getKey().getAuthor() +
                    " | Year: " + entry.getKey().getYear() + " | Place: " + entry.getValue());
        }
    }

    private static void findBookByTitle(Map<Book, String> books, String title) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getTitle().equals(title)) {
                System.out.println("Title: " + entry.getKey().getTitle() + " | Author: " + entry.getKey().getAuthor() +
                        " | Year: " + entry.getKey().getYear() + " | Place: " + entry.getValue());
            }
        }
    }

    private static void findBookByAuthor(Map<Book, String> books, String author) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getAuthor().equals(author)) {
                System.out.println("Title: " + entry.getKey().getTitle() + " | Author: " + entry.getKey().getAuthor() +
                        " | Year: " + entry.getKey().getYear() + " | Place: " + entry.getValue());
            }
        }
    }

    private static void findBookByYear(Map<Book, String> books, int year) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getYear() == year) {
                System.out.println("Title: " + entry.getKey().getTitle() + " | Author: " + entry.getKey().getAuthor() +
                        " | Year: " + entry.getKey().getYear() + " | Place: " + entry.getValue());
            }
        }
    }

}
