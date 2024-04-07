package faang.school.godbless.library;

import java.time.Year;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Main {


    public static void main(String[] args) {
        Map<Book, String> libraryOfWesteross = new HashMap<>();
        libraryOfWesteross.put(new Book("Title 1", "Author 1", Year.of(1601)), "Stage 1");
        libraryOfWesteross.put(new Book("Title 2", "Author 1", Year.of(1745)), "Stage 1");
        libraryOfWesteross.put(new Book("Title 3", "Author 2", Year.of(1678)), "Stage 2");
        // Добавим книгу
        Book book = new Book("Title 4", "Author 2", Year.of(1700));
        addBook(libraryOfWesteross, book, "Stage 3");
        showAllBooks(libraryOfWesteross);
        //Удаляем книги с разными параметрами
        deleteBook(libraryOfWesteross, book.getTitle(), book.getAuthor(), book.getYear());
        deleteByTitle(libraryOfWesteross, "Title 3");
        deleteByTitle(libraryOfWesteross, "Author 1");
        deleteByYear(libraryOfWesteross, Year.of(1745));
        //Покажем, что осталось в библиотеке
        showAllBooks(libraryOfWesteross);
        // Поищем книгу в остатках
        Book book_1 = new Book("Title 5", "Author 3", Year.of(1900));
        addBook(libraryOfWesteross, book_1, "Stage 4");
        System.out.println(findBook(libraryOfWesteross, book_1));
    }

    public static Boolean addBook(Map<Book, String> library, Book book, String stage) {
        if (library.containsKey(book)) {
            System.out.println("The book has already been added earlier!");
            return false;
        }
        library.put(book, stage);
        return true;
    }

    public static Boolean deleteBook(
            Map<Book, String> library,
            String title,
            String author,
            Year year) {
        String returnedValue = library.remove(new Book(title, author, year));
        if (!Objects.isNull(returnedValue)) {
            System.out.println("Book with title=" + title + ", author=" + author +
                    ", year=" + year + " deleted from library");
            return true;
        }
        System.out.println("It is not possible to delete a book with the title=" + title +
                ", author=" + author +
                ", year=" + year + "since it is not in the library!");
        return false;
    }

    // Удаляем все книги одинакового названия, которые могут иметь разных авторов
    // и год издания
    public static Boolean deleteByTitle(Map<Book, String> library, String title) {
        int deleted = 0;
        // Перепишем на итератор
        Iterator<Map.Entry<Book, String>> booksIterator = library.entrySet().iterator();
        while (booksIterator.hasNext()) {
            // Удаляем без ConcurrentModificationException
            Map.Entry<Book, String> record = booksIterator.next();
            if (record.getKey().getTitle().equals(title)) {
                booksIterator.remove();
                deleted++;
            }
        }
        if (deleted > 0) {
            System.out.println("Deleted " + deleted + " book(s) with title(s): " + title);
            return true;
        }
        System.out.println("It is not possible to delete a book with the title " +
                title + ", since it is not in the library!");
        return false;
    }

    // Удаляем все книги одного автора, которые могут иметь разные названия
    // и год издания
    public static boolean deleteByAuthor(Map<Book, String> library, String author) {
        int deleted = 0;
        // Удаляем без ConcurrentModificationException
        Iterator<Map.Entry<Book, String>> booksIterator = library.entrySet().iterator();
        while (booksIterator.hasNext()) {
            Map.Entry<Book, String> record = booksIterator.next();
            if (record.getKey().getAuthor().equals(author)) {
                booksIterator.remove();
                deleted++;
            }
        }
        if (deleted > 0) {
            System.out.println("Deleted " + deleted + " book(s) with author(s): " + author);
            return true;
        }
        System.out.println("It is not possible to delete a book with the author " +
                author + ", since it is not in the library!");
        return false;
    }

    // Удаляем все книги одного года выпуска, которые могут иметь разные названия
    // и разных авторов
    public static Boolean deleteByYear(Map<Book, String> library, Year year) {
        int deleted = 0;
        // Удаляем без ConcurrentModificationException
        Iterator<Map.Entry<Book, String>> booksIterator = library.entrySet().iterator();
        while (booksIterator.hasNext()) {
            Map.Entry<Book, String> record = booksIterator.next();
            if (record.getKey().getYear().equals(year)) {
                booksIterator.remove();
                deleted++;
            }
        }
        if (deleted > 0) {
            System.out.println("Deleted " + deleted + " book(s) with year: " + year);
            return true;
        }
        System.out.println("It is not possible to delete a book with the year " +
                year + ", since it is not in the library!");
        return false;
    }

    public static String findBook(Map<Book, String> library, Book book) {
        if (library.containsKey(book)) {
            return "Book with title=" + book.getTitle() + ", author=" + book.getAuthor() +
                    ", year=" + book.getYear() + " located on " + library.get(book);
        }
        return "It is not possible to find a book with the title=" + book.getTitle() +
                ", author=" + book.getAuthor() +
                ", year=" + book.getYear() + "since it is not in the library!";
    }

    public static void showAllBooks(Map<Book, String> library) {
        System.out.println("Books available in the Library of Westeross:");
        for (Map.Entry<Book, String> record : library.entrySet()) {
            System.out.println("Book with title " + record.getKey().getTitle() +
                    " places on " + record.getValue());
        }
    }
}

