package library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("Harry Potter", "J.K.Rowling", 1997, "1");
        library.addBook("Dune", "Frank Herbert", 1965, "2");
        library.addBook("Lord of the rings", "J.R.R.Tolkien", 1954, "3");
        library.addBook("Heaven Official's Blessing", "Mo Xiang Tong Xiu", 2017, "4");

        library.removeBook("Lord of the rings", "J.R.R.Tolkien", 1954);

        System.out.println(library.findBook("Dune", "Frank Herbert", 1965));

        library.printAllBooks();
    }
}
