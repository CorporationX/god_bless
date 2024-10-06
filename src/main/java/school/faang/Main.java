package school.faang;

import school.faang.secondTask.Book;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        vesterosLibrary();
    }

    private static void vesterosLibrary() {
        addBook(new Book("1984", "Джордж Оруэлл", 1949), "Полка 1");
        addBook(new Book("Чебурашка", "Успенский", 1975), "Полка 2");
        addBook(new Book("Незнайка", "Носов", 1979), "Полка 3");
        addBook(new Book("Незнайка", "Носов", 1979), "Полка 4");
        listAllBooks();

        findBook(new Book("1984", "Джордж Оруэлл", 1949));

        removeBook(new Book("1984", "Джордж Оруэлл", 1949));
        removeBook(new Book("1984", "Джордж Оруэлл", 1949));

        listAllBooks();
    }

    public static void addBook(Book book, String location) {
        // Depends on business logic, if we use put or putIfAbsent. Here I use putIfAbsent
        library.putIfAbsent(book, location);
        System.out.println("Book added: " + book.toString() + " at " + location);
    }

    public static void removeBook(Book book) {
        if (library.remove(book) !=null){
            System.out.println("Book removed: " + book.toString());
        } else{
            System.out.println("Book not found: " + book.toString());
        }
    }

    public static void findBook(Book book) {
        String location = library.get(book);
        if (location !=null){
            System.out.println("Book found: " + book.toString() + " at " + location);
        } else{
            System.out.println("Book not found: " + book.toString());
        }
    }

    public static void listAllBooks() {
        for (Map.Entry<Book, String> entry :library.entrySet()){
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println("Book: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.
            getYear() + ", Location: " + location);
        }
    }
}
