package faang.school.godbless.java.sql.library;

public class App {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();

        libraryService.addBookToLibrary("shelf_2", "Voina i mir", "Lev Tolstoi", 1869);
        libraryService.addBookToLibrary("shelf_4", "Prestuplenie i nakazanie", "Fedor Dostoevskii", 1866);
        libraryService.addBookToLibrary("shelf_7", "Master i Margarita", "Mihail Bulgakov", 1967);

        libraryService.removeBookFromLibrary( "Master i Margarita", "Mihail Bulgakov", 19678);
        libraryService.removeBookFromLibrary( "Master i Margarita", "Mihail Bulgakov", 1967);

        libraryService.findBookInLibrary("Master i Margarita", "Mihail Bulgakov", 1968);
        libraryService.findBookInLibrary("Prestuplenie i nakazanie", "Fedor Dostoevskii", 1866);

        libraryService.showAllBooksInLibrary();

    }
}
