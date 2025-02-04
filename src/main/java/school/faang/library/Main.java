package school.faang.library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("Harry Potter", "J.K. Rowling", 1997, "A34");
        library.addBook("Harry Potter", "J.K. Rowling", 1997, "A36");
        library.addBook("The Lord of the Rings", "John Ronald Reuel \"J. R. R.\" Tolkien",
                1954, "BD456");
        library.addBook("Dracula", "Abraham \"Bram\" Stoker", 1897, "С56");
        library.addBook("Winnie-the-Pooh", "Alan Alexander Milne", 1926, "F67");
        library.printAllBooks();
        library.findBook("Dracula", "Abraham \"Bram\" Stoker", 1897);
        library.findBook("Dracula", "Abraham \"Bram\" Stoker", 1896);
        library.removeBook("Harry Potter", "J.K. Rowling", 1997);
        library.removeBook("Harry Potter", "J.K. Rowling", 1997);
    }
}
