package school.faang;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setAuthor("Author 1");
        book1.setYear(2018);
        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setAuthor("Author 2");
        book2.setYear(2019);
        Book book3 = new Book();
        book3.setTitle("Book 3");
        book3.setAuthor("Author 3");
        book3.setYear(2020);
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook(book1.getTitle(), book1.getAuthor(), book1.getYear(), "Table");
        librarySystem.addBook(book2.getTitle(), book2.getAuthor(), book2.getYear(), "Closet1");
        librarySystem.addBook(book3.getTitle(), book3.getAuthor(), book3.getYear(), "Closet2");
        librarySystem.showAllBooks();
        librarySystem.removeBook(book1.getTitle(), book1.getAuthor(), book1.getYear());
        librarySystem.showAllBooks();
        System.out.println(librarySystem.findBook(book2.getTitle(), book2.getAuthor(), book2.getYear()));
    }
}
