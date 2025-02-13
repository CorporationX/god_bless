package school.faang.task_57289;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("1984", "George Orwell", 1949, "B4");
        librarySystem.addBook("Crime and Punishment", "Fyodor Dostoevsky", 1866, "J3");
        librarySystem.addBook("Fahrenheit 451", "Ray Bradbury", 1953, "A5");

        librarySystem.printAllBooks();

        System.out.println(librarySystem.findBook("Fahrenheit 451", "Ray Bradbury", 1953));
        System.out.println(librarySystem.findBook("We", "Евгений Замятин", 1924));

        librarySystem.removeBook("Crime and Punishment", "Fyodor Dostoevsky", 1866);
        librarySystem.printAllBooks();
    }
}
