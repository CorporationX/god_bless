package school.faang.bjs2_86033;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("Как закалялась сталь", "В.Островский", 1948, 2);
        library.addBook("Цветы для Элджернона", "Дэниел Киз", 1952, 12);

        library.findBook("Как закалялась сталь", "В.Островский", 1948);
        library.printAllBooks();
    }
}
