package Mathew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Book, String> Library = new HashMap<>();
    public static void main(String[] args) {
        Book detective = new Book("Sherlock Holmes","Doyle",1900);
        Book romance = new Book("Island","Dephoe",1950);
        Book prose = new Book("Christine","King",1980);

    Library.put(detective,"A");
    Library.put(romance,"B");
    Library.put(prose,"C");
    getAllBooks();
    removeBook(romance.getTitle(), romance.getAuthor(), romance.getYear());
    addBook(romance,"L");
    }
public static void addBook(Book book,String number) {
    Library.put(book,number);
}
public static void removeBook(String name,String author,int year) {
        Library.remove(new Book(name,author,year));
}
public static void getAllBooks() {
        Library.forEach(((key,value) ->System.out.println(key + value)));
}
}