package school.faang.bjs286069;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem
            .addBook("The Old Man and The Sea", "Ernest Hemingway", 1976, "2 ряд");
        librarySystem
            .addBook("The Catcher in the Rye", "Jerome David Salinger", 1986, "3 ряд");
        librarySystem.printAllBooks();

        System.out.println(librarySystem.findBook("The Old Man and The Sea", "Ernest Hemingway", 1976));


        librarySystem.removeBook("The Catcher in the Rye", "Jerome David Salinger", 1986);
        librarySystem.printAllBooks();


    }
}
