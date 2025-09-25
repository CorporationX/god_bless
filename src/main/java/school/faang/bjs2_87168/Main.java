package school.faang.bjs2_87168;

public class Main {
    static LibrarySystem librarySystem = new LibrarySystem();

    public static void main(String[] args) {
        librarySystem.addBook("GarryPotter", "King", 1991, "2378");
        librarySystem.addBook("GarryPotterTwo", "Lari", 1992, "2290");
        librarySystem.addBook("GarryPotterThree", "Mikel", 1993, "2458");
        librarySystem.addBook("GarryPotterFour", "Jordan", 1994, "2238");


        librarySystem.removeBook("GarryPotter", "King", 1991);


        librarySystem.findBook("GarryPotterTwo", "Lari", 1992);


        librarySystem.printAllBooks();
    }
}
