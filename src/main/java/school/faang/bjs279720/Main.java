package school.faang.bjs279720;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("The Witcher", "Andrzej Sapkowski", 1986, "A1");
        library.addBook("1984", "George Orwell", 1949, "A2");
        library.findBook("1984", "George Orwell", 1949);
        library.printAllBooks();
        library.removeBook("1984", "George Orwell", 1949);
        library.printAllBooks();
    }
}
