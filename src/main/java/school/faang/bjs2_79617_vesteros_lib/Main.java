package school.faang.bjs2_79617_vesteros_lib;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.addBook(new Book("Argonauts", "Plato", -500), "shelf 1");
        LibrarySystem.addBook(new Book("Iliad", "Homer", -450), "shelf 1");
        LibrarySystem.addBook(new Book("Java Tutorial", "Linus", 2010), "shelf 2");

        LibrarySystem.printAllBooks();
        LibrarySystem.findBook("Java Tutorial", "Linus", 2010);
        System.out.println("Remove Java");
        LibrarySystem.removeBook("Java Tutorial", "Linus", 2010);
        LibrarySystem.printAllBooks();
        System.out.println("Search Java");
        LibrarySystem.findBook("Java Tutorial", "Linus", 2010);
    }
}
