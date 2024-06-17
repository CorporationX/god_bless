package faang.school.godbless.BJS_8234;

import java.util.HashMap;
import java.util.Map;

public class WesterosLibrary {
    private HashMap<Book, String> westerosLibrary = new HashMap<>();

    public WesterosLibrary() {
    }

    public void addBook(Book book, String placement) {
        westerosLibrary.putIfAbsent(book, placement);
    }

    public void deleteBook(String title, String author, int year) {
        if (libHaveBooks()) {
            Book searchingBook = new Book(title, author, year);
            if (westerosLibrary.containsKey(searchingBook)) {
                westerosLibrary.remove(searchingBook);
            } else {
                System.out.println("We couldn't find the book \"" + title + "\" in our library");
            }
        }
    }

    public void findBook(String title, String author, int year) {
        if (libHaveBooks()) {
            Book searchingBook = new Book(title, author, year);
            if (westerosLibrary.containsKey(searchingBook)) {
                System.out.println("Searching book is locating in: " + westerosLibrary.get(searchingBook));
            } else {
                System.out.println("We couldn't find the book \"" + title + "\" in our library");
            }
        }
    }

    public void getAllBooks() {
        if (libHaveBooks()) {
            int num = 1;
            for (Map.Entry<Book, String> entry : westerosLibrary.entrySet()) {
                String msg = String.format("%d %s written by %s from %d placed %s", num, entry.getKey().getTitle(), entry.getKey().getAuthor(), entry.getKey().getYear(), entry.getValue());
                System.out.println(msg);
                num++;
            }
        }
    }

    private boolean libHaveBooks() {
        if (!westerosLibrary.isEmpty()) {
            return true;
        } else {
            System.out.println("There's no one book in our Library");
            return false;
        }
    }
}
