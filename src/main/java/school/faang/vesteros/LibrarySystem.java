package school.faang.vesteros;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!library.containsKey(book)) {
            return;
        }
        library.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            return "Данная книга находится: " + library.get(book);
        } else {
            return "Данной книги нет в библиотеке";
        }
    }

    public void printAllBooks() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Book, String> book : library.entrySet()) {
            sb.append("=".repeat(30)).append("\n");
            sb.append("Книга: ").append(book.getKey().getTitle())
                    .append("\nАвтор: ").append(book.getKey().getAuthor())
                    .append("\nГод издания: ").append(book.getKey().getYear())
                    .append("\nНаходится на полке: ").append(book.getValue());
        }
        sb.append("=".repeat(30));
        System.out.println(sb);
    }
}
