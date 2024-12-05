package school.faang.task_45272;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Book, String> books = new HashMap<>();
        books.put(new Book("Алфавит", "Неизвестный", 1788), "Писменность");
        books.put(new Book("Проза дракона", "Улкер Ф.А", 1792), "Романтика");
        books.put(new Book("Подъем на гору", "Тайсон М.К.", 1822), "Приключения");
        books.put(new Book("Что там?", "Лом Д.Ю.", 1790), "Детектив");
        books.put(new Book("Булка хлеба. Мало или жирно?", "Маскитов Ш.Щ", 1801), "Кулинария");

        LibrarySystem librarySystem = new LibrarySystem(books);
        librarySystem.printAllBooks();

        System.out.println("-------------------------------------------------");
        librarySystem.addBook("Пьяные истории", "Неизвестный в баре", 1803, "Приключения");
        librarySystem.printAllBooks();

        System.out.println("-------------------------------------------------");
        librarySystem.findBook("Подъем на гору", "Тайсон М.К.", 1822);

        System.out.println("-------------------------------------------------");
        librarySystem.removeBook("Что там?", "Лом Д.Ю.", 1790);
        librarySystem.findBook("Что там?", "Лом Д.Ю.", 1790);

    }
}
