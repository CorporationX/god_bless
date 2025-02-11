package school.faang.sprint1.task_56952;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.printAllBooks();
        librarySystem.removeBook("It", "Steven King", 1986);
        librarySystem.printAllBooks();
        librarySystem.addBook("Harry Potter", "Rouling", 1995, "Shelf 3");
        librarySystem.printAllBooks();
    }
}
