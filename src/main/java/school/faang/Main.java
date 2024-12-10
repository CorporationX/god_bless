package school.faang;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        library.put(new Book("Поэзия XX века", "А. С. Пушкин", 1911), "001");
        library.put(new Book("Преступление и наказание", "Ф. М. Достоевский", 1915), "001");
        library.put(new Book("Искусство как наука", "Меллер", 1813), "020");
        library.put(new Book("История древнего мира", "Платон", 89), "001");
        library.put(new Book("Риторика", "Аристотель", 15), "195");

        String shelfForNewBook = "003";
        LibrarySystem.addBook("Новая книга", "Виктор Гюго", 2024, shelfForNewBook, library);
        LibrarySystem.removeBook("Поэзия XX века", "А. С. Пушкин", 1911, library);
        LibrarySystem.findBook("Риторика", "Аристотель", 15, library);
        LibrarySystem.printAllBooks(library);
    }
}
