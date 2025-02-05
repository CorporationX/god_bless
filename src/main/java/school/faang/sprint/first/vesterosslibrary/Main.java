package school.faang.sprint.first.vesterosslibrary;

import school.faang.sprint.first.vesterosslibrary.model.LibrarySystem;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.printAllBooks();
        LibrarySystem.addBook("Вязание", "БабНина", 2000, "Загадки природы");
        LibrarySystem.findBook("Вязание", "БабНина", 2000);
        LibrarySystem.addBook("Пироги и спички", "Василиса", 1111, "Кулинария");
        LibrarySystem.addBook("Пироги и спички", "Василиса", 1111, "Выживание");
        LibrarySystem.printAllBooks();
        LibrarySystem.removeBook("Пироги и спички", "Василиса", 1111);
        LibrarySystem.printAllBooks();
    }
}
