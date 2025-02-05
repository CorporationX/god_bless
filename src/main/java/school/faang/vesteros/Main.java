package school.faang.vesteros;

public class Main {

    public static void main(String[] args) {
        Book warAndPeace = new Book("War and Peace", "Leo Tolstoy", 1894);
        Book crimeAndPunishment =
                new Book("Crime and Punishment", "Fedor Dostoyevsky", 1886);
        Book americanTragedy =
                new Book("American Tragedy", "Theo Drazder", 1998);
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook(warAndPeace.getTitle(), warAndPeace.getAuthor(), warAndPeace.getYear(),
                "1A");
        librarySystem.addBook(crimeAndPunishment.getTitle(), crimeAndPunishment.getAuthor(),
                crimeAndPunishment.getYear(), "2B");
        librarySystem.printAllBooks();

        librarySystem.addBook(americanTragedy.getTitle(),
                americanTragedy.getAuthor(), americanTragedy.getYear(), "3C");

        librarySystem.printAllBooks();

        librarySystem.removeBook(americanTragedy.getTitle(), americanTragedy.getAuthor(),
                americanTragedy.getYear());

        librarySystem.printAllBooks();

        librarySystem.findBook(warAndPeace.getTitle(), warAndPeace.getAuthor(), warAndPeace.getYear());
    }
}
