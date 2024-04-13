package faang.school.godbless.BJS2_5359;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        library.put(new Book("Книга 1", "Aвтор 1", 1878), "Полка 1");
        library.put(new Book("Книга 2", "Aвтор 2", 1991), "Полка 2");
        library.put(new Book("Книга 3", "Aвтор 3", 1881), "Полка 3");

        printAllBooks(library);

        System.out.println("Добавили новую книгу");
        addBook(new Book("Книга 4", "Aвтор 4", 2021), "Полка 4", library);
        printAllBooks(library);
        removeBook("Книга 4", "Aвтор 4", 2021, library);
        System.out.println("Удалили книгу 4");
        printAllBooks(library);
        System.out.println("Поиск книги 2");
        System.out.println(findShelfByBook("Книга 2", "Aвтор 2", 1991, library));
    }

    public static void addBook(Book book, String shelf, Map<Book, String> library) {
        library.put(book, shelf);
    }

    public static void removeBook(String title, String author, int year, Map<Book, String> library) {
        library.remove(new Book(title, author, year));
    }

    public static String findShelfByBook(String title, String author, int year, Map<Book, String> target) {
        Book bookToFind = new Book(title, author, year);
        String shelf = target.get(bookToFind);

        if (shelf == null) {
            throw new IllegalArgumentException("Книга не найдена");
        }

        return shelf;
    }

    public static void printAllBooks(Map<Book, String> target) {
        System.out.println("Список всех книг и их места:");
        for (Map.Entry<Book, String> entry : target.entrySet()) {
            Book book = entry.getKey();
            String shelf = entry.getValue();
            System.out.printf("Книга \"%s\", Автор \"%s\", Год издания \"%s\", Полка \"%s\"", book.getTitle(), book.getAuthor(), book.getYear(), shelf);
            System.out.println();
        }
    }
}
