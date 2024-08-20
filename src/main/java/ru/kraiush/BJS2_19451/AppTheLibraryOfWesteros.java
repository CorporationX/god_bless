package ru.kraiush.BJS2_19451;

import java.util.HashMap;
import java.util.Map;

public class AppTheLibraryOfWesteros {

    public static void main(String[] args) {

        Map<Book, Integer> mapBooks= new HashMap<>();

        mapBooks.put(new Book("Master and Margarita", "Bulgakov", 1966), 123);
        mapBooks.put(new Book("The theory of relativity", "Einshtein", 1947), 567);
        mapBooks.put(new Book("Buratino", "Tolstoy", 1955), 367);

        mapBooks.forEach((K, V) -> System.out.println("key: " + K + " place: " + V));

        System.out.println("");
        String name= "Master and Margarita";
        String author= "Bulgakov";
        Integer year= 1966;

        Map<Book, Integer> result = findBook(name, author, year, mapBooks);
        System.out.println("found a book by 3 parametres");
        result.forEach((K, V) -> System.out.println("key: " + K + " place: " + V));

        removeBook(name, author, year, mapBooks);
        System.out.println("\nremove a book");
//        mapBooks.forEach((K, V) -> System.out.println("key: " + K + " place: " + V));
    }

    private static Map<Book, Integer> findBook(String name, String author, Integer year, Map<Book, Integer> mapBooks) {

        Map<Book, Integer> mapBook = new HashMap<>();

        for (Map.Entry<Book, Integer> book : mapBooks.entrySet()) {
            if(book.getKey().getTitle().equals(name) &&
                    book.getKey().getAuthor().equals(author) &&
                    book.getKey().getYear() == year) {

                mapBook.put(book.getKey(), book.getValue());
            }
        }
        return mapBook;
    }

    private static void removeBook(String name, String author, Integer year, Map<Book, Integer> mapBooks) {

        for (Map.Entry<Book, Integer> book : mapBooks.entrySet()) {
            if(book.getKey().getTitle().equals(name) &&
                    book.getKey().getAuthor().equals(author) &&
                    book.getKey().getYear() == year) {
                System.out.println("remove book.getKey(): " + book.getKey());
                mapBooks.remove(book.getKey());
            }
        }
    }
}
