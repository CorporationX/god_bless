package faang.school.godbless.BJS2_4126;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();

        library.put(new Book("Книга 1", "Автор 1", 2024), "Адрес 1");
        library.put(new Book("Книга 2", "Автор 2", 2023), "Адрес 2");
        library.put(new Book("Книга 3", "Автор 3", 2022), "Адрес 3");

        printAllBooks(library);

        System.out.println("Добавили новую книгу");
        addBook(new Book("Книга 4", "Автор 4", 2021), "Адрес 4", library);
        printAllBooks(library);

        removeBook("Книга 4", "Автор 4", 2021, library);
        System.out.println("Удалили книгу 4");
        printAllBooks(library);

        System.out.println("Поиск книгу 4");
        System.out.println(findAddressByBook("Книга 2", "Автор 2", 2023, library));
    }

    public static void addBook(Book book, String address, Map<Book, String> target) {
        target.put(book, address);
    }

    public static void removeBook(String title, String author, int year, Map<Book, String> target) {
        Book bookBeingDeleted = new Book(title, author, year);
        target.remove(bookBeingDeleted);
    }

    public static String findAddressByBook(String title, String author, int year, Map<Book, String> target) {
        Book bookToFind = new Book(title, author, year);
        String address = target.get(bookToFind);

        if (address == null) {
            throw new IllegalArgumentException(String.format("Книга \"%s\", Автор \"%s\", Год издания \"%s\" не найдена", title, author, year));
        }

        return address;
    }

    public static void printAllBooks(Map<Book, String> target) {
        System.out.println("Список всех книг и их местонахождений:");
        for (Map.Entry<Book, String> entry : target.entrySet()) {
            Book book = entry.getKey();
            String address = entry.getValue();
            System.out.printf("Книга \"%s\", Автор \"%s\", Год издания \"%s\", Адрес \"%s\"", book.getTitle(), book.getAuthor(), book.getYear(), address);
            System.out.println();
        }
    }
}
