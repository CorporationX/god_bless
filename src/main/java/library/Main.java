package library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> shelfnumberByBook= new HashMap<>();
        shelfnumberByBook.put(new Book("Гарри Потер", "Джоан Роулинг", 2007), "First");
        shelfnumberByBook.put(new Book("Война и мир", "Толстой", 1888), "Second");
        shelfnumberByBook.put(new Book("Доктор Айболит", "Чуковский", 1930), "Third");
        shelfnumberByBook.put(new Book("Незнайка", "Носов", 1960), "Fourth");

        Book.outputBook(shelfnumberByBook);
        Book.searchBook(shelfnumberByBook, "Гарри Потер", "Джоан Роулинг", 2007);
        Book.addBook(shelfnumberByBook, "five", "Аяз", "Успешный успех", 1231);
        Book.removeBook(shelfnumberByBook, "Война и мир", "Толстой", 1888);
        Book.outputBook(shelfnumberByBook);
    }
}
