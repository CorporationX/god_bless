package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "Shelf 1");
        library.addBook("1984", "George Orwell", 1949, "Shelf 2");
        library.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "Shelf 3");

        library.printAllBooks();

        library.findBook("1984", "George Orwell", 1949);
        library.findBook("Moby Dick", "Herman Melville", 1851);

        library.removeBook("The Hobbit", "J.R.R. Tolkien", 1937);
        library.removeBook("The Hobbit", "J.R.R. Tolkien", 1937);

        library.printAllBooks();
    }
}
