package faang.school.godbless.java.sql.library;

import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private final Map<Book, String> libraryMap = new HashMap<>();

    public void addBookToLibrary(String shelf, String title, String author, int year) {
        this.libraryMap.put(new Book(title, author, year), shelf);
    }

    public void removeBookFromLibrary(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (this.libraryMap.containsKey(book)) {
            this.libraryMap.remove(book);
            System.out.println("The book \"" + title + "\" has been removed from library");
        } else {
            System.out.println("No such book \"" + title + "\" was found");
        }
    }

    public void findBookInLibrary(String title, String author, int year) {
        String shelf = this.libraryMap.get(new Book(title, author, year));
        if (shelf != null) {
            System.out.println("The book \"" + title + "\" on the bookshelf: " + shelf);
        } else {
            System.out.println("No such book \"" + title + "\" was found");
        }
    }

    public void showAllBooksInLibrary() {
        for (Map.Entry<Book, String> entry : this.libraryMap.entrySet()) {
            System.out.printf("The book \"%s\", author \"%s\" (year %d) is on the bookshelf - %s%n",
                    entry.getKey().getTitle(), entry.getKey().getAuthor(), entry.getKey().getYear(), entry.getValue());
        }
    }
}
