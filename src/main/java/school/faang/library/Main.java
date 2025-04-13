package school.faang.library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Война и мир", "Л. Толстой", 1867, "Верхняя полка");
        librarySystem.addBook("Война", "Л", 67, "Средняя полка");
        librarySystem.addBook("Мир", "Толстой", 18, "Нижняя полка");

        librarySystem.printAllBooks();
        librarySystem.removeBook("Нет", "Т", 0);
        librarySystem.removeBook("Война", "Л", 67);
        librarySystem.printAllBooks();
        librarySystem.findBook("Мир", "Толстой", 18);
        librarySystem.findBook("Нет", "Т", 0);
    }
}
