package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("Winnie-the-Pooh", "A. A. Milne, E. H. Shepard", 1921);
        library.addBook("The Secret Garden", "Frances Hodgson Burnett", 1911);
        library.addBookToShelf("Green Eggs and Ham", "Dr.Seuss", 1960, "2nd shelf");
        library.printAllBooks();
        library.findBook("Winnie-the-Pooh", "A. A. Milne, E. H. Shepard", 1921);
        library.removeBook("Winnie-the-Pooh", "A. A. Milne, E. H. Shepard", 1921);
        library.findBook("Winnie-the-Pooh", "A. A. Milne, E. H. Shepard", 1921);
    }
}
