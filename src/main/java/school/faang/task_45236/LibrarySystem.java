package school.faang.task_45236;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (!library.containsKey(book)) {
            library.put(book, location);
            System.out.println(book.toString() + " добавлена.\n");
        } else {
            System.out.println("Такая книга уже есть.\n");
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println(book.toString() + " удалена\n");
        } else {
            System.out.println("данная книга отсутствует в библиотеке\n");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("книга " + title.toString() + " находится на " + library.get(book));
        } else {
            System.out.println("Книга не найдена в библиотеке");
        }
    }

    public void printAllBook() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("книга " + entry.getKey() + " находится на " + entry.getValue());
        }
        System.out.println();
    }
}
