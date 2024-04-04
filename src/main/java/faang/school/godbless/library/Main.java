package faang.school.godbless.library;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookToPlace("War and peace", "Tolstoy", 1830, "First row");
        library.addBookToPlace("A game of Thrones", "Martin", 1996, "Second row");
        library.addBookToPlace("Clean code", "Martin", 2008, "Taken");

        library.displayAllBooksAndPlaces();

        library.deleteByAttributes("War and peace", "Tolstoy", 1830);

        library.displayAllBooksAndPlaces();

        library.searchPlaceByAttributes("Clean code", "Martin", 2008);
    }
}
