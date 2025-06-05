package school.faang.bjs2_79659;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Преступление и наказание", "Фёдор Достоевский", 1866, "1/2");
        librarySystem.addBook("Мастер и Маргарита", "Михаил Булгаков", 1967, "3");
        librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "7");

        librarySystem.printAllBooks();

        librarySystem.removeBook("Преступление и наказание", "Фёдор Достоевский", 1866);
        librarySystem.removeBook("Война и мир", "Лев Толстой", 1869);
        librarySystem.removeBook("test", "Лев Толстой", 1869);

        String bookShelf = librarySystem.findBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
        System.out.printf("Расположение книги: %s\n", bookShelf);

        librarySystem.printAllBooks();
    }
}
