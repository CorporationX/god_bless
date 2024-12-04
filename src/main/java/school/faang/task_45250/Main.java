package school.faang.task_45250;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("A Game of Thrones", "George R. R. Martin", 1996, "Shelf 1");
        librarySystem.addBook("Harry Potter and the Philosopher's Stone", "Joanne Rowling", 1995, "Shelf 2");
        librarySystem.addBook("Atlas Shrugged", "Ayn Rand", 1957, "Shelf 3");

        System.out.println("Все книги в библиотеке:");
        librarySystem.printAllBooks();

        System.out.println("\nПоиск книги:");
        librarySystem.findBook("A Game of Thrones", "George R. R. Martin", 1996);

        System.out.println("\nУдаление книги:");
        librarySystem.removeBook("A Game of Thrones", "George R. R. Martin", 1996);

        System.out.println("\nВсе книги в библиотеке после удаления:");
        librarySystem.printAllBooks();
    }
}
