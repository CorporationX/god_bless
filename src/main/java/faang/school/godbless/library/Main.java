package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> bookMap = new HashMap<>();
    public static void main(String[] args) {
        Book it = new Book("It", "King", 1998);
        Book they = new Book("they", "King", 1998);
        searchBook("It", "King", 1998);
        addNewBook(it, "67k");
        addNewBook(they, "89h");
        searchBook("It", "King", 1998);
        listAllBooks();
        removeBook("It", "King", 1998);
        searchBook("It", "King", 1998);
        listAllBooks();
    }

    public static void addNewBook(Book book, String shelf){
        bookMap.put(book, shelf);
    }
    public static void removeBook(String title, String  author, int year){
        Book inputBook = new Book(title, author, year);
        if (bookMap.containsKey(inputBook)){
            bookMap.remove(inputBook);
        }else{
            System.out.println("There is no such book");
        }

    }

    public static void searchBook(String title, String  author, int year){
        Book inputBook = new Book(title, author, year);
        if (bookMap.containsKey(inputBook)){
            System.out.println("This book is located on the shelf #" + bookMap.get(inputBook));
        }else{
            System.out.println("Unfortunately, we could not find this book");
        }

    }
    public static void listAllBooks(){
        for (var entry : bookMap.entrySet()){
            System.out.println("'" + entry.getKey().getTitle() + "'" + " is located on the shelf #" + entry.getValue());
        }
    }

}
