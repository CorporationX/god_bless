package school.faang.bjs2_86197;

public class LibraryDemo {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Битва королей", "Джордж Мартин", 1998, "Полка 1");
        librarySystem.addBook("Буря мечей", "Джордж Мартин", 2000, "Полка 2");
        librarySystem.addBook("Пир стервятников", "Джордж Мартин", 2005, "Полка 3");
        librarySystem.removeBook("Буря мечей", "Джордж Мартин", 2000);
        librarySystem.findBook("Пир стервятников", "Джордж Мартин", 2005);
        librarySystem.findBook("Стервятники", "Лев Толстой", 1895);
        librarySystem.printAllBooks();
    }
}
