package school.faang.sprint_1.lib_of_westeros;

public class Main {
    public static void main(String[] args) throws Exception {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Lost Wisdom", "Varg Vikernes", 1991, "Second shelf");
        librarySystem.addBook("Eternal life", "Øystein Aarseth", 1993, "Second shelf");
        librarySystem.addBook("Freezing Moon", "Øystein Aarseth", 1993, "Third shelf");
        librarySystem.addBook("Freezing Moon", "Øystein Aarseth", 1993, "Second shelf");
        librarySystem.addBook("Freezing Moon", "Øystein Aarseth", 1999, "Second shelf");

        librarySystem.findBook("Lost Wisdom", "Varg Vikernes", 1991);

        librarySystem.deleteBook("Eternal life", "Øystein Aarseth", 1993);

        librarySystem.showAllBooks();
    }

}
