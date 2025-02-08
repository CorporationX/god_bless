package school.faang.task_57165;

public class Main {
    public static void main(String[] args) {
        Book effectiveJava3rd = new Book("Effective Java", "Joshua Bloch", 2017);
        Book effectiveJava2nd = new Book("Effective Java", "Joshua Bloch", 2008);
        Book atomicHabits = new Book("Atomic Habits", "James Clear", 2018);

        LibrarySystem.addBook(atomicHabits, "First shelf");
        LibrarySystem.addBook(effectiveJava2nd, "Second shelf");
        LibrarySystem.addBook(effectiveJava3rd, "Second shelf");
        LibrarySystem.printAllBooks();

        LibrarySystem.removeBook(effectiveJava2nd);
        LibrarySystem.findBook(atomicHabits);
        LibrarySystem.findBook(effectiveJava2nd);
    }
}
