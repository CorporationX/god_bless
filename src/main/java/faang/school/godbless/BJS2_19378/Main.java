package faang.school.godbless.BJS2_19378;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Book, String> library = new HashMap<>();
        library.put(new Book("Metro","Glukhovsky", 2003 ), "SectionB");
        library.put(new Book("Master", "Pushkin", 1935), "SectionA");
        library.put(new Book("Jujutsu Kaizen","Iovlev", 2018 ), "SectionG");

        addBook(library, new Book("Ruslan","Olegovich", 2003), "SectionS");
        deleteBook(library,"Metro","Glukhovsky", 2003);
        searchBook(library,"Jujutsu Kaizen","Iovlev", 2018);
        shoeAllBooks(library);

    }

    public static void addBook(Map<Book, String> library, Book book, String section){
        library.put(book, section);
    }

    public static void deleteBook(Map<Book, String> library, String title, String author, int year){
        Book bookToDelete = new Book(title, author, year);
        library.remove(bookToDelete);
    }

    public static void searchBook(Map<Book, String> library, String title, String author, int year){
        Book bookToFind = new Book(title, author, year);
        if (library.containsKey(bookToFind)){
            System.out.println(library.get(bookToFind));
        }
    }

    public static void shoeAllBooks(Map<Book, String> library){
        for (Map.Entry<Book, String> allBooks : library.entrySet()){
            System.out.println("Book: " + allBooks.getKey().getTitle() + " Section: " + allBooks.getValue());
        }
    }






}
