package school.faang.library;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;

public class TestLibrary {

    public static void main(String[] args) {
        HashMap<Book, String> booksMap = new HashMap<>();
        booksMap.put(new Book("Rich Dad", "Kiyosaki", 2010), "A150");
        booksMap.put(new Book("Harry Potter", "Rowling", 2005), "B012");
        booksMap.put(new Book("The Snow Queen", "Andersen", 2000), "F001");
        booksMap.put(new Book("A Game of Thrones", "Martin", 2003), "K100");
        booksMap.put(new Book("Peter Pan", "Barrie", 2003), "H123");
        print(booksMap);

        System.out.println();

        System.out.println("Book added");
        add(booksMap, new Book("The Little Prince", "Saint-Exupery", 2003), "H345");
        print(booksMap);

        String bookName = "Harry Potter";
        String bookAuthor = "Rowling";
        int bookYear = 2005;

        System.out.println();
        System.out.println("Book removed");
        remove(booksMap, bookName, bookAuthor, bookYear);
        print(booksMap);

        System.out.println();
        System.out.println("Book place found");
        String bookNameForFind = "Rich Dad";
        String bookAuthorForFind = "Kiyosaki";
        int bookYearForFind = 2010;
        Optional<String> findResultOptional = find(booksMap, bookNameForFind, bookAuthorForFind, bookYearForFind);
        findResultOptional.ifPresent(place -> {
            System.out.print(new Book(bookNameForFind, bookAuthorForFind, bookYearForFind));
            System.out.print(" - ");
            System.out.println(place);
        });

        System.out.println();
        System.out.println("Book place changed");
        add(booksMap, new Book("A Game of Thrones", "Martin", 2003), "W333");
        print(booksMap);
    }

    private static void add(HashMap<Book, String> booksMap, Book newBook, String place) {
        booksMap.put(newBook, place);
    }

    private static void remove(HashMap<Book, String> booksMap, String title, String author, int year) {
        Book book = new Book(title, author, year);
        booksMap.remove(book);
    }

    private static Optional<String> find(HashMap<Book, String> booksMap, String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (booksMap.containsKey(book)) {
            return Optional.of(booksMap.get(book));
        }
        return Optional.empty();
    }

    private static void print(HashMap<Book, String> booksMap) {
        for (var bookStringEntry : booksMap.entrySet().stream().sorted(Comparator.comparing(a -> a.getKey().getYear())).toList()) {
            System.out.print(bookStringEntry.getKey());
            System.out.print(" - ");
            System.out.println(bookStringEntry.getValue());
        }
    }
}
