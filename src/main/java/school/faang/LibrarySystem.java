package school.faang;

import java.util.HashMap;

public class LibrarySystem {
    public HashMap<Book, String> bookMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookMap.put(book, location);
    }

    public void addBook(Book book, String location) {
        bookMap.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        bookMap.remove(new Book(title, author, year));
    }

    public void removeBook(Book book) {
        bookMap.remove(book);
    }

    public void findBook(String title, String author, int year) {
        for (HashMap.Entry<Book, String> book : bookMap.entrySet()) {
            if(book.getKey().equals(new Book(title,author,year))){
                System.out.println("The location of this book is " + book.getValue() + ".");
            }
        }
    }

    public void findBook(Book book) {
        for (HashMap.Entry<Book, String> entry : bookMap.entrySet()) {
            if(entry.getKey().equals(book)){
                System.out.println("The location of this book is " + entry.getValue() + ".");
            }
        }
    }

    public void printAllBooks() {
        for (HashMap.Entry<Book, String> book : bookMap.entrySet()) {
            System.out.println("The book: " + book.getKey() + " is located in: " + book.getValue() + ".");
        }
    }
}
