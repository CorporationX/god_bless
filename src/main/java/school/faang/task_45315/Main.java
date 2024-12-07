package school.faang.task_45315;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.addBook("The Hobbit", "J. R. R. Tolkien", 1954, "First");
        LibrarySystem.addBook("Hogwarts", "J. Rowling", 1954, "Second");
        LibrarySystem.findBook("The Hobbit", "J. R. R. Tolkien", 1954);
        LibrarySystem.printAllBooks();
        LibrarySystem.removeBook("The Hobbit", "J. R. R. Tolkien", 1954);
        LibrarySystem.printAllBooks();
    }
}