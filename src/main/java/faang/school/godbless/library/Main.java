package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

    }

    public static String addBook(Map<Book, String> map, Book book, String location) {
        if (!map.containsKey(book)) {
            map.put(book, location);
            return "The book has been added";
        } else {
            return "The book " + book.toString() + " is already exists";
//            System.out.println("The book" + book.toString() + " is already exists");
        }
    }

    public static void deleteBook(Map<Book, String> map, String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (map.containsKey(book)) {
            map.remove(book);
        } else {
            System.out.println("The book with given parameters does not exist");
        }

    }

    public static String searchBook(Map<Book, String> map, String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (map.containsKey(book)) {
            return "The book is on Shelf " + map.get(book);
        } else {
            return "The book with given parameters does not exist";
        }
    }

    public static void getBookList(HashMap<Book, String> books){
        for (HashMap.Entry<Book, String> pair :  books.entrySet()){
            System.out.println(pair.getKey().toString() + " | " + "Shelf: " + pair.getValue());
        }
    }
}
