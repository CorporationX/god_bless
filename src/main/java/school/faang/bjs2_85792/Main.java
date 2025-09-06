package school.faang.bjs2_85792;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("451 degrees Fahrenheit","Ray Bradbury", 1953,"Street 1 House 1" );
        librarySystem.addBook("The Catcher in the Rye","J. D. Salinger", 1951,"Street 2 House 2" );
        librarySystem.addBook("Quiet Don","Mikhail Sholokhov", 1925,"Street 3 House 3" );
        librarySystem.addBook("There are no changes on the Western Front","Erich Maria Remarque", 1929,"Street 4 House 4" );
        librarySystem.addBook("Dumb","NoName", 2025,"Street 5 House 5" );

        librarySystem.printAllBook();

        librarySystem.removeBook("Dumb", "NoName", 2025);

        librarySystem.findBook("Quiet Don","Mikhail Sholokhov",1925);

        librarySystem.removeBook("qwerqwer", "Nsadfe", 2055);

        librarySystem.printAllBook();
    }

}
