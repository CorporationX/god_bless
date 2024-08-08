package library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> test = new HashMap<>();
        test.put(new Book("Гарри Потер", "Джоан Роулинг", 2007), "First");
        test.put(new Book("Война и мир", "Толстой", 1888), "Second");
        test.put(new Book("Доктор Айболит", "Чуковский", 1930), "Third");
        test.put(new Book("Незнайка", "Носов", 1960), "Fourth");

        Book.outputBook(test);
        Book.searchBook(test, "Гарри Потер", "Джоан Роулинг", 2007);
        Book.addBook(test, "five", "Аяз", "Успешный успех", 1231);
        Book.removeBook(test, "Война и мир", "Толстой", 1888);
        Book.outputBook(test);
    }
}
