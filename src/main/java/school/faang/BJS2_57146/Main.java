package school.faang.BJS2_57146;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Мёртвые души", "Николай Гоголь", 1842, "№2");
        librarySystem.addBook("Анна Каренина", "Лев Толстой", 1877, "№1");
        librarySystem.addBook("Обломов", "Иван Гончаров", 1859, "№1");
        librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "№3");
        librarySystem.addBook("Идиот", "Фёдор Достоевский", 1868, "№4");
        librarySystem.findBook("Обрыв", "Иван Гончаров", 1869);
        librarySystem.findBook("Обломов", "Иван Гончаров", 1859);
        librarySystem.printAllBooks();
        librarySystem.removeBook("Анна Каренина", "Лев Толстой", 1877);
        librarySystem.printAllBooks();
    }
}
