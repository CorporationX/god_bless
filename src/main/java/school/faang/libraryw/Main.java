package school.faang.libraryw;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        try {
            librarySystem.addBook("1984", "Джордж Оруэлл", 1949, "A1");
            librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "B2");
            librarySystem.addBook("Мастер и Маргарита", "Михаил Булгаков", 1967, "C4");
            librarySystem.addBook("Гарри Поттер и философский камень", "Дж.К. Роулинг", 1997, "C1");

            librarySystem.removeBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
            System.out.println(librarySystem.findBook("1984", "Джордж Оруэлл", 1949));
            System.out.println(librarySystem.findBook("Мастер и Маргарита", "Михаил Булгаков", 1967));
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
        librarySystem.printAllBooks();
    }
}