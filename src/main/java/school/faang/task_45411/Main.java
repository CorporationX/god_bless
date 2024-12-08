package school.faang.task_45411;

public class Main {
    public static void main(String[] args) {
        LibrarySystem books = new LibrarySystem();
        books.addBook("Pride and Prejudice", "Austen", 1813, "Shelf C5");
        books.addBook("The Hobbit", "Tolkien", 1937, "Shelf A2");
        books.addBook("Dune", "Herbert", 1965, "Shelf B7");
        books.addBook("1984", "Orwell", 1949, "Shelf D1");
        books.addBook("To Kill a Mockingbird", "Lee", 1960, "Shelf E3");
        books.addBook("The Catcher in the Rye", "Salinger", 1951, "Shelf F9");
        books.addBook("One Hundred Years of Solitude", "Marquez", 1967, "Shelf G2");
        books.addBook("One Hundred Years of Solitude", "Marquez", 1967, "Shelf E2");
        books.addBook("The Lord of the Rings", "Tolkien", 1954, "Shelf A1");
        books.addBook("And Then There Were None", "Christie", 1939, "Shelf B1");
        books.addBook("The Great Gatsby", "Fitzgerald", 1925, "Shelf C1");

        books.addBook("The Great Gatsby", "", 1925, "Shelf C1");

        books.printAllBooks();
        books.addBook("And Then There Were None", "Christie", 1939, "Shelf D1");

        books.removeBook("To Kill a Mockingbird", "Lee", 1960);
        books.removeBook("To Kill a Mockingbird", "Lee", 1960);
        books.findBook("To Kill a Mockingbird", "Lee", 1960);

        books.findBook("One Hundred Years of Solitude", "Marquez", 1967);
        books.removeBook("One Hundred Years of Solitude", "Marquez", 1967);
        books.findBook("One Hundred Years of Solitude", "Marquez", 1967);

        books.findBook("1984", "Orwell", 1949);
        books.findBook("The Hobbit", "Tolkien", 1937);

        books.printAllBooks();
    }
}
