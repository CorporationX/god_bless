package library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        library.put(new Book("qqq", "m1", 2024), "12");
        library.put(new Book("www", "m1", 2024), "12");
        library.put(new Book("eee", "m1", 2024), "12");

        printAllBooks(library);
        findBook(library, "qqq", "m1", 2024);
        findBook(library, "qqq", "m1", 2023);
        System.out.println();

        deleteFromLibrary(library, "qqq", "m1", 2024);
        printAllBooks(library);
        System.out.println();

        addToLibrary(library, new Book("qqq", "m1", 2024), "144");
        printAllBooks(library);
    }

    public static void addToLibrary(Map<Book, String> map, Book key, String value){
        map.put(key, value);
    }
    public static void deleteFromLibrary(Map<Book, String> map, String title, String autor, int year){
        map.remove(new Book(title, autor, year));
    }

    public static void findBook(Map<Book, String> map, String title, String autor, int year){
        if (map.containsKey(new Book(title, autor, year))) {
            System.out.println(map.get(new Book(title, autor, year)));
        }else{
            System.out.println("There is no such book in the library.");
        }
    }

    public static void printAllBooks(Map<Book, String> map){
        for(Map.Entry<Book, String> entry: map.entrySet()){
            System.out.println(entry.getKey() + " Shelf:" + entry.getValue());
        }
    }

}
