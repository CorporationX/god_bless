package faang.school.godbless.week1.GameOfThrones;


import java.util.HashMap;
import java.util.Map;

public class Library {
    // Store books
    private Map<Book, String> library = new HashMap<>();

    public void addBook(Book book, String location) {
        library.put(book, location);
        System.out.println(book.getTitle() + "has been added to " + location + ".");
    }

    public void removeBook(Book book) {
        String location = library.remove(book);
        if (location != null) {
            System.out.println(book.getTitle() + "has been removed from " + location + ".");
        } else {
            System.out.println("Book not found. ");
        }
    }

    public void findBook(Book book) {
        String location = library.get(book);
        if (location != null) {
            System.out.println(book.getTitle() + "is located at " + location + ".");
        }else{
            System.out.println("Bool is not found. ");
        }
    }

    public void listBooks(){
        if(library.isEmpty()){
            System.out.println("No books available. ");
        }else{
            System.out.println("Listing all books. ");
            for(Map.Entry<Book, String> entry : library.entrySet()){
                System.out.println(entry.getKey() + " is located at "+ entry.getValue());
            }
        }
    }

}

