package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("The Ingenious Gentleman Don Quixote of La Mancha", "Miguel de Cervantes", 1605, "F.1");
        library.addBook("Autumn of the Patriarch", "Gabriel Garcia Marquez", 1975, "B.1");
        library.addBook("Flotsam", "Erich Maria Remarque", 1939, "L.2");

        library.findBook("Don Quixote", "Miguel de Cervantes", 1605);
        library.findBook("The Count of Monte Cristo", " Alexandre Dumas", 1844);  // Книги нет в библиотеке

        library.removeBook("Flotsam", "Erich Maria Remarque", 1939);

        library.printAllBooks();
    }
}