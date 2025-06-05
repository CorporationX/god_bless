package school.faang.bjs2_79611;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Java Book", "Java Geek", 1991, "A-1");
        librarySystem.addBook("SQL Book", "Sql Geek", 1970, "B-3");
        librarySystem.addBook("Git Book", "Git Geek", 2005, "A-1");

        librarySystem.findBook("SQL Book", "Sql Geek", 1970);
        String location = librarySystem.removeBook("SQL Book", "Sql Geek", 1970);
        System.out.println("Книга удалена из библиотеки? - " + (location != null));
        librarySystem.findBook("SQL Book", "Sql Geek", 1970);


        System.out.println("\nAll books by location:");
        librarySystem.printAllBooks();
    }
}
