package school.faang.task_79751;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Кот для всех", "Я", 2025, "Первая полка");
        librarySystem.addBook("Кот не для всех", "Я", 2020, "Вторая полка");
        librarySystem.printAllBooks();
        librarySystem.findBook("Кот для всех", "Я", 2025);
        librarySystem.removeBook("Кот для всех", "Я", 2025);
        librarySystem.printAllBooks();
    }
}
