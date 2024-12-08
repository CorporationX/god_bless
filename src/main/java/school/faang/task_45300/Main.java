package school.faang.task_45300;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Война и Мир", "Толстой", 2000, "15");
        librarySystem.addBook("Евгений Онегин", "Пушкин", 2002, "10");
        librarySystem.addBook("Отцы и дети", "Достоевский", 2000, "12");
        librarySystem.addBook("Вий", "Горький", 2001, "12");

        librarySystem.findBook("Евгений Онегин", "Пушкин", 2002);
        librarySystem.printAllBooks();
        librarySystem.removeBook("Вий1", "Горький", 2001);
        librarySystem.printAllBooks();
    }
}
