package school.faang.bjs2_87171;

public class Main {
    public static void main(String[] args) throws Exception {
        LibrarySystem.addBook(
                "Как охотиться на медведя?", "Охотник Кирюша", 1990, "полка 50");
        LibrarySystem.addBook(
                "Как охотиться на зайца?", "Охотник Кирюша", 1991, "полка 100");
        LibrarySystem.addBook(
                "Как охотиться на лису?", "Охотник Кирюша", 1992, "полка 150");
        LibrarySystem.addBook(
                "Как охотиться на волка?", "Охотник Кирюша", 1993, "полка 200");
        LibrarySystem.addBook(
                "Как охотиться на песца?", "Охотник Кирюша", 1994, "полка 250");
        LibrarySystem.addBook(
                "Как охотиться на колобка?", "Охотник Кирюша", 1994, "полка 300");

        LibrarySystem.printAllBooks();

        LibrarySystem.removeBook("Как охотиться на зайца?", "Охотник Кирюша", 1991);
        LibrarySystem.removeBook("Как охотиться на лису?", "Охотник Кирюша", 1992);
        LibrarySystem.removeBook("Как охотиться на медведя?", "Охотник Кирюша", 1990);
        LibrarySystem.removeBook("Как охотиться на песца?", "Охотник Кирюша", 1994);

        System.out.println();
        System.out.println("Остатки книг после визита богатого покупателя:");
        LibrarySystem.printAllBooks();

        String huntingKolobok = LibrarySystem.findBook(
                "Как охотиться на колобка?", "Охотник Кирюша", 1994);
        System.out.println();
        System.out.println("Про колобка по указателю: " + huntingKolobok);
    }
}
