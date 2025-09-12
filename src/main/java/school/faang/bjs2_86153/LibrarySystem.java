package school.faang.bjs2_86153;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public class LibrarySystem {
    private final HashMap<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookLocation.put(new Book(title, author, year), location);
        System.out.println("Книга была добавлена на полку");

    }

    public void removeBook(String title, String author, int year) {
        if (bookLocation.remove(new Book(title, author, year)) != null) {
            System.out.println("Вы убрали книгу с полки");
        } else {
            System.out.println("Такой книги не существует!");
        }
    }

    public void findBook(String title, String author, int year) {
        if (bookLocation.containsKey(new Book(title, author, year))) {
            System.out.println("Местонахождение книги - " + bookLocation.get(new Book(title, author, year)));
        } else  {
            System.out.println("Книга не найдена");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.printf("%s, location = %s%n",  entry.getKey(), entry.getValue());
        }
    }
}
