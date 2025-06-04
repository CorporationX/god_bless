package school.library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.printAllBooks();
        LibrarySystem.addBook("Harry Potter", "J.K.Rowling", 1997, "third shelf");
        LibrarySystem.printAllBooks();

        LibrarySystem.removeBook("Grok algorithms", "Aditya Bhargava", 2019);
        LibrarySystem.printAllBooks();

        System.out.println(LibrarySystem.findBook("someBook", "somAuthor", 2025));
        System.out.println(LibrarySystem.findBook("Harry Potter", "J.K.Rowling", 1997));
    }
}
