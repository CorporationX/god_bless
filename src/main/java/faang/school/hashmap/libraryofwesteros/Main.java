package faang.school.hashmap.libraryofwesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static private final HashMap<Book, String> mapBooks = new HashMap<>();

    public static void main(String[] args) {
        Book cherryOrchard = new Book("Вишневый сад", "Антон Чехов", 1904);
        Book houseWithMezzanine = new Book("Дом с мезонином", "Антон Чехов", 1896);
        Book seagull = new Book("Чайка", "Антон Чехов", 1896);
        Book theManInTheCase = new Book("Человек в футляре", "Антон Чехов", 1898);
        Book confession = new Book("", "", 0);
        Book sunday = new Book("Воскресение", "Лев Толстой", 1889);

        addBook(cherryOrchard, "");
        addBook(houseWithMezzanine, "A1-2");
        addBook(seagull, "A1-2");
        addBook(theManInTheCase, "A2-4");
        addBook(confession, "А1-2");
        addBook(sunday, "А2-4");

        printListBook();
        infoShelfNumb(sunday);
        deleteBook(sunday);
        printListBook();

    }

    private static void addBook(Book book, String shelfNumb) {
        if (!(shelfNumb.isBlank()) || book == null) {
            mapBooks.put(book, shelfNumb);
        } else {
            System.out.println("Введите название полки");
        }
    }

    private static void deleteBook(Book book) {
        mapBooks.remove(book);
    }

    private static void infoShelfNumb(Book book) {
        System.out.println(mapBooks.get(book));
    }

    private static void printListBook() {
        for (Map.Entry<Book, String> entry : mapBooks.entrySet()) {
            System.out.println(entry);
        }
    }

}
