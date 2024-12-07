package school.faang.sprint_1.task_bjs245369;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("History", "Ivanov", 1995, "Shelf 1");
        library.addBook("Fairytale", "Brown", 1833, "Shelf 2");
        library.addBook("The Lord", "Charles", 1957, "Shelf 3");
        library.addBook("Queen", "London", 1879, "Shelf 3");
        System.out.println();

        library.removeBook("The Lord", "Charles", 1957);

        System.out.println();

        System.out.println(library.findBook("Queen", "London", 1879));
        System.out.println();

        library.printAllBooks();
    }
}
