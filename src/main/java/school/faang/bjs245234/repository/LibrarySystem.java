package school.faang.bjs245234.repository;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import school.faang.bjs245234.model.Book;

import java.util.Map;

@AllArgsConstructor
@ToString
public class LibrarySystem {
    private Map<Book, String> library;

    public void addBook(@NonNull Book book, @NonNull String location) {
        this.library.put(book, location);
    }

    public void removeBook(Book book) {
        this.library.remove(book);
    }

    public String findLocationBook(Book book) {
        String location = this.library.get(book);
        if (location == null) {
            System.out.println("Book don't found");
        }
        return location;
    }

    public void printAllBooks() {
        System.out.println(this);
    }
}
