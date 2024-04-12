package faang.school.godbless.library;

import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> libraryOfWesteross = new HashMap<>();
        libraryOfWesteross.put(new Book("Title 1", "Author 1", Year.of(1601)), "Stage 1");
        libraryOfWesteross.put(new Book("Title 2", "Author 1", Year.of(1745)), "Stage 1");
        libraryOfWesteross.put(new Book("Title 2", "Author 2", Year.of(1745)), "Stage 1");
        libraryOfWesteross.put(new Book("Title 3", "Author 3", Year.of(1678)), "Stage 2");

        Book book = new Book("Title 4", "Author 2", Year.of(1700));
        addBook(libraryOfWesteross, book, "Stage 3");
        showAllBooks(libraryOfWesteross);

        deleteBook(libraryOfWesteross, book);
        deleteByTitle(libraryOfWesteross, "Title 3");
        deleteByAuthor(libraryOfWesteross, "Author 1");
        deleteByYear(libraryOfWesteross, "1745");

        showAllBooks(libraryOfWesteross);

        Book book_1 = new Book("Title 5", "Author 3", Year.of(1900));
        addBook(libraryOfWesteross, book_1, "Stage 4");
        System.out.println("Book with title='" + book_1.getTitle() +
                "' placed on the " + findBook(libraryOfWesteross, book_1));
    }

    public static void addBook(Map<Book, String> library, Book book, String stage) {
        if (library.containsKey(book)) {
            System.out.println("The book has already been added earlier!");
        }
        library.put(book, stage);
    }

    public static void deleteBook(Map<Book, String> library, Book book) {
        String returnedValue = library.remove(book);
        if (!Objects.isNull(returnedValue)) {
            System.out.println(
                    "Book with title='" + book.getTitle() +
                            "', author='" + book.getAuthor() +
                            "', year=" + book.getYear() + " deleted from library"
            );
        }
        System.out.println(
                "It is not possible to delete a book with the title='" + book.getTitle() +
                        "', author='" + book.getAuthor() +
                        "', year=" + book.getYear() + " since it is not in the library!");
    }

    public static void deleteByTitle(Map<Book, String> library, String title) {
        findBookByParam(library, "title", title);
    }

    public static void deleteByAuthor(Map<Book, String> library, String author) {
        findBookByParam(library, "author", author);
    }

    public static void deleteByYear(Map<Book, String> library, String year) {
        findBookByParam(library, "year", year);
    }

    public static String findBook(Map<Book, String> library, Book book) {
        if (library.containsKey(book)) {
            return library.get(book);
        }
        return null;
    }

    public static void showAllBooks(Map<Book, String> library) {
        System.out.println("Books available in the Library of Westeross:");
        for (Map.Entry<Book, String> record : library.entrySet()) {
            System.out.println("Book with title '" + record.getKey().getTitle() +
                    "' placed on " + record.getValue());
        }
    }

    public static void findBookByParam(Map<Book, String> library, String param, String value) {
        int deleted = 0;
        Iterator<Map.Entry<Book, String>> booksIterator = library.entrySet().iterator();
        while (booksIterator.hasNext()) {
            Book book = booksIterator.next().getKey();
            if ("title".equals(param) && book.getTitle().equals(value)) {
                booksIterator.remove();
                deleted++;
            } else if ("author".equals(param) && book.getAuthor().equals(value)) {
                booksIterator.remove();
                deleted++;
            } else if ("year".equals(param)) {
                try {
                    Year year = Year.parse(value);
                    if (book.getYear().equals(year)) {
                        booksIterator.remove();
                        deleted++;
                    }
                } catch (DateTimeParseException ignored) {
                    System.out.println("Invalid year");
                }
            }
        }
        if (deleted > 0) {
            switch (param) {
                case "title" ->
                        System.out.println("Deleted " + deleted + " book(s) with title(s): " + value);
                case "author" ->
                        System.out.println("Deleted " + deleted + " book(s) with author(s): " + value);
                case "year" ->
                        System.out.println("Deleted " + deleted + " book(s) with year: " + value);
            }
        } else {
            System.out.println("It is not possible to delete a book with the " + param + " '" +
                    value + "', since it is not in the library!");
        }
    }
}
