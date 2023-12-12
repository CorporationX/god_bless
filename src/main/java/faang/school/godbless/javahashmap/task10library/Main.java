package faang.school.godbless.javahashmap.task10library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static void main(String... args) {
        initLibrary();
        addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 1951), "Стул");
        removeBook("dfs", "rdh", 2000);
        removeBook("The Catcher in the Rye", "J.D. Salinger", 1951);
        infoBook("The Catcher in the Rye", "J.D. Salinger", 1951);
        infoBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        infoLibrary();
    }

    public static void initLibrary() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949);

        library.put(book1, "Полки");
        library.put(book2, "Шкаф");
        library.put(book3, "Стол");

        System.out.println("Книги добавлены в библиотеку");
    }

    public static void addBook(Book book, String place) {
        library.put(book, place);
        System.out.println("Добавлена книга со следующими данными   Название: " + book.getTitle() + "  Автор: " + book.getAuthor() + "  Год: " + book.getYear());

    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println("Удалена книга со следующими данными   Название: " + book.getTitle() + "  Автор: " + book.getAuthor() + "  Год: " + book.getYear());
        } else {
            System.out.println("Ошибка удаления, нет книги со следующими данными   Название: " + title + "  Автор: " + author + "  Год: " + year);
        }
    }

    public static void infoBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (library.containsKey(book)) {
            System.out.println(library.get(book) + " - местонахождение книги со следующими данными   Название: " + book.getTitle() + "  Автор: " + book.getAuthor() + "  Год: " + book.getYear());
        } else {
            System.out.println("Получить информацию невозможно, нет книги со следующими данными   Название: " + title + "  Автор: " + author + "  Год: " + year);
        }
    }

    public static void infoLibrary() {
        System.out.println(" Info о книгах:");
        System.out.println("*******************************************************************");
        int count = 0;

        for (Map.Entry<Book, String> entry : library.entrySet()) {
            count++;
            System.out.println(count + ". Название: " + entry.getKey().getTitle() + "  Автор: " + entry.getKey().getAuthor() + "  Год: " + entry.getKey().getYear() + "  Местонахождение: " + entry.getValue());
        }

        System.out.println("*******************************************************************");
    }
}
