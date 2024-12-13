package school.faang.sprint_1.task_45320;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Война и мир", "Л.Н.Толстой", 1867, "Полка 1");
        librarySystem.addBook("Преступление и наказание", "Ф.М.Достоевский", 1867, "Полка 2");
        librarySystem.addBook("Горе от ума", "А.Грибоедов", 1825, "Полка 3");

        System.out.println("Все книги:");
        librarySystem.printAllBooks();

        librarySystem.findBook("Война и мир", "Л.Н.Толстой", 1867);

        librarySystem.removeBook("Горе от ума", "А.Грибоедов", 1825);
        librarySystem.removeBook("Преступление и наказание", "Ф.М.Достоевский", 1867);
        librarySystem.removeBook("Война и мир", "Л.Н.Толстой", 1867);

        librarySystem.findBook("Горе от ума", "А.Грибоедов", 1825);

        librarySystem.printAllBooks();
    }
}
