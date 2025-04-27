package school.faang.LibraryOfWesteros;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Изучаем Java", "Кэтти Сьерра", 1990, "полка3");
        librarySystem.removeBook("Крутой пёс", "Пёс ещё круче", 1111);
        librarySystem.findBook("Властелин колец", "Конор Макгрегор", 1245);
        librarySystem.findBook("Изучаем Java", "Кэтти Сьерра", 1990);
        librarySystem.printAllBooks();

    }
}
