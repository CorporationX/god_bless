package school.faang.library;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    public static void addBook(Book newBook, String category, Map<Book, String> library){
        library.put(newBook, category);
    }

    public static void deleteBook(String title, String author, int year, Map<Book, String> library){
        library.remove(new Book(title, author, year));
    }

    public static void printBook(String title, String author, int year, Map<Book, String> library){
        Book book = new Book(title, author, year);
        if(library.containsKey(book)){
            System.out.printf("Книга %s находится в категории %s \n", book, library.get(book));
        } else {
            System.out.printf("Книга %s не найдена \n", book);
        }
    }

    public static void printAllBooks(Map<Book, String> library){
        for (var book: library.entrySet()){
            System.out.println(book);
        }
    }
}
