package BJS2_19431;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final HashMap<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        addBook("Гарри Поттер и Философский камень", "Дж.К. Роулинг", 1997, "#3");
        addBook("Гарри Поттер и Тайная комната", "Дж.К. Роулинг", 1997, "#2");
        addBook("Гарри Поттер и узник Азкабана", "Дж.К. Роулинг", 1997, "#1");
        getBookInfo("Гарри Поттер и Философский камень", "Дж.К. Роулинг", 1997);
        removeBook("Гарри Поттер и Тайная комната", "Дж.К. Роулинг", 1997);
        getAllBooks();
    }

    public static void addBook(String title, String author, int year, String shelf) {
        Book newBook = new Book(title, author, year);
        library.put(newBook, shelf);
    }

    public static void removeBook(String title, String author, int year) {
        Book removedBook = new Book(title, author, year);
        library.remove(removedBook);
    }

    public static void getBookInfo(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.printf("Книга %s, %d года находится на полке %s%n", book.getTitle(), book.getYear(), library.get(book));
        } else {
            System.out.println("Кажется такой книги не существует.");
        }
    }

    public static void getAllBooks() {
        if (!library.isEmpty()) {
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                Book book = entry.getKey();
                String shelf = entry.getValue();
                System.out.printf(
                        "Наименование: %s, Автор: %s, Год: %d, Полка: %s%n",
                        book.getTitle(),
                        book.getAuthor(),
                        book.getYear(),
                        shelf
                );
            }
        }
    }
}
