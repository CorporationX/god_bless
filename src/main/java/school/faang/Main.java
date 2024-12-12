package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("The Lord of the Rings", "J.R.R. Tolkien", 1954, "001");
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "002");
        library.addBook("The Silmarillion", "J.R.R. Tolkien", 1977, "003");

        System.out.println(library.findBook("The Hobbit", "J.R.R. Tolkien", 1937));

        System.out.println(library.removeBook("The Hobbit", "J.R.R. Tolkien", 1937));
        library.printAllBooks();
    }
}
