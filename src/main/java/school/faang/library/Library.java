package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private static final Map<Book, String> mapBooks = new HashMap<>();

    public static void main(String[] args) {
        Book harryPotter1 = new Book("Гарри Поттер и философский камень", "Дж. Роулинг", 2000);
        Book harryPotter2 = new Book("Гарри Поттер и Тайная комната", "Джю Роулинг", 2001);
        Book mirrorOfDestiny = new Book("Зеркало судьбы", "Андрэ Нортон", 1950);
        Book warAndPeace = new Book("Война и мир", "Лев Толстой", 1890);
        Book witcher = new Book("", "", 0);

        addBook(harryPotter1, "1.32");
        addBook(harryPotter2, "1.33");
        addBook(mirrorOfDestiny, "1.55");
        addBook(warAndPeace, "4.29");
        addBook(null, "3.1");
        addBook(witcher, null);

        printListBook();
        infoShelvingNumb(witcher);
        deleteBook(null);
        deleteBook(witcher);
        printListBook();
    }

    private static void addBook(Book book, String shelvingNumb) {
        if (book == null) {
            System.out.println("Введите название книги");
        } else {
            if (shelvingNumb != null && !shelvingNumb.isBlank()) {
                mapBooks.put(book, shelvingNumb);
            } else {
                System.out.println("Введите номер стеллажа");
            }
        }
    }

    private static void deleteBook(Book book) {
        if (book != null) {
            mapBooks.remove(book);
        }
    }

    private static void infoShelvingNumb(Book book) {
        if (book != null) {
            System.out.println(mapBooks.get(book));
        }
    }

    private static void printListBook() {
        for (Map.Entry<Book, String> entry : mapBooks.entrySet()) {
            System.out.println(entry);
        }
    }
}