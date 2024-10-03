package school.faang.task131;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    private HashMap<Book,String> bookPlace = new HashMap<>();

    {
        Book firstBook = new Book("A Song of Ice and Fire", "George R. R. Martin", 1997);
        Book secondBook = new Book("Crime and punishment", "Fyodor Dostoevsky", 1866);
        Book thirdBook = new Book("1984", "George Orwell", 1949);

        bookPlace.put(firstBook, "First shelf");
        bookPlace.put(secondBook, "Second shelf");
        bookPlace.put(thirdBook, "Third shelf");
    }
    public void addBook(Book book, String place){
        bookPlace.put(book, place);
    }
    public void removeBook(String title, String author, int year){
        Book book = new Book(title, author, year);
        bookPlace.remove(book);
    }
    public void findBookPlace(String title, String author, int year){
        Book book = new Book(title, author, year);
        System.out.println(bookPlace.get(book));
    }
    public void printAllBook(){
        for(Map.Entry<Book, String> entry : bookPlace.entrySet()){
            Book book=entry.getKey();
            System.out.println(book + " Place=" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        //Create new book to add in map
        Book firstBook = new Book("To Kill a Mockingbird", "Harper Lee", 1988);
        main.addBook(firstBook, "Fourth shelf");
        main.printAllBook();
        System.out.println();
        //Remove book
        main.removeBook("Crime and punishment", "Fyodor Dostoevsky", 1866);
        main.printAllBook();
        System.out.println();
        //Find book place
        main.findBookPlace("1984", "George Orwell", 1949);
    }

}
