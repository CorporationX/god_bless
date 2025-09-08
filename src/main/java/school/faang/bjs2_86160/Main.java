package school.faang.bjs2_86160;

public class Main {
    public static void main(String[] args) {

        LibrarySystem.addBook("Java for Dummies", "Vasyan", 2012, "Shelf 3, row 5");
        LibrarySystem.addBook("Python for Dummies", "Sanek", 2016, "Shelf 2, row 3");
        LibrarySystem.addBook("War and Peace", "Tolstoi", 1867, "Shelf 2, row 1");
        LibrarySystem.addBook("Crime and Punishment", "Dostoevski", 1866, "Shelf 1, row 2");
        LibrarySystem.addBook("Lolita", "Nabokov", 1955, "Shelf 4, row 4");
        LibrarySystem.addBook("Diamond Chariot", "Akunin", 2002, "Shelf 4, row 5");

        LibrarySystem.removeBook("Python for Dummies", "Sanek", 2016);

        LibrarySystem.findBook("Crime and Punishment", "Dostoevski", 1866);

        LibrarySystem.printAllBooks();
    }
}
