package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static Map<Book, String> map = new HashMap<>();
    public void addBook(String title, String author, int year, String location){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        map.put(book, location);
    }
    public void removeBook(String title, String author, int year){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        map.remove(book);
    }
    public  String findBook(String title, String author, int year){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        if (map.containsKey(book)){
            return map.get(book);
        }else{
            System.out.println("Book not found");
            return title;
        }
    }
    public void showAllBooks(){
        for (Map.Entry<Book, String> entry : map.entrySet()){
            System.out.println("Title: " + entry.getKey().getTitle()+" Location: "+entry.getValue());
        }
    }
}

