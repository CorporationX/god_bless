package school.faang.westeroslibrary79640;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    public static Map<Book, String> libraryMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        libraryMap.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        String deleteBook = libraryMap.remove(new Book(title, author, year));
        if (deleteBook == null) {
            System.out.println("Такой книги в хранилище нет");
        }
        System.out.println("Книга удалена");
    }

    public void findBook(String title, String author, int year) {
        String location = libraryMap.get(new Book(title, author, year));
        if (location != null) {
            System.out.println("Книга храниться в " + location);
        } else {
            System.out.println("Данной книги нет в хранилище");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> map : libraryMap.entrySet()) {
            System.out.println(map.getKey() + "хранится в ранилище " + map.getValue());
        }
    }
}
