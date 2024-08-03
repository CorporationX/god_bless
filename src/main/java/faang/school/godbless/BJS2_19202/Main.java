package faang.school.godbless.BJS2_19202;

import java.util.HashMap;

public class Main {
    public static HashMap<Book, String> library = new HashMap<>();

    {
        library.put(new Book("1984", "George Orwell", 1970), "Row 5, Shelf 3");
        library.put(new Book("To Kill a Mockingbird", "Harper Lee", 1960), "Row 2, Shelf 1");
        library.put(new Book("Pride and Prejudice", "Jane Austen", 1813), "Row 7, Shelf 2");
        library.put(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925), "Row 4, Shelf 5");
        library.put(new Book("Moby Dick", "Herman Melville", 1851), "Row 3, Shelf 4");
        library.put(new Book("The Catcher in the Rye", "J.D. Salinger", 1951), "Row 6, Shelf 3");
        library.put(new Book("The Hobbit", "J.R.R. Tolkien", 1937), "Row 8, Shelf 1");
        library.put(new Book("Brave New World", "Aldous Huxley", 1932), "Row 2, Shelf 5");
        library.put(new Book("Fahrenheit 451", "Ray Bradbury", 1953), "Row 5, Shelf 2");
        library.put(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954), "Row 1, Shelf 6");
    }

    public static void main(String[] args) {

    }

    public static void addBook(Book book, String place) {
        library.put(book, place);
    }

    public static void removeBook(String name, String author, int year) {
        Book book = new Book(name, author, year);
        library.remove(book);
    }

    public static void findPlace(String name, String author, int year) {
        Book book = new Book(name, author, year);
        System.out.println(library.get(book));
    }

    public static void printLibrary() {
        for(var book : library.entrySet()) {
            System.out.println(book.getKey() + " " + book.getValue());
        }
    }
}
