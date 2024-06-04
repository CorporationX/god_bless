package faang.school.godbless.vesterros_library;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class Book {
    private String title;
    private String author;
    private int year;

    public static void addBookToLibrary(Map<Book, String> bookMap, Book book, String positionOfBook){
        bookMap.put(book, positionOfBook);
    }

    public static void deleteBookFromLibrary(Map<Book, String> bookMap, String title, String author, int year){
        Book bookToDelete = new Book(title, author, year);
        bookMap.remove(bookToDelete);
    }

    public static void searchBookInLibrary(Map<Book, String> bookMap, String title, String author, int year){
        Book bookToSearch = new Book(title, author, year);
        System.out.println(bookMap.getOrDefault(bookToSearch, "Эта книга отсутствует в библиотеке"));
    }

    public static void showAllBooksInLibrary(Map<Book, String> bookMap){
        for(Map.Entry<Book, String> book : bookMap.entrySet()){
            System.out.println(book.getKey() + " расположена на " + book.getValue());
        }
    }
}
