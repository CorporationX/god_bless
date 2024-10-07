package school.faang.secondTask;

import java.util.HashMap;
import java.util.Map;

public class BookManager {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(Book book, String location) {
        // Depends on business logic, if we use put or putIfAbsent. Here I use putIfAbsent
        library.putIfAbsent(book, location);
        System.out.println("Book added: " + book.toString() + " at " + location);
    }

    public void removeBook(Book book) {
        if (library.remove(book) !=null){
            System.out.println("Book removed: " + book.toString());
        } else{
            System.out.println("Book not found: " + book.toString());
        }
    }

    public void findBook(Book book) {
        String location = library.get(book);
        if (location !=null){
            System.out.println("Book found: " + book.toString() + " at " + location);
        } else{
            System.out.println("Book not found: " + book.toString());
        }
    }

    public void listAllBooks() {
        for (Map.Entry<Book, String> entry :library.entrySet()){
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println("Book: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.
                    getYear() + ", Location: " + location);
        }
    }
}
