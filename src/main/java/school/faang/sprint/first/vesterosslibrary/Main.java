package school.faang.sprint.first.vesterosslibrary;

import school.faang.sprint.first.vesterosslibrary.model.LibrarySystem;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.printAllBooks();
        librarySystem.addBook("Вязание", "БабНина", 2000, "Загадки природы");
        librarySystem.findBook("Вязание", "БабНина", 2000);
        librarySystem.addBook("Пироги и спички", "Василиса", 1111, "Кулинария");
        librarySystem.addBook("Пироги и спички", "Василиса", 1111, "Выживание");
        librarySystem.printAllBooks();
        librarySystem.removeBook("Пироги и спички", "Василиса", -1111);
        librarySystem.printAllBooks();
    }
}
