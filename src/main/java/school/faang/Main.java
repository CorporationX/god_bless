package school.faang;


public class Main {
    public static final Book FIRS_BOOK = new Book("First book", "Ilya Yanchenko", 1999);
    public static final Book SECOND_BOOK = new Book("Second book", "Not Ilya Yanchenko", 1900);
    public static final Book THIRD_BOOK = new Book("Third book", "Anna Karenina", 1911);
    public static final Book NULL_BOOK = new Book("Null book", "", 1911);

    public static void main(String[] args) {


        LibrarySystem librarySystem = new LibrarySystem();
        System.out.println("Add \n");
        librarySystem.addBook(THIRD_BOOK.getTitle(), THIRD_BOOK.getAuthor(), THIRD_BOOK.getYear(), "3 полка по цетнру");
        librarySystem.addBook(FIRS_BOOK.getTitle(), FIRS_BOOK.getAuthor(), FIRS_BOOK.getYear(), "2 полка снизу слева");
        librarySystem.addBook(SECOND_BOOK.getTitle(), SECOND_BOOK.getAuthor(), SECOND_BOOK.getYear(), "1 полка сверху");
        librarySystem.addBook(NULL_BOOK.getTitle(), NULL_BOOK.getAuthor(), NULL_BOOK.getYear(), "в пустоте");
        System.out.println("Find \n");
        librarySystem.findBook(FIRS_BOOK.getTitle(), FIRS_BOOK.getAuthor(), FIRS_BOOK.getYear());
        System.out.println("Print \n");
        librarySystem.printAllBooks();
        System.out.println("Remove \n");
        librarySystem.removeBook(SECOND_BOOK.getTitle(), SECOND_BOOK.getAuthor(), SECOND_BOOK.getYear());
        librarySystem.removeBook(FIRS_BOOK.getTitle(), FIRS_BOOK.getAuthor(), FIRS_BOOK.getYear());
        System.out.println("Print \n");
        librarySystem.printAllBooks();

    }
}
