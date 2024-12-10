package school.faang.sprint_1.task_45411.task_45411;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, List<String>> bookshelfPlace = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        try {
            // Check for location conflict across all books
            for (List<String> locations : bookshelfPlace.values()) {
                if (locations.contains(location)) {
                    throw new IllegalArgumentException("Location \"" + location
                            + "\" is already occupied by another book.");
                }
            }
            // Add the book and shelf location
            List<String> locations = bookshelfPlace.computeIfAbsent(book, k -> new ArrayList<>());
            locations.add(location);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding book \"" + title + "\" by " + author + ": " + e.getMessage());
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        try {
            if (bookshelfPlace.containsKey(book)) {
                List<String> locations = bookshelfPlace.get(book);
                if (locations.size() == 1) {
                    bookshelfPlace.remove(book);
                } else {
                    locations.remove(locations.size() - 1); // Delete the last shelf location
                }
                System.out.println("The book \"" + title + "\" is removed!");
            } else {
                throw new IllegalArgumentException("Book \"" + title + "\" hasn't been found!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Remove is failed: " + e.getMessage());
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        try {
            if (bookshelfPlace.containsKey(book)) {
                List<String> locations = bookshelfPlace.get(book);
                System.out.println("You can find \"" + title + "\" on " + String.join(", ", locations));
            } else {
                throw new IllegalArgumentException("Book \"" + title + "\" not found.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("The search failed: " + e.getMessage());
        }
    }

    public void printAllBooks() {
        System.out.println(formatBookshelfPlacePrettyView(bookshelfPlace));
    }

    public static String formatBookshelfPlacePrettyView(Map<Book, List<String>> bookshelfPlace) {
        StringBuilder sb = new StringBuilder("{\n");
        int i = 0;
        for (Map.Entry<Book, List<String>> entry : bookshelfPlace.entrySet()) {
            Book book = entry.getKey();
            List<String> shelves = entry.getValue();
            sb.append("  ").append(book).append(": ");
            int bookLength = String.valueOf(book).length();
            int paddingLength = 70 - bookLength;
            if (paddingLength > 0) {
                sb.append(" ".repeat(paddingLength));
            }
            sb.append(shelves);
            if (++i < bookshelfPlace.size()) {
                sb.append(",\n");
            } else {
                sb.append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
