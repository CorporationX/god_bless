package school.faang.vesterosLibrary;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addNewBook("Harry Potter", "J.Rowling", "2000", 1);
        library.addNewBook("Kolobok", "unknown", "1800",3);
        library.findBookPlace("Kolobok", "unknown", "1800");
        library.showLibrary();
        library.deleteBook("Harry Potter", "J.Rowling", "2000");
        library.showLibrary();
    }
}
