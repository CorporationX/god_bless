package school.faang.library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Король", "Антон антонович", 2009, "шкаф1");
        librarySystem.addBook("Пень", "Антон антонович", 2009, "шкаф2");
        System.out.println(librarySystem.printAllBooks());

        librarySystem.removeBook("Король", "Антон антонович", 2009);
        System.out.println(librarySystem.printAllBooks());

        System.out.println(librarySystem.findBook("Король", "Антон антонович", 2009));
        System.out.println(librarySystem.findBook("Пень", "Антон антонович", 2009));
    }
}
