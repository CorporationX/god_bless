package school.faang.BJS2_59115;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.addBook("Book1", "Author1", 2000, "P1");
        LibrarySystem.addBook("Book2", "Author2", 2003, "P2");

        LibrarySystem.printAllBooks();
        System.out.println(LibrarySystem.findBook("Book1", "Author1", 2000));

        System.out.println(LibrarySystem.removeBook("Book1", "Author1", 2000));

        System.out.println("--------------------------");

        LibrarySystem.printAllBooks();
    }
}
