package faang.school.godbless.Sprint_1.JavaHashMap.BJS2_8225;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> bookList = new HashMap<>();
    public static void main(String[] args) {
        bookList.put(new Book("Harry Runer", "Lesha", 2002), "1");
        bookList.put(new Book("Dima Bugger", "Misha", 2001), "2");
        bookList.put(new Book("Biba i Boba", "Borya", 2003), "1");
        bookList.put(new Book("Druwing", "Daw", 2004), "4");
        System.out.println("AddBook---------------------------------------------");
        addBook("LelikRunner", "Lelik",2004,"3");
        printAllBook(bookList);
        System.out.println("RemoveBook------------------------------------------");
        removeBook("Druwing", "Daw",2004);
        printAllBook(bookList);
        System.out.println("SearcBook--------------------------------------------");
        searchBook("Harry Runer", "Lesha",2002);

    }
    public static void addBook(String bookName, String bookAuthor, int bookYear, String nomerPolki){
        bookList.put(new Book(bookName, bookAuthor, bookYear), nomerPolki);
    }
    public static void removeBook(String bookName, String bookAuthor, int bookYear){
        bookList.remove(new Book(bookName,bookAuthor,bookYear));
    }
    public static void searchBook(String bookName, String bookAuthor, int bookYear){
        for (Map.Entry<Book,String> entry : bookList.entrySet()) {
            Book book = entry.getKey();
            if (book.getTitle().equals(bookName) && book.getAuthor().equals(bookAuthor) && book.getYear() == bookYear) {
                System.out.println("Книга: " + book + " " + "находится на полке № - " + entry.getValue());
                return;
            }
        }
    }
    public static void printAllBook(Map<Book, String> allBook){
        for (Map.Entry entry : allBook.entrySet()){
            System.out.println("Книга :" + entry.getKey() + " полка № " + entry.getValue());
        }
    }
}
