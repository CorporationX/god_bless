package school.faang.task_45349;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Book1", "Author1", 1901, "location1");
        librarySystem.addBook("Book2", "Author2", 1902, "location2");
        librarySystem.addBook("Book3", "Author3", 1903, "location3");
        librarySystem.addBook("Book4", "Author4", 1904, "location4");
        librarySystem.addBook("Book5", "Author5", 1905, "location5");

        librarySystem.printAllBooks();


        System.out.printf("\nThe book is on shelf: %s\n",
                librarySystem.findBook("Book1", "Author1", 1901));

        if (librarySystem.removeBook("Book2", "Author2", 1902)) {
            System.out.println("The book has been removed\n");
        }

        librarySystem.printAllBooks();
    }
}
