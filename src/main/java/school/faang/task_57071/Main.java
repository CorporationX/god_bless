package school.faang.task_57071;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Собачье сердце", "Михаил Булгаков", 1925, "Первая полка");
        librarySystem.addBook("Преступление и наказание", "Федор Достоевский", 1866, "Вторая полка");
        librarySystem.addBook("Повести Белкина", "Александр Пушкин", 1831, "Первая полка");

        librarySystem.removeBook("Собачье сердце", "Михаил Булгаков", 1925);

        System.out.println(librarySystem.findBook("Повести Белкина", "Александр Пушкин", 1831));

        librarySystem.printAllBooks();


    }
}
