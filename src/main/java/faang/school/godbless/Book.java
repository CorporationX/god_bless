package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    private final String tittle;
    private final String author;
    private final int year;

    public Book(String tittle, String author, int year) {
        this.tittle = tittle;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(tittle, book.tittle) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tittle, author, year);
    }

    @Override
    public String toString() {
        return "\n" + "Book: " +
                "tittle=" + tittle +
                ", author=" + author +
                ", year=" + year;
    }

    public static void addBook(Map<Book, String> library , Book book, String location){
        library.put(book , location);
    }

    public static void removeBook(Map<Book , String> library, String tittle, String autor, int year){
        Book deleteBook = new Book(tittle,autor,year);
        library.remove(deleteBook);
    }

    public static void findBook(Map<Book , String> library, String tittle , String autor , int year){
        Book searchBook = new Book(tittle, autor, year);
            if (library.containsKey(searchBook)) {
                System.out.println(searchBook.tittle + " находиться на " + library.get(searchBook));
            } else {
                System.out.println("Книга не найдена");
            }
    }

    public static void allListBook(Map<Book , String> library){
        System.out.println(library);
    }

}

