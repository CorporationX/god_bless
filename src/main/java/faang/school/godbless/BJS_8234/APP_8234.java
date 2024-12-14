package faang.school.godbless.BJS_8234;

public class APP_8234 {

    public static void main(String[] args) {
        WesterosLibrary library = new WesterosLibrary();
        Book harryPotter = new Book("Harry Potter", "J.Rouling", 2003);
        Book mobyDick = new Book("Moby-Dick", "Herman Melville", 1851);
        Book javaPhilosophy = new Book("Philosophy of Java", "Bruce Eckel", 2023);
        library.addBook(harryPotter, "third lane under number 443543");
        library.addBook(mobyDick, "Fifth lane under number 2354864");
        library.addBook(javaPhilosophy, "third lane under number 443683");
        library.getAllBooks();
        library.addBook(new Book("Moby-Dick", "Herman Melville", 1851), "Fifth lane under number 23565555");
        library.getAllBooks();
        library.deleteBook("Moby-Dick", "Herman Melville", 1851);
        library.getAllBooks();
        library.findBook("Harry Potter", "J.Rouling", 2003);
    }
}