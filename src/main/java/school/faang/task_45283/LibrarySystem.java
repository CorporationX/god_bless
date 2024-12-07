package school.faang.task_45283;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            books.remove(book);
        } else {
            System.out.println("Данная книга отсутсвует в списке! Поробуйте удалить другую.");
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            return books.get(book);
        } else {
            System.out.println("Данная книга отсутвует в списке!");
            return null;
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println("Книга " + entry.getKey().getTitle() + ", автор " + entry.getKey().getAuthor()
                    + ", год издания " + entry.getKey().getYear() + " - лежит на полке №" + entry.getValue());
        }
    }
}
