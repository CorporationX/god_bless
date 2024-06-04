package faang.school.godbless.vesterros_library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> bookMap = new HashMap<>();

        Book bookPushkin = new Book("Евгений Онегин", "А.С. Пушкин", 1833);
        Book bookDostoevsky = new Book("Преступление и Наказание", "Ф.М. Достоевский", 1866);
        Book bookTolstoy = new Book("Война и Мир", "Л.М. Толстой", 1867);

        System.out.println("Library after adding Books:");
        Book.addBookToLibrary(bookMap, bookPushkin, "1 ряд 3 полка");
        Book.addBookToLibrary(bookMap, bookDostoevsky, "2 ряд 1 полка");
        Book.addBookToLibrary(bookMap, bookTolstoy, "3 ряд 2 полка");
        Book.showAllBooksInLibrary(bookMap);
        System.out.println();

        System.out.println("Library after removing War and Peace:");
        Book.deleteBookFromLibrary(bookMap,"Война и Мир", "Л.М. Толстой", 1867);
        Book.showAllBooksInLibrary(bookMap);
        System.out.println();

        Book.searchBookInLibrary(bookMap, "Преступление и Наказание", "Ф.М. Достоевский", 1866);
        Book.searchBookInLibrary(bookMap, "Война и Мир", "Л.М. Толстой", 1867);
    }
}
