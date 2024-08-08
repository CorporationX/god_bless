package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Book,String> books = new HashMap<>();

    public void addBook(Book book,String placement){
        books.put(book,placement);
    }
    public void removeBook(String name, String author, int year){
        Book book = new Book(name,author,year);
        books.remove(book);
    }
    public String searchBook(String name, String author, int year){
        Book book = new Book(name,author,year);
        return books.get(book);
    }
    public String bookList(){
        StringBuilder report = new StringBuilder();
        for (var entry : books.entrySet()){
            report.append(entry.getKey()+":"+entry.getValue()+"\n");
        }
        return report.toString();
    }
}
