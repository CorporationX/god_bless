package faang.school.godbless.javahashmap.westeroslibrary;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class Main {
    private final Map<Book, String> bookStringMap;

    public void add(Book book, String location) {
        bookStringMap.put(book, location);
    }

    public String remove(String title, String author, int year) {
        Book bookToDelete = new Book(title, author, year);
        return bookStringMap.remove(bookToDelete);
    }

    public String get(String title, String author, int year) {
        Book bookToGet = new Book(title, author, year);
        return bookStringMap.getOrDefault(bookToGet, "There is no book with such specifications");
    }

    public String printAll() {
        return bookStringMap.entrySet().stream()
                .map(entry -> String.format(
                        "Title=%s, Author=%s, Year=%d, Location=%s\n",
                        entry.getKey().getTitle(),
                        entry.getKey().getAuthor(),
                        entry.getKey().getYear(),
                        entry.getValue()
                ))
                .reduce("", String::concat);
    }

    @Override
    public String toString() {
        return "Main{" +
                "bookStringMap=" + bookStringMap +
                '}';
    }
}
