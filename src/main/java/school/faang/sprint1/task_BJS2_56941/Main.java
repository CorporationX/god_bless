package school.faang.sprint1.task_BJS2_56941;

public class Main {
    private static final int MIN_YEAR = 0;
    private static final int MAX_YEAR = 2025;

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        System.out.println("Пустая Мапа");
        System.out.println(librarySystem.getBooksOnShelf());
        System.out.println();

        System.out.println("Добавляем книги");
        librarySystem.addBook("one", "someAuthor", 1990, "shelf1");
        librarySystem.addBook("two", "SomeOneElseAuthor", MIN_YEAR, "shelf2");
        librarySystem.addBook("three", "AnotherAuthor", MAX_YEAR, "shelf3");
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
        librarySystem.findBook("two", "SomeOneElseAuthor", MIN_YEAR);
        System.out.println();

        System.out.println("Выводим на экран все книги");
        librarySystem.printAllBooks();
    }
}
