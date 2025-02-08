package school.faang.BJS2_57129;

public class Main {

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        try {
            librarySystem.addBook(null, "Лев Толстой", 1869, "3");
        } catch (IllegalArgumentException e) {
            System.out.println("Внимание: " + e.getMessage());
        }

        librarySystem.addBook("Новая жизнь", "Дмитрий Охара", 2018, "123");
        librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "3");

        librarySystem.findBook("Война и мир", "Лев Толстой", 1869);
        librarySystem.findBook("Философия Java", "Брюс Эккель", 2010);

        librarySystem.removeBook("Война и мир", "Лев Толстой", 1869);

        librarySystem.printAllBooks();
    }
}
