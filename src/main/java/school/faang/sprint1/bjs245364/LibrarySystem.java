package school.faang.sprint1.bjs245364;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    public void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        library.put(new Book("Поэзия XX века", "А. С. Пушкин", 1911), "001");
        library.put(new Book("Преступление и наказание", "Ф. М. Достоевский", 1915), "001");
        library.put(new Book("Искусство как наука", "Меллер", 1813), "020");
        library.put(new Book("История древнего мира", "Платон", 89), "001");
        library.put(new Book("Риторика", "Аристотель", 15), "195");

        String shelfForNewBook = "003";
        addBook("Новая книга", "Виктор Гюго", 2024, shelfForNewBook, library);
        removeBook("Поэзия XX века", "А. С. Пушкин", 1911, library);
        findBook("Риторика", "Аристотель", 15, library);
        printAllBooks(library);
    }

    public static void addBook(String title, String author, int year, String location, Map<Book, String> books) {
        Book book = new Book(title, author, year);
        books.putIfAbsent(book, location);
        System.out.println("Книга '" + book.getTitle() + "' добавлена на " + location + "-ю полку.");
    }

    public void removeBook(String title, String author, int year, Map<Book, String> books) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            books.remove(book);
            System.out.println("Книга '" + book.getTitle() + "' удалена.");
        } else {
            System.out.println("Такой книги нет в библиотеке!");
        }
    }

    public void findBook(String title, String author, int year, Map<Book, String> books) {
        Book book = new Book(title, author, year);
        if (books.get(book) != null) {
            System.out.println("Книга '" + book.getTitle() + "' лежит на " + books.get(book) + "-й полке.");
        } else {
            System.out.println("Книга '" + book.getTitle() + " не найдена!");
        }
    }

    public void printAllBooks(Map<Book, String> books) {
        System.out.println("\nСписок всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().toString() + "лежит на " + entry.getValue() + "-й полке.");
        }
    }
}
