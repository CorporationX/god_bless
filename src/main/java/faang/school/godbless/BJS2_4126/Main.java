package faang.school.godbless.BJS2_4126;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();

        library.put(new Book("Книга 1", "Автор 1", 2024), "Адрес 1");
        library.put(new Book("Книга 2", "Автор 2", 2023), "Адрес 2");
        library.put(new Book("Книга 3", "Автор 3", 2022), "Адрес 3");

        Book.printAllBooks(library);

        System.out.println("Добавили новую книгу");
        Book.addBook(new Book("Книга 4", "Автор 4", 2021), "Адрес 4", library);
        Book.printAllBooks(library);

        Book.removeBook("Книга 4", "Автор 4", 2021, library);
        System.out.println("Удалили книгу 4");
        Book.printAllBooks(library);

        System.out.println("Поиск книгу 4");
        System.out.println(Book.findAddressByBook("Книга 2", "Автор 2", 2023, library));
    }
}
