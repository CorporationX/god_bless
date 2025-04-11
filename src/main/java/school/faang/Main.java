package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book book2 = new Book("Sunny day", "Paul Anderson",1978);
        Book book3 = new Book("Alan Wake", "J.R.R. Tolkien", 1954);
        Book book4 = new Book("One Republic", "J.R.R. Tolkien", 1954);

        library.addBook(book1, "A1");
        library.addBook(book2, "B3");
        library.addBook(book3, "A2");
        library.addBook(book4, "B4");


        library.removeBook("Sunny day", "Paul Anderson",1978);

        System.out.println(library.getBookLocation(book2));
        library.printAllBooks();
    }
}
