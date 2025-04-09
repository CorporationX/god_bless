package school.faang.bjs2_68677;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Война и мир", "Л.H.Толстой", 1869, "K4");
        librarySystem.addBook("Преступление и наказание", "Ф.М.Достоевский", 1866, "O1");
        librarySystem.addBook("Грозовой перевал", "Э.Бронте", 1847, "S6");
        librarySystem.printAllBooks();

        System.out.println(librarySystem.findBook("Грозовой перевал", "Э.Бронте", 1847));

        librarySystem.removeBook("Преступление и наказание", "Ф.М.Достоевский", 1866);
        librarySystem.printAllBooks();
    }
}
