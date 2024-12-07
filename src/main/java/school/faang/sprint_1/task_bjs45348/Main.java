package school.faang.sprint_1.task_bjs45348;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        String location = "Polka dva sverxu";

        librarySystem.addBook("Бесы", "Достоевский", 1875, location);
        librarySystem.addBook("Бесы2", "Достоевский2", 1879, location);

        librarySystem.removeBook("Бесы3", "Достоевский2", 1830);
        librarySystem.printAllBooks();
        System.out.println(librarySystem.findBook("Бесы2", "Достоевский2", 1879));

    }
}

