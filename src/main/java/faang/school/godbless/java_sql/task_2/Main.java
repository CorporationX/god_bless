package faang.school.godbless.java_sql.task_2;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Book, String> booksLocation = new HashMap<>();
        var firstBook = new Book("Метро 2033", "Дмитрий Глуховский", "2005");
        var secondBook = new Book("Ревизор", "Николай Гоголь", "1836");
        var thirdBook = new Book("R.U.R.", "Карел Чапек", "1920");
        addBook(booksLocation, firstBook, "Полка 10");
        addBook(booksLocation, secondBook, "Полка 6");
        addBook(booksLocation, thirdBook, "Полка 4");
        printAllBooksAndTheirLocation(booksLocation);
        System.out.println("----------------------------");
        deleteBook(booksLocation, secondBook);
        printAllBooksAndTheirLocation(booksLocation);
        System.out.println("----------------------------");
        printBookLocation(booksLocation, firstBook);
    }

    static void addBook(HashMap<Book, String> booksLocation, Book book, String bookLocation) {
        booksLocation.put(book, bookLocation);
    }

    static void deleteBook(HashMap<Book, String> booksLocation, Book book) {
        booksLocation.remove(book);
    }

    static void printBookLocation(HashMap<Book, String> booksLocation, Book book) {
        System.out.println(booksLocation.get(book));
    }

    static void printAllBooksAndTheirLocation(HashMap<Book, String> booksLocation) {
        booksLocation.keySet().forEach(book -> System.out.println("Book: " + book + ", location: "
                + booksLocation.get(book)));
    }
}
