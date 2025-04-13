package BJS2_69795;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Книга 1", "Автор 1", 1000, "1 полка");
        librarySystem.addBook("Книга 2", "Автор 2", 1001, "2 полка");
        librarySystem.addBook("Книга 3", "Автор 3", 1002, "3 полка");
        librarySystem.addBook("Книга 4", "Автор 4", 1003, "4 полка");
        librarySystem.addBook("Книга 5", "Автор 5", 1004, "5 полка");

        librarySystem.removeBook("Книга 1", "Автор 1", 1000);

        System.out.println(librarySystem.findBook("Книга 3", "Автор 3", 1002));

        System.out.println(librarySystem.printAllBooks());
    }
}
