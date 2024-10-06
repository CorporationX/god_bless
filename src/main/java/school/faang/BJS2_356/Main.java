package school.faang.BJS2_356;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Book, String> library = new HashMap<>();
        library.put(new Book("Соловей", "Кристин Ханна", 2015), "Романы");
        library.put(new Book("Голем", "Питер Акройд", 1949), "Романы");
        library.put(new Book("Чужак", "Стивен Кинг", 1995), "Мистика");
        library.put(new Book("Шедевр", "Элис Броуч", 2000), "Разное");

        Book.receiveAllBooks(library);
        System.out.println("**********");
        Book.addBook(new Book("Адюльтер", "Пауло Коэльо", 1995), "Разное", library);
        Book.receiveAllBooks(library);
        System.out.println("**********");
        Book.receiveBook("Чужак", "Стивен Кинг", 1995, library);
        Book.receiveBook("Чужак", "Стивен Кинг", 2000, library);
        System.out.println("**********");
        Book.receiveBook("Шедевр", "Элис Броуч", 2000, library);
        Book.deleteBook("Шедевр", "Элис Броуч", 2000, library);
        Book.receiveBook("Шедевр", "Элис Броуч", 2000, library);

    }
}
