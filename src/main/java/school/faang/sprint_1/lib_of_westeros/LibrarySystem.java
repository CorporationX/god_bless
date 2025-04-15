package school.faang.sprint_1.lib_of_westeros;

import java.util.HashMap;

public class LibrarySystem  {
    private static HashMap<Book, String> books = new HashMap<>();

    public static void addBook(String title, String author, int year, String shelf) throws Exception {
        if (title == null
                || author == null
                || year == 0
                || shelf == null) {
            System.out.println("Invalid arguments");
        }
        if (findBook(title, author, year) != null) {
            System.out.printf("Book \"%s\", by %s (%s) already exists \n", title, author, year);
        } else {
            Book book = new Book(title, author, year);
            books.put(book, shelf);
            System.out.printf("Book \"%s\", by %s (%s) succesfully added \n", title, author, year);
        }
    }

    public static Book findBook(String title, String author, int year) throws Exception {
        Book seeking = new Book(title, author, year);
        String shelf = books.get(seeking);

        if (shelf == null
                || shelf.isEmpty()) {
            throw new Exception("Shelf cannot be empty");
        } else {
            System.out.printf("Book \"%s\", by %s (%s) succesfully found on %s\n", title, author, year, shelf);
            return seeking;
        }
    }

    public static void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found");
        } else {
            books.forEach((book, shelf) -> {
                System.out.println(book.toString() + " " + shelf);
            });
        }
    }

    public static void deleteBook(String title, String author, int year) throws Exception {
        books.remove(findBook(title, author, year));
        System.out.printf("Book \"%s\", by %s (%s) succesfully deleted\n", title, author, year);
    }
}
