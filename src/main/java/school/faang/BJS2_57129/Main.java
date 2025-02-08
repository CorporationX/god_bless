package school.faang.BJS2_57129;

public class Main {

    public static void main(String[] args) {

        //Проверим реализуемые методы
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Новая жизнь", "Дмитрий Охара", 2018, "123");
        librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "3");

        System.out.println("Полка: " + librarySystem.findBook("Война и мир", "Лев Толстой", 1869));

        librarySystem.removeBook("Война и мир", "Лев Толстой", 1869);

        librarySystem.printAllBooks();

    }
}
