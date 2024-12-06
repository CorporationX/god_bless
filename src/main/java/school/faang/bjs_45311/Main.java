package school.faang.bjs_45311;

import lombok.extern.java.Log;

@Log
public class Main {

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Война и мир", "Л.Н. Толстой", 2020, "Ряд 11, место 1");
        librarySystem.addBook("Евгений Онегин", "А.С.Пушкин", 2008, "Ряд 11, место 6");
        librarySystem.addBook("Гордость и предубеждение", "Джейн Остин", 1997,
                "Ряд 13, место 6");
        librarySystem.addBook("Преступление и наказание", "Фёдор Достоевский", 1990,
                "Ряд 12, место 26");

        log.info("Список книг после добавления");
        librarySystem.printAllBooks();

        log.info(librarySystem.getBookLocation("Преступление и наказание", "Фёдор Достоевский", 1990));

        librarySystem.removeBook("Гордость и предубеждение", "Джейн Остин", 1997);
        log.info("Список книг после удаления");
        librarySystem.printAllBooks();
    }

}
