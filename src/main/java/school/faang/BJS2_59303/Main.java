package school.faang.BJS2_59303;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.addBook("Code Style", "Me", 1923, "слева с верху полки");
        LibrarySystem.printAllBooks();

        LibrarySystem.removeBook("Code Style", "Me", 1923);
        LibrarySystem.printAllBooks();
        LibrarySystem.removeBook("Code Style", "Me", 1923); //проверка на вывода ошибки

        LibrarySystem.addBook("Code Style", "Me", 1923, "слева с верху полки");
        LibrarySystem.findBook("Code Style", "Me", 1923);

    }
}
