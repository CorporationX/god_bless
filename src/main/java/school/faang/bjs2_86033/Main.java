package school.faang.bjs2_86033;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.addBook("Как закалялась сталь", "В.Островский", 1948, "2");
        LibrarySystem.addBook("Цветы для Элджернона", "Дэниел Киз", 1952, "12");
        LibrarySystem.addBook("Питер Пен", "Джеймс Барри", 1901, "17");

        LibrarySystem.findBook("Как закалялась стал", "В.Островский", 1948);
        LibrarySystem.findBook("Как закалялась сталь", "В.Островский", 1948);

        LibrarySystem.removeBook("Питер Пен", "Джеймс Барри", 1900);
        LibrarySystem.removeBook("Питер Пен", "Джеймс Барри", 1901);

        LibrarySystem.printAllBooks();
    }
}
