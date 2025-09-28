package bjs2_87175;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
    }

    public void remove(String title, String author, int year) {
        library.remove(new Book(title, author, year));
        System.out.println("book removed");
    }

    public void findBook(String title, String author, int year) {
        boolean foundBook = library.containsKey(new Book(title, author, year));
        if (foundBook) {
            String result = library.get(new Book(title, author, year));
            System.out.println("Книга найдена: " + result);
        } else {
            System.out.println("Книга не найдена: ");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Книга: " + entry.getKey() + " | Местоположение: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("Первому игроку пригтовиться", "Джордж Мартин", 1996, "Полка 1");
        library.addBook("Шерлок Холмс", "Артур Конан Дойл", 1985, "Полка 2");
        library.findBook("Шерлок Холмс", "Артур Конан Дойл", 1985);
        library.remove("Шерлок Холмс", "Артур Конан Дойл", 1985);
        library.findBook("Шерлок Холмс", "Артур Конан Дойл", 1985);
        library.printAllBooks();

    }
}
