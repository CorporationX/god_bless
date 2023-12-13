package faang.school.godbless.BJS2_556;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> mapBook= new HashMap<>();
        Book b1 = new Book("4.50 From Paddington", "Agatha Christie", 1957);
        Book b2 = new Book("Death On The Nile", "Agatha Christie", 1937);
        Book b3 = new Book("Three Comrades", "Erich Maria Remarque", 1936);
        mapBook.put(b1, "12 shelf");
        mapBook.put(b2, "13 shelf");
        addNewBook(mapBook, b3, "15 shelf");
        deleteBook(mapBook, "Death On The Nile", "Agatha Christie", 1937);
        for (Map.Entry<Book, String> entry: mapBook.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        System.out.println(findBook(mapBook, "Three Comrades", "Erich Maria Remarque", 1936));
        listBooks(mapBook);
    }
    public static Map<Book, String> addNewBook(Map<Book, String> mapBook, Book book, String place){
        mapBook.put(book, place);
        return mapBook;
    }
    public static Map<Book, String> deleteBook(Map<Book, String> mapBook, String name, String author, int year){
        Iterator<Map.Entry<Book,String>> iterator = mapBook.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Book, String> entry = iterator.next();
            if (entry.getKey().getAuthor().equals(author) && entry.getKey().getTitle().equals(name) && entry.getKey().getYear() == year) {
                iterator.remove();
            }
        }
        return mapBook;
    }
    public static String findBook(Map<Book, String> mapBook, String title, String author, int year){
        for (Map.Entry<Book, String> entry : mapBook.entrySet()) {
            Book key = entry.getKey();
            if(key.getTitle().equals(title) && key.getAuthor().equals(author) && key.getYear()==year){
                return entry.getValue();
            }
        }
        return "There are no this book";
    }
    public static void listBooks(Map<Book, String> mapBook){
        for (Map.Entry<Book, String> entry : mapBook.entrySet()) {
            System.out.println(entry);
        }
    }
}
