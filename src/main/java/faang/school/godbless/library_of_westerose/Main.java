package faang.school.godbless.library_of_westerose;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> mapOfLibrary = new HashMap<>();

    public static void main(String[] args) {

        Book book1 = new Book("Don Quixote", "Miguel de Cervantes", 1605);
        Book book2 = new Book("Moby-Dick", "Herman Melville", 1851);
        Book book3 = new Book("The Great Gatsby", "Scott Fitzgerald", 1925);

        addBook(book1, "1234");
        addBook(book2, "2345");
        addBook(book3, "4567");

        removeBook(book1);

        printAllBooks();

        String shelfNumber = searchBook(new Book("The Great Gatsby", "Scott Fitzgerald", 1925));
        System.out.println("Shelf number: " + shelfNumber);
    }

    private static void removeBook(Book book) {
        mapOfLibrary.remove(book);
    }

    private static void addBook(Book book, String shelfNumber) {
        mapOfLibrary.put(book, shelfNumber);
    }

    private static String searchBook(Book book){
        return mapOfLibrary.get(book);
    }

    private static void printAllBooks(){
        for (Map.Entry<Book, String> entry : mapOfLibrary.entrySet()){
            System.out.println("Book: " + entry.getKey() + ". Shelf: " + entry.getValue());
        }
    }

}
