package faang.school.godbless.BJS2_19243;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {

    private final Map<Book, String> library = new HashMap<>();

    {
        Book book1 = Book.builder()
                .title("Ruslan and Liudmila")
                .author("Pushkin")
                .year(1735)
                .build();
        Book book2 = Book.builder()
                .title("Crime and punishment")
                .author("Dostoevskii")
                .year(1835)
                .build();
        Book book3 = Book.builder()
                .title("Master and Margarita")
                .author("Bulgakov")
                .year(1935)
                .build();
        library.put(book1, "1");
        library.put(book2, "2");
        library.put(book3, "3");
    }

    public void addBook(Book book, String shelf) {
        library.put(book, shelf);
    }

    public boolean deleteBook(String title, String author, Integer year) {
        return library.keySet().removeIf(book -> Objects.equals(book.getTitle(), title)
                && Objects.equals(book.getAuthor(), author)
                && Objects.equals(book.getYear(), year));
    }

    public String findBookShelf(String title, String author, Integer year) {
        Book book = new Book(title, author, year);
        String shelf = library.get(book);
        if (shelf != null) {
            return String.format("Your book is on %s shelf", shelf);
        } else {
            return "There is no such book in library";
        }
    }

    public List<String> getAllBooks() {
        return library.entrySet()
                .stream()
                .map(entry -> String.format("%s, shelter: %s", entry.getKey().toString(), entry.getValue()))
                .toList();
    }
}
