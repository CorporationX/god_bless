package school.faang.task_45284;

public class Main {
    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("1984", "George Orwell", 1949, "history");
        librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "classic");
        librarySystem.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "adventures");
        librarySystem.addBook("The Catcher in the Rye", "J.D. Salinger", 1951, "history");
        librarySystem.addBook("War and Peace", "Leo Tolstoy", 1869, "classic");
        librarySystem.addBook("Pride and Prejudice", "Jane Austen", 1813, "classic");
        librarySystem.addBook("Moby-Dick", "Herman Melville", 1851, "adventures");

        librarySystem.printAllBooks();

        System.out.println(librarySystem.findBook("1984", "George Orwell", 1949));

        librarySystem.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);

        librarySystem.printAllBooks();

    }


}