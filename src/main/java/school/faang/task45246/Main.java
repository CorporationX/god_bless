package school.faang.task45246;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>(Map.of(
                new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997), "5 полка",
                new Book("The Hobbit", "J.R.R. Tolkien", 1937), "3 полка",
                new Book("1984", "George Orwell", 1949), "1 полка",
                new Book("To Kill a Mockingbird", "Harper Lee", 1960), "2 полка",
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925), "4 полка",
                new Book("Moby Dick", "Herman Melville", 1851), "6 полка",
                new Book("War and Peace", "Leo Tolstoy", 1869), "7 полка",
                new Book("Pride and Prejudice", "Jane Austen", 1813), "8 полка",
                new Book("The Catcher in the Rye", "J.D. Salinger", 1951), "9 полка",
                new Book("Brave New World", "Aldous Huxley", 1932), "10 полка"
        ));

        LibrarySystem librarySystem = new LibrarySystem(library);

        librarySystem.addBook("The Picture of Dorian Gray", "Oscar Wilde", 1890, "12 полка");
        librarySystem.printAllBooks();
        librarySystem.findBook("Brave New World", "Aldous Huxley", 1932);
        librarySystem.removeBook("Pride and Prejudice", "Jane Austen", 1813);
        librarySystem.findBook("Pride and Prejudice", "Jane Austen", 1813);
    }
}
