package school.faang.BJS2_33089;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Book A", "Author A", 1678), "Shelf A");
        library.addBook(new Book("Book B", "Author B", 1799), "Shelf B");
        library.addBook(new Book("Book C", "Author C", 1825), "Shelf C");

        library.getAllBooks();

        library.addBook(new Book("Book D", "Author D", 1465), "Shelf D");

        System.out.println(library.findBook(new Book("Book A", "Author A", 1678)));

        library.deleteBook(new Book("Book D", "Author D", 1465));

        library.deleteBook(new Book("Book E", "Author E", 1999));

        library.getAllBooks();
    }
}
