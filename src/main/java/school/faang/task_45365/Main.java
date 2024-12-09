package school.faang.task_45365;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("The Princes in the Tower", "Alison Weir", 1992, "shelf 2");
        librarySystem.addBook("The Year of the Conquest", "David Howarth", 1977, "shelf 5");
        librarySystem.addBook("Katherine", "Anya Seton", 1954, "shelf 7");
        librarySystem.printAllBooks();

        System.out.println();
        librarySystem.removeBook("The Princes in the Tower", "Alison Weir", 1992);
        librarySystem.removeBook("The Year of the Conquest", "WRONG NAME", 1977);
        librarySystem.printAllBooks();

        System.out.println();
        librarySystem.findBook("Katherine", "Anya Seton", 1954);
        librarySystem.findBook("The Pillars of the Earth", "Ken Follett", 1989);
    }
}
