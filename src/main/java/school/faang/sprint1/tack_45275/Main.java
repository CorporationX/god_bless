package school.faang.sprint1.tack_45275;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.addBook("some title1", "author1", 1999, "полка 1");
        LibrarySystem.addBook("some title2", "author2", 1990, "полка 2");
        LibrarySystem.addBook("some title3", "author3", 1964, "полка 3");
        LibrarySystem.addBook("some title4", "author4", 1987, "полка 4");
        LibrarySystem.addBook("some title5", "author5", 2000, "полка 5");
        LibrarySystem.addBook("some title6", "author6", 2020, "полка 6");
        LibrarySystem.addBook("some title7", "author7", 2023, "полка 1");

        try {
            LibrarySystem.removeBook("some title3", "author3", 1964);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            //Какая-то обработка исключения
        }

        try {
            System.out.println(LibrarySystem.findBook("some title2", "author2", 1990));
            System.out.println(LibrarySystem.findBook("some title3", "author3", 1964));
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            //Какая-то обработка исключения
        }

        LibrarySystem.printAllBooks();
    }
}
