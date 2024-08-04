package faang.school.godbless.task.vesteros.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VesterosLibrary {
    private Map<Book, String> bookStringMap;

    public VesterosLibrary(Map<Book, String> bookStringMap) {
        this.bookStringMap = bookStringMap;
    }

    public void addNewBook(Book book, String location) {
        bookStringMap.put(book, location);
    }

    public void deleteBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        bookStringMap.remove(book);
    }

    public String findBook(String title, String author, int year) {
        return bookStringMap.get(new Book(title, author, year));
    }

    public List<String> findAllBooks() {
        List<String> listOfBooks = new ArrayList<>();
        bookStringMap.forEach((book, location) -> {
            listOfBooks.add(book + " " + location);
        });
        return listOfBooks;
    }
}
