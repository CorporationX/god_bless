package school.faang.bjs245296;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class LibraryStream {

    private Map<Book, String> books;

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!books.containsKey(book)) {
            System.out.println("Book has not found");
            return;
        }
        System.out.println(books.get(book));
    }

    public void printAllBooks() {
        for (var entry : books.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

}
