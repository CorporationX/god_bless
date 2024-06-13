package faang.school.godbless.BJS2_8259;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private static final Map<Book, String> library = new HashMap<>();

    public void addBook(String index, Book book) {
        if (library.containsKey(book)) {
            System.out.println("Такая книга уже существует");
            return;
        }
        library.put(book, index);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Книга была удалена с полки " + library.remove(book));
        }
    }

    public void printBookIndex(String title, String author, int year) {
        System.out.println(library.get(new Book(title, author, year)));
    }

    public void printAllBooks() {
        library.forEach((key, value) -> System.out.printf("# полки: %s Название: %s Автор: %s Год: %d \n",
                value, key.getTitle(), key.getAuthor(), key.getYear()));
    }
}
