package school.faang.bjs2_33115;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

public class Main {
    private static final Logger LOG = getLogger(Book.class);
    private static Map<Book, String> library = new HashMap<>();

    private Main() {
    }

    public static void main(String[] args) {
        Book book1 = new Book("Дар", "Набоков В.В.", 1938);
        Book book2 = new Book("Каштанка", "Чехов А.П.", 1887);
        Book book3 = new Book("Преступление и наказание", "Достоевский Ф.М.", 1886);

        addBook(book1, "1");
        addBook(book2, "2");
        addBook(book1, "1");

        System.out.println(book1.equals(book2));
        System.out.println(book2.equals(book3));

        deleteBook(book3);
        deleteBook(book2);

        searchBook(book2);
        searchBook(book3);

        displayingLibrary();
    }

    public static void addBook(Book book, String location) {
        if (!library.containsKey(book)) {
            library.putIfAbsent(book, location);
            LOG.info("Книга успешно добавлена");
        } else {
            LOG.error("Книга уже существует");
        }
    }

    public static void deleteBook(Book book) {
        if (library.containsKey(book)) {
            library.remove(book);
            LOG.info("Книга успешно удалена");
        } else {
            LOG.error("Книга не найдена");
        }
    }

    public static void searchBook(Book book) {
        if (library.containsKey(book)) {
            LOG.info("Книга найдена и находится на полке " + library.get(book));
        } else {
            LOG.error("К сожалению, указанная вами книга отстутсвует в библиотеке");
        }
    }

    public static void displayingLibrary() {
        for (Map.Entry<Book, String> book : library.entrySet()) {
            System.out.println(book);
        }
    }
}
