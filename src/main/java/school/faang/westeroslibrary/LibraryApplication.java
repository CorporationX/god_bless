package school.faang.westeroslibrary;

public class LibraryApplication {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Добавление книг
        library.addBook("physics", "phys", 1000, "Полка 1");
        library.addBook("mathematics", "math", 500, "Полка 2");

        library.findBook("physics", "phys", 1000);

        library.removeBook("mathematics", "math", 500);

        library.printAllBooks();
    }
}
