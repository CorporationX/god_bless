package school.faang.sprint1.westeroslibrary;

public class LibraryDemo {

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystemImpl();

        try {
            System.out.println("Adding books to the library;");
            System.out.println(library.addBook("The Hobbit", "Tolkien", 1937, "shelf 1.1"));
            System.out.println(library.addBook("The Hunger Games", "Suzanne Collins", 2008, "shelf 2.1"));
            System.out.println(library.addBook("1984", "George Orwell", 1949, "shelf 2.2"));
            System.out.println(library.addBook("", "<NAME>", -2, "shelf 3.1"));
            library.printAllBooks();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            ;
        }

        System.out.println("\nRemoving books from the library;");
        System.out.println(library.removeBook("The Hunger Games", "Suzanne Collins", 2008));
        try {
            library.removeBook("The Hunger Games", "Tolkien", 2008);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nSearching for '1984':");
        try {
            String location = library.findBook("1984", "George Orwell", 1949);
            System.out.println("Found at: " + location);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nSearching for a missing book:");
        try {
            library.findBook("Unknown Book", "No Author", 2024);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        library.printAllBooks();
    }

}
