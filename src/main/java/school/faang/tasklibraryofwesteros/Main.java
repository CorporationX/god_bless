package school.faang.tasklibraryofwesteros;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("Война и мир", "Толстой", 1899, "Полка 1");
        library.addBook("Идиот", "Достоевский", 1578, "Полка 2");
        library.addBook("Сказка", "Чукотский", 1700, "Полка 3");

        library.printAllBooks();
        library.findBook("Война и мир", "Толстой", 1899);
        library.removeBook("Скаpка", "Чукотский", 1700);
        library.printAllBooks();
    }
}
