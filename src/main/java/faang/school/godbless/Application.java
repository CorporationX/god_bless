package faang.school.godbless;

import java.util.HashMap;

public class Application {
    private static HashMap<Book,String> bookState = new HashMap<>();
    public static void main(String[] args) {
        Book firstBook = new Book("firstBook" , "FirstAuthor" , 20024);
        Book secondBook = new Book("secondBook" , "SecondAuthor" , 20024);
        Book thirdBook = new Book("thirdBook" , "ThirdAuthor" , 20024);
        
        add(firstBook, "3");
        add(secondBook, "10");
        add(thirdBook, "30");

        printAll();
        System.out.println("Finish");
        remove(firstBook.getTitle(), firstBook.getAuthor(), firstBook.getYear());
        printAll();

        searchBook(secondBook.getTitle(), secondBook.getAuthor(), secondBook.getYear());
    }

    private static void add(Book book, String shelf){
        bookState.put(book, shelf);
    }
    private static void remove(String name, String author, Integer year){
        bookState.remove(new Book(name, author, year));
    }
    private static void printAll(){
        bookState.forEach((book, shelf) -> {
            System.out.println("Book: " + book.getTitle() + ", shelf: " + shelf);
        });
    }
    private static void searchBook(String name, String author, Integer year){
        System.out.println("Search book: " + name + ", shelf: " + bookState.get(new Book(name, author, year)));
    }
}