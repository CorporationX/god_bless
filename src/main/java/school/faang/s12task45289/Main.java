package school.faang.s12task45289;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Carlson", "A. Lindgren", 1957, "shelf1");
        librarySystem.addBook("Winnie the Pooh", "A. Milne", 1926, "shelf2");
        librarySystem.addBook("The Winnie", "A. Milne", 1965, "shelf2.1");
        divideRows();

        librarySystem.findBook("Winnie the Pooh", "A. Milne", 1926);
        divideRows();

        librarySystem.removeBook("The Winnie", "A. Milne", 1965);
        divideRows();

        librarySystem.printAllBooks();
    }
    public static void divideRows(){
        System.out.println();
        System.out.println("************");
        System.out.println();
    }
}