package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        boolean addedFirstBook = library.addBook("Don Quixote", "Miguel de Cervantes", 1605, "F.1");
        boolean addedSecondBook = library.addBook("Autumn of the Patriarch", "Gabriel Garcia Marquez", 1975, "B.7");
        boolean addedThirdBook = library.addBook("Flotsam", "Erich Maria Remarque", 1939, "L.4");
        boolean addedFourthBook = library.addBook("Don Quixote", "Miguel de Cervantes", 1605, "F.1");
        boolean addedFifthBook = library.addBook(null, "Miguel de Cervantes", 1605, "F.1");
        boolean addedSixthBook = library.addBook("Some book", "Erich Maria Remarque", 1939, null);

        System.out.println("\nBook added successfully? " + addedFirstBook);
        System.out.println("Book added successfully? " + addedSecondBook);
        System.out.println("Book added successfully? " + addedThirdBook);
        System.out.println("Book added successfully? " + addedFourthBook);
        System.out.println("Book added successfully? " + addedFifthBook);
        System.out.println("Book added successfully? " + addedSixthBook);

        System.out.println();
        library.findBook("Don Quixote", "Miguel de Cervantes", 1605);
        library.findBook("The Count of Monte Cristo", null, 1844);

        boolean removedFirstBook = library.removeBook("Flotsam", "Erich Maria Remarque", 1939);
        boolean removedSecondBook = library.removeBook("Flotsam", "Erich Maria Remarque", 1939);
        boolean removedThirdBook = library.removeBook(null, "Alexander Pushkin", 1966);

        System.out.println("\nBook removed successfully? " + removedFirstBook);
        System.out.println("Book removed successfully? " + removedSecondBook);
        System.out.println("Book removed successfully? " + removedThirdBook);

        library.printAllBooks();
    }
}