package school.faang.task_45295;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("1984", "George Orwell", 1949, "Shelf 1");
        librarySystem.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Shelf 2");
        librarySystem.addBook("Moby-Dick", "Herman Melville", 1851, "Shelf 3");
        librarySystem.addBook("The Hobbit", "J.R. Tolkien", 1937, "Shelf 4");

        librarySystem.printAllBooks();
        System.out.println("----------");

        librarySystem.findBook("Moby-Dick", "Herman Melville", 1851);
        System.out.println("----------");

        librarySystem.addBook("The Picture of Dorian Gray", "Oscar Wilde", 1890, "Shelf 5");
        librarySystem.printAllBooks();
        System.out.println("----------");

        librarySystem.removeBook("1984", "George Orwell", 1949);
        librarySystem.printAllBooks();
    }
}
