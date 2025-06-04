package school.faang.BJS2_79659;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Преступление и наказание", "Фёдор Достоевский", 1866, "1/2");
        librarySystem.addBook("Мастер и Маргарита", "Михаил Булгаков", 1967, "3");
        librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "7");

        librarySystem.printAllBooks();

        librarySystem.removeBook("Преступление и наказание", "Фёдор Достоевский", 1866);
        librarySystem.removeBook("Война и мир", "Лев Толстой", 1869);

        String bookShelf = librarySystem.findBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
        System.out.println(
                (bookShelf != null && !bookShelf.isEmpty())
                        ? "Книга находится на полке: " + bookShelf :
                        "Книга не найдена"
        );

        librarySystem.printAllBooks();
    }
}
