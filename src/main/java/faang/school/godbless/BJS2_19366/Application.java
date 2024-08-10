package faang.school.godbless.BJS2_19366;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        var book1 = new Book("Book 1", "Author 1", 2005);
        var book2 = new Book("Book 2", "Author 2", 2007);
        var book4 = new Book("Book 4", "Author 3", 2008);
        books.put(book1, "Полка 1");
        books.put(book2, "Полка 2");
        books.put(book4, "Полка 4");

        System.out.println("Добавляется Книга 'Book 3' автора 'Author 3'");
        addBook("Book 3", "Author 3", 2008, "Полка 3");

        System.out.println("Все книги на своих местах");
        printAllBooks();

        System.out.println("Поиск книги 2");
        findBook(book2.getTitle(), book2.getAuthor(), book2.getYear());

        System.out.println("Удаляется книга 1");
        deleteBook(book1.getTitle(), book1.getAuthor(), book1.getYear());

        System.out.println("Книги после удаления:");
        printAllBooks();


    }

    public static void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public static void deleteBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    private static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (books.containsKey(book))
            System.out.println("Книга находиться: " + books.get(book));
        else
            System.out.println("Книга не найдена!");
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " : " + entry.getValue());
        }
    }
}