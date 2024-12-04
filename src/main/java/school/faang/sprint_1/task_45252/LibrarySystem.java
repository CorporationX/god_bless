package school.faang.sprint_1.task_45252;

import static school.faang.sprint_1.task_45252.Main.LIBRARY;

public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location) {
        LIBRARY.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (!LIBRARY.containsKey(book)) {
            System.out.println("Book not find");
        }

        var findResult = LIBRARY.get(book);
        System.out.printf("%s is located in %s%n", book, findResult);
    }

    public static void printAllBooks() {
        System.out.println(LIBRARY);
    }
}

