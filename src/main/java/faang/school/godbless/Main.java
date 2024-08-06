package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static HashMap<Book, String>  books = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Book1", "Author1", 1990);
        Book book2 = new Book("Book2", "Author2", 1978);
        Book book3 = new Book("Book3", "Author3", 1835);
        Book book4 = new Book("Book4", "Author4", 1999);
        Book book5 = new Book("Book5", "Author5", 1555);
        Book book6 = new Book("Book6", "Author6", 1666);

        books.put(book1, "1");
        books.put(book2, "2");
        books.put(book3, "3");
        books.put(book4, "4");
        books.put(book5, "5");

        addBook(book6, "6");
        deleteBook("Book3", "Author3", 1835);
        System.out.println(findBook("Book2", "Author2", 1978));
        System.out.println(pringAllBooks());

    }

    public static void addBook(Book book, String place) {
        books.put(book, place);
    }

    public static void deleteBook(String name, String author, int year) {
        Book newBook = new Book(name, author, year);
        books.remove(newBook);
    }

    public static String findBook(String name, String author, int year) {
        Book newBook = new Book(name, author, year);
        String result = books.get(newBook);
        return result;
    }

    public static String pringAllBooks(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Book, String> entry : books.entrySet()){
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
