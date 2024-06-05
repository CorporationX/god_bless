package faang.school.godbless.libraryvesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();

        library.put(new Book("Книга1", "Автор 1", 1950), "Полка 1");
        library.put(new Book("Книга2", "Автор 2", 1970), "Полка 2");
        library.put(new Book("Книга3", "Автор 3", 1980), "Полка 3");
        library.put(new Book("Книга4", "Автор 4", 1990), "Полка 4");
        library.put(new Book("Книга2", "Автор 2", 1960), "Полка 5");

        addBook(library, new Book("Новая книга", "Новый автор", 2000), "Новая полка");
        System.out.println(library);

        removeBook(library, new Book("Книга3", "Автор 3", 1980));
        System.out.println(library);

        getShelf(library, new Book("Книга2", "Автор 2", 1960));
        getInfoLibrary(library);

    }

    public static void addBook(Map<Book, String> library, Book book, String shelf) {
        library.put(book, shelf);
    }

    public static void removeBook(Map<Book, String> library, Book book) {
        library.remove(book);
    }

    public static void getShelf(Map<Book, String> library, Book book) {
        System.out.println(library.get(book));
    }

    public static void getInfoLibrary (Map<Book, String> library) {
        for (Map.Entry<Book, String> bookEntry : library.entrySet()) {
            System.out.println("Книга - " + bookEntry.getKey() + ", полка - " + bookEntry.getValue());
        }
    }
}
