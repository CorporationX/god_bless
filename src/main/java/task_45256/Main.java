package task_45256;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        addBooksInformation(librarySystem);
        librarySystem.findBook("Властелин колец", "Джон Р. Р. Толкин", 1954);
        librarySystem.findBook("Хоббит", "Джон Р. Р. Толкин", 1954);
        librarySystem.removeBook("Гарри Поттер и Кубок огня", "Джоан Роулинг", 2000);
        librarySystem.printAllBooks();
    }

    private static void addBooksInformation(LibrarySystem librarySystem ) {
        librarySystem.addBook("Властелин колец", "Джон Р. Р. Толкин", 1954, "1");
        librarySystem.addBook("Гордость и предубеждение", "Джейн Остин", 1813, "1");
        librarySystem.addBook("Тёмные начала", "Филип Пулман", 1995, "2");
        librarySystem.addBook("Автостопом по галактике", "Дуглас Адамс", 1979, "1");
        librarySystem.addBook("Гарри Поттер и Кубок огня", "Джоан Роулинг", 2000, "3");
    }
}
