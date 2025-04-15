package school.faang.stream1.vesteroslib;

public class SandBox {
    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.addBook("Crime and Panishment", "Dostoyevsky", 1867, "3rd shelf, on the right");
        system.addBook("Evgeny Onegin", "Pushkin", 1828, "3rd shelf, on the left");
        system.printAllBooks();
        System.out.println(system.findBook("Evgeny Onegin", "Pushkin", 1828));
        System.out.println(system.removeBook("Evgeny Onegin", "Pushkin", 1828));
        system.printAllBooks();
    }
}
