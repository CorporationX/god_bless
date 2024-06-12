package faang.school.godbless.BJS2_8259;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("01", new Book("Book1", "Author1", 2000));
        library.addBook("02", new Book("Book2", "Author2", 2001));
        library.addBook("03", new Book("Book3", "Author3", 2002));
        library.addBook("04", new Book("Book4", "Author4", 2003));

        library.printAllBooks();
        System.out.println();
        library.removeBook("Book3", "Author3", 2002);
        library.printAllBooks();
        System.out.println();
        library.addBook("03", new Book("Book3", "Author3", 2002));
        library.printBookIndex("Book3", "Author3", 2002);
    }
}
