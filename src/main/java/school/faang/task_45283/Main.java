package school.faang.task_45283;


public class Main {

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Тихий дон", "Шелохов", 1932, "1");
        librarySystem.addBook("Треумфальная арка", "Ремарк", 1939, "2");
        librarySystem.addBook("Война и Мир", "Толстой", 1869, "3");
        librarySystem.addBook("Мастер и Маргарита", "Булгаков", 1928, "4");
        librarySystem.addBook("Капитанская дочка", "Пушкин", 1830, "5");
        librarySystem.addBook("Мертвые души", "Гоголь", 1842, "6");
        librarySystem.addBook("Вечера на хуторе", "Гоголь", 1863, "7");
        librarySystem.removeBook("Треумфальная арка", "Ремарк", 1939);
        System.out.println(librarySystem.findBook("Мастер и Маргарита", "Булгаков", 1928));
        librarySystem.printAllBooks();
    }
}
