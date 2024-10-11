package school.faang.JavaHashMap.BJS2_33039;

import java.util.HashMap;
import java.util.Map;


public class Main {
    static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        library.put(new Book("1984", "George Orwell", 72), "Shelf 1");
        library.put(new Book("To Kill a Mockingbird", "Harper Lee", 62), "Shelf 1");
        library.put(new Book("The Great Gatsby", "F. Scott Fitzgerald", 97), "Shelf 2");
        library.put(new Book("Pride and Prejudice", "Jane Austen", 208), "Shelf 2");
        library.put(new Book("Moby Dick", "Herman Melville", 171), "Shelf 3");
        library.put(new Book("War and Peace", "Leo Tolstoy", 150), "Shelf 3");
        library.put(new Book("Brave New World", "Aldous Huxley", 89), "Shelf 4");
        library.put(new Book("The Catcher in the Rye", "J.D. Salinger", 71), "Shelf 4");
        library.put(new Book("The Hobbit", "J.R.R. Tolkien", 87), "Shelf 5");
        library.put(new Book("The Alchemist", "Paulo Coelho", 37), "Shelf 5");
        library.put(new Book("Fahrenheit 451", "Ray Bradbury", 69), "Shelf 6");
        library.put(new Book("The Picture of Dorian Gray", "Oscar Wilde", 129), "Shelf 6");
        library.put(new Book("The Brothers Karamazov", "Fyodor Dostoevsky", 143), "Shelf 7");
        library.put(new Book("Jane Eyre", "Charlotte Brontë", 174), "Shelf 8");
        library.put(new Book("Wuthering Heights", "Emily Brontë", 171), "Shelf 8");

        addBook(new Book("Harry Runner", "Bobby Burber", 3), "Shelf 1");

        allLibrary();

        removeBook("Jane Eyre", "Charlotte Brontë", 174);

        allLibrary();

        searchBook("Harry Runner", "Bobby Burber", 3);

        searchBook("Jane Eyre", "Charlotte Brontë", 174);
    }

    private static void addBook(Book book, String shelf) {
        library.put(book, shelf);
        System.out.println("Книга " + book + " добавлена на полку " + shelf + "\n");
    }

    private static void removeBook(String title, String author, int age) {
        Book bookToRemove = null;
        for (Book book : library.keySet()) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getAge() == age) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            library.remove(bookToRemove);
            System.out.println("Книга " + title + " удалена");
        } else {
            System.out.println("Книга " + title + " не найдена");
        }
    }

    private static void searchBook(String title, String author, int age) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            Book book = entry.getKey();
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getAge() == age) {
                System.out.println("Книга: " + book + " найдена на полке " + entry.getValue());
                return;
            }
        }
        System.out.println("Книга не найдена: " + title + " by " + author);
    }

    private static void allLibrary() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Shelf: " + entry.getValue());
        }
    }
}