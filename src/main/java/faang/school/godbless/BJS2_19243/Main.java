package faang.school.godbless.BJS2_19243;

import java.util.*;

public class Main {

    private final String NO_SUCH_BOOK_MESSAGE = "There is no such book in library";

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

    public void deleteBook(String title, String author, Integer year) {
        Book book = library.keySet().stream()
                .filter(b -> b.getTitle().equals(title) && b.getAuthor().equals(author) && b.getYear().equals(year))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(NO_SUCH_BOOK_MESSAGE));
        library.remove(book);
    }

    public String findBookShelf(String title, String author, Integer year) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            if (entry.getKey().getTitle().equals(title)
                    && entry.getKey().getAuthor().equals(author)
                    && entry.getKey().getYear().equals(year)) {
                return String.format("Your book is on %s shelf", entry.getValue());
            }
        }
        return NO_SUCH_BOOK_MESSAGE;
    }

    public List<String> getAllBooks() {
        return library.entrySet()
                .stream()
                .map(entry -> String.format("%s, shelter: %s", entry.getKey().toString(), entry.getValue()))
                .toList();
    }
}
