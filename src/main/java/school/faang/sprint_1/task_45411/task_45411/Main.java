package school.faang.sprint_1.task_45411.task_45411;

public class Main {
    public static void main(String[] args) {
        LibrarySystem books = new LibrarySystem();

        System.out.println("""
                         _____________________________________________________________________________________
                                                 Adding different books to the same shelf
                         _____________________________________________________________________________________
                """);
        books.addBook("One Hundred Years of Solitude", "Marquez", 1967, "Shelf G2");
        books.addBook("Dune", "Herbert", 1965, "Shelf G2");
        books.printAllBooks();

        System.out.println("""
                         _____________________________________________________________________________________
                                    Adding several books to the different shelf and delete one
                         _____________________________________________________________________________________
                """);
        books.addBook("The Lord of the Rings", "Tolkien", 1954, "Shelf A1");
        books.addBook("The Lord of the Rings", "Tolkien", 1954, "Shelf F5");
        books.addBook("The Lord of the Rings", "Tolkien", 1954, "Shelf C4");
        books.addBook("The Lord of the Rings", "Tolkien", 1954, "Shelf G15");
        books.findBook("The Lord of the Rings", "Tolkien", 1954);
        books.removeBook("The Lord of the Rings", "Tolkien", 1954);
        books.findBook("The Lord of the Rings", "Tolkien", 1954);

        System.out.println("""
                         _____________________________________________________________________________________
                          Adding and searching for a book. Attempting to delete and search for a missing book.
                         _____________________________________________________________________________________
                """);
        books.addBook("And Then There Were None", "Christie", 1939, "Shelf B1");
        books.findBook("And Then There Were None", "Christie", 1939);
        books.removeBook("And Then There Were None", "Christie", 1939);
        books.findBook("And Then There Were None", "Christie", 1939);

        System.out.println("""
                         _____________________________________________________________________________________
                                                 Adding a book with an invalid info
                         _____________________________________________________________________________________
                """);
        books.addBook("The Great Gatsby", "", 1925, "Shelf C1");
        books.addBook("One Hundred Years of Solitude", "Marquez", 1967, "Shelf E2");

        System.out.println("""
                         _____________________________________________________________________________________
                                                 Adding and printing all books
                         _____________________________________________________________________________________
                """);
        books.addBook("Pride and Prejudice", "Austen", 1813, "Shelf C5");
        books.addBook("The Hobbit", "Tolkien", 1937, "Shelf A2");
        books.addBook("1984", "Orwell", 1949, "Shelf D1");
        books.addBook("To Kill a Mockingbird", "Lee", 1960, "Shelf E3");
        books.addBook("The Catcher in the Rye", "Salinger", 1951, "Shelf F9");
        books.addBook("One Hundred Years of Solitude", "Marquez", 1967, "Shelf B1");
        books.addBook("One Hundred Years of Solitude", "Marquez", 1967, "Shelf M4");
        books.addBook("The Lord of the Rings", "Tolkien", 1954, "Shelf A1");
        books.addBook("And Then There Were None", "Christie", 1939, "Shelf D1");
        books.printAllBooks();
    }
}
