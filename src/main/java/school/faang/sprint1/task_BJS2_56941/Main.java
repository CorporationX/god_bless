package school.faang.sprint1.task_BJS2_56941;

public class Main {
    private static final int minYear = 0;
    private static final int maxYear = 2025;

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        System.out.println("Пустая Мапа");
        System.out.println(librarySystem.getBooksOnShelf());
        System.out.println();

        System.out.println("Добавляем книги");
        librarySystem.addBook("one", "someAuthor", 1990, "shelf1");
        librarySystem.addBook("two", "SomeOneElseAuthor", minYear, "shelf2");
        librarySystem.addBook("three", "AnotherAuthor", maxYear, "shelf3");
        System.out.println(librarySystem.getBooksOnShelf());
        System.out.println();

        System.out.println("Удалям книги");
        librarySystem.removeBook("one", "someAuthor", 1990);
        System.out.println(librarySystem.getBooksOnShelf());
        System.out.println();


        System.out.println("Не находим книгу");
        librarySystem.findBook("one", "someAuthor", 1990);
        System.out.println();

        System.out.println("Находим книгу");
        librarySystem.findBook("two", "SomeOneElseAuthor", minYear);
        System.out.println();

        System.out.println("Выводим на экран все книги");
        librarySystem.printAllBooks();
    }
}
