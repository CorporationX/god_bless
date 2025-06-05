package school.faang.bjs2_79975;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.addBook("Гарри", "Джоан", 20, "6-zona");
        LibrarySystem.addBook("Хоббит", "Джон Рональд", 40, "4-zona");
        LibrarySystem.addBook(null, null, 0, null);
        LibrarySystem.addBook("Идиот", "Достоевский", 100, "1-zona");
        LibrarySystem.printAllBooks();
        LibrarySystem.findBook("Хоббит", "Джон Рональд", 40);
        LibrarySystem.removeBook("Хоббит", "Джон Рональд", 40);
        LibrarySystem.findBook("Хоббит", "Джон Рональд", 40);
        LibrarySystem.printAllBooks();
        LibrarySystem.removeBook(null, null, 0);
    }
}
