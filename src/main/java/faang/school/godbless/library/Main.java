package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> books = new HashMap<>();
    public static void main(String[] args) {
        addBook("Mark", "Maks", 2023, "1");
        addBook("Lex", "Lexa", 2022, "2");
        showBook();
        System.out.println(searchBook("Mark", "Maks", 2023));
        deleteBook("Mark", "Maks", 2023);
        showBook();

    }

    private static void addBook(String title, String name, int year, String shelfNumber){
        books.put(new Book(title, name, year), shelfNumber);
    }

    private static void deleteBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    private static String searchBook(String title, String author, int year){
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            return books.get(book);
        }
        return "Такой книги нет !!";
    }

    private static void showBook(){
        for (Map.Entry<Book, String> entry: books.entrySet()){
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }
}