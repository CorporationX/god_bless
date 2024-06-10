package faang.school.godbless.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    public static final Map<Book, String> bookMap = new HashMap<>();

    public static void main(String[] args) {
        addBook(bookMap, new Book("Автор1", "Название1", 1), "Полка 1");
        addBook(bookMap, new Book("Автор2", "Название2", 2), "Полка 2");
        addBook(bookMap, new Book("Автор3", "Название3", 3), "Полка 3");
        addBook(bookMap, new Book("Автор4", "Название4", 4), "Полка 4");
        removeBookByAuthorAndTitleAndYear(bookMap, "Автор4", "Название4", 4);
        findAndPrintBookByAuthorAndTitleAndYear(bookMap, "Автор3", "Название3", 3);
        printAllBooksInfo(bookMap);
    }

    public static void addBook(Map<Book, String> bookMap, Book book, String place) {
        bookMap.put(book, place);
    }

    public static void removeBookByAuthorAndTitleAndYear(Map<Book, String> bookMap, String author, String title, int year) {
        bookMap.remove(findEntryBookByAuthorAndTitleAndYear(bookMap, author, title, year).getKey());
    }

    public static void findAndPrintBookByAuthorAndTitleAndYear(Map<Book, String> bookMap, String author, String title, int year) {
        Map.Entry<Book, String> entry = findEntryBookByAuthorAndTitleAndYear(bookMap, author, title, year);
        printInfoAboutBook(entry.getKey().getAuthor(), entry.getKey().getTitle(), entry.getKey().getYear(), entry.getValue());
    }

    public static void printAllBooksInfo(Map<Book, String> bookMap) {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            printInfoAboutBook(entry.getKey().getAuthor(), entry.getKey().getTitle(), entry.getKey().getYear(), entry.getValue());
        }
    }

    private static Map.Entry<Book, String> findEntryBookByAuthorAndTitleAndYear(Map<Book, String> bookMap, String author, String title, int year) {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            if (entry.getKey().getAuthor().equals(author) && entry.getKey().getTitle().equals(title) && entry.getKey().getYear() == year)
                return entry;
        }
        throw new NoSuchElementException("ОшЫбка, книга с автором: " + author + ", названием: " + title + " и годом выпуска " + year + " - не найдена (");
    }

    private static void printInfoAboutBook(String author, String title, int year, String placement) {
        System.out.println("Метоположение книги автора " + author + " под названием \"" + title + "\", выпущенная в " + year + " году - " + placement);
    }
}
