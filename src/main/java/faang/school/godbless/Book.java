package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString(){
        return title + " - " + author + " " + year + "; ";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && title.equals(book.title) && author.equals(book.author);
    }

    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    public static void main(String args[]){
        Map<Book, String> bookMap = new HashMap<>();

        addBook(bookMap,"Harry Potter", "Rowling", 1997, "3 полка");
        addBook(bookMap,"Song of ice and fire", "Martin", 1995, "4 полка");
        addBook(bookMap,"War and peace", "Tolstoy", 1850, "1 полка");

        printAllBook(bookMap);
        deleteBook(bookMap, "War and peace", "Tolstoy", 1850);
        printAllBook(bookMap);

        findBook(bookMap, "War and peace", "Tolstoy", 1850);
        findBook(bookMap, "Harry Potter", "Rowling", 1997);
    }

    public static void addBook(Map<Book, String> bookMap, String title, String author, int year, String place){
        Book bookMaps = new Book(title, author, year);
        bookMap.put(bookMaps, place);
    }

    public static void deleteBook(Map<Book, String> bookMap, String title, String author, int year){
        Book hash = new Book(title, author, year);
        if(bookMap.containsKey(hash)){
            bookMap.remove(hash);
            System.out.println("Deleted!");
        } else System.out.println("Not found.");
    }

    public static void findBook(Map<Book, String> bookMap, String title, String author, int year){
        Book hash = new Book(title, author, year);
        String location = bookMap.get(hash);
        if(bookMap.containsKey(hash)){
            System.out.println("Found: " + title + " " + author + " " + year + "; ее местоположение - " + location);
        } else System.out.println("Not found.");
    }

    public static void printAllBook(Map<Book,String> bookMap){
        for(Map.Entry<Book, String> entry: bookMap.entrySet()){
            System.out.println("Книга: " + entry.getKey() + " Местоположение: " + entry.getValue());
        }
    }
}
