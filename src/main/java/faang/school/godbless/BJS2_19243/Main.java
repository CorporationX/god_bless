package faang.school.godbless.BJS2_19243;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final Map<Book, String> library = new HashMap<>();

    {
        library.put(new Book("Ruslan and Liudmila", "Pushkin", 1735), "1");
        library.put(new Book("Crime and punishment", "Dostoevskii", 1835), "2");
        library.put(new Book("Master and Margarita", "Bulgakov", 1935), "3");
    }

    public void addBook(Book book, String shelf) {
        library.put(book, shelf);
    }

    public boolean deleteBook(String title, String author, Integer year) {
        String result = library.remove(new Book(title, author, year));
        return result != null;
    }

    public String findBookShelf(String title, String author, Integer year) {
        Book book = new Book(title, author, year);
        String shelf = library.get(book);
        if (shelf != null) return String.format("Your book is on %s shelf", shelf);
        else return "There is no such book in library";
    }

    public List<String> getAllBooks() {
        return library.entrySet()
                .stream()
                .map(entry -> String.format("%s, shelter: %s", entry.getKey().toString(), entry.getValue()))
                .toList();
    }
}
