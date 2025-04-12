package school.faang.book;

public class Main {

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Онегин", "Pushkin", 1889, "1A");
        librarySystem.addBook("Детство. Отрочество. Юность", "Tolstoy", 1894, "2D");
        librarySystem.addBook("Бородино", "Lermontov", 1865, "5B");
        librarySystem.addBook("Мертвые души", "Gogol", 1873, "3C");

        librarySystem.removeBook(new Book("Детство. Отрочество. Юность", "Tolstoy", 1894));

        librarySystem.findBook("Мертвые души", "Gogol", 1873);

        librarySystem.printAllBooks();
    }
}
