package school.faang.task_45262;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class LibrarySystem {
    private final Map<Book, String> books;

    public void addBook(Book book, String position) {
        books.put(book, position);
    }

    public void removeBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        return books.getOrDefault(new Book(title, author, year), "There is no such book in the library");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> bookEntry : books.entrySet()) {
            System.out.println(bookEntry.getKey() + " on position: " + bookEntry.getValue());
        }
    }
}
