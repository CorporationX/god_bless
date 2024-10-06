package school.faang.libraryofwesteross;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    private static final Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        library.put(new Book("Book1", "Author1", 1995), "1");
        library.put(new Book("Book2", "Author2", 1996), "2");
        library.put(new Book("Book3", "Author3", 1997), "3");
        library.put(new Book("Book4", "Author4", 1998), "4");
        library.put(new Book("Book5", "Author5", 1999), "5");

        System.out.println("Original list of books: " + library);


        addBook(new Book("Book6", "Author6", 2000), library, "6");
        System.out.println("New book added: " + library);

        removeBook("Book1", "Author1", 1995);
        System.out.println("Book removed: " + library);

        // find book by its location
        System.out.println("Founded book: " + findBookByLocation("3", library));

        // find location of the book by location
        System.out.println(findLocationOfBook("Book4", "Author4", 1998));

        showAllBook(library);

    }

    public static void addBook(Book book, Map<Book, String> library, String bookLocation){
        library.put(book, bookLocation);
    }


    public static void removeBook(String title, String author, Integer year){
        library.remove(new Book(title, author, year));
    }

    public static Optional<Book> findBookByLocation(String bookLocation, Map<Book, String> library){
        for(Map.Entry<Book, String> map : library.entrySet()){
            if(map.getValue().equals(bookLocation)){
                return Optional.ofNullable(map.getKey());
            }
        }
        return Optional.empty();
    }

    public static Optional<String> findLocationOfBook(String title, String author, Integer year){
        Book book = new Book(title, author, year);
        return Optional.ofNullable(library.get(book));
    }

    public static void showAllBook(Map<Book, String> library){
        for(Map.Entry<Book, String> map : library.entrySet()){
            System.out.println("Book's info: " + map.getKey() + "Location: " + map.getValue());
        }
    }



}
