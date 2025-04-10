package school.faang.libraryofwesteros;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Властелин колец", "Толкин", 1950, "3 полка справа");
        librarySystem.addBook("1984", "Оруэлл", 1949, "1 полка прямо");
        librarySystem.addBook("Щелкунчик", "Гофман", 1892, "детская полка");

        librarySystem.printAllBooks();

        System.out.println(librarySystem.findBook("Властелин колец", "Толкин", 1950));
        System.out.println(librarySystem.findBook("Библия", "Всевышний", 1));

        System.out.println(librarySystem.removeBook("Щелкунчик", "Гофман", 1892));
        librarySystem.printAllBooks();

        librarySystem.removeBook("Азбука", "Краснов", 1990);
        librarySystem.printAllBooks();
    }
}
