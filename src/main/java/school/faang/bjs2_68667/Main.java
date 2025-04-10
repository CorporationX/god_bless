package school.faang.bjs2_68667;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("War and Peace", "Leo Tolstoy", 1869, "Hall 1, rack A");
        library.addBook("1984", "George Orwell", 1949, "Hall 2, rack B");
        library.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "Hall 3, rack C");

        System.out.println("\nAll books in the library:");
        library.printAllBook();

        String location = library.findBook("1984", "George Orwell", 1949);
        System.out.println("\nLocation of the book '1984': " + location);

        library.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);

        System.out.println("\nBooks after deleting 'To Kill a Mockingbird':");
        library.printAllBook();

        try {
            location = library.findBook("To Kill a Mockingbird",
                    "Harper Lee", 1960);
            System.out.println("\nLocation of the book 'To Kill a Mockingbird': " + location);
        } catch (BookNotFoundException ex) {
            System.out.println("\n" + ex.getMessage());
        }

    }
}
