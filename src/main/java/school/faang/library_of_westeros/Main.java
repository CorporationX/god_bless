package school.faang.library_of_westeros;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("1984", "George Orwell", 1949, "A1");
        library.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "B2");
        library.addBook("1984", "George Orwell", 1949, "A2");

        library.printAllBooks();

        library.removeBook("1984", "George Orwell", 149);
        library.removeBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);

        library.printAllBooks();
        library.findBook("1984", "George Orwell", 1949);
    }
}

