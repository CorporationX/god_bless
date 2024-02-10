package faang.school.godbless.main;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> library = new HashMap<>();
    public static void main(String[] args) {
        addBook("Of grass and earth", "Martin", 208);
        addBook("Little creatures", "Tolkin", 215);
        addBook("Great creatures", "Tolkin", 217);
        addBook("Westeros kingdoms", "Targarien", 195);
        addBook("How to become a king", "Targarien", 197);
        addBook("I know nothing", "Snow", 300);
        addBook("unknown", "", 101);
        listOfAllBooks();
        findBook("unknown", "", 101);
        findBook("dfs", "sdf", 500);
        removeBook("How to become a king", "Targarien", 197);
        listOfAllBooks();
    }

    public static void addBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String section = firstLetterOfAuthor(author);
        library.put(book, section);
    }

    private static String firstLetterOfAuthor(String author) {
        StringBuilder builder = new StringBuilder();
        builder.append("section ");
        if (!author.isEmpty()) {
            String ch = String.valueOf(author.toUpperCase().charAt(0));
            if ("ABCDEF".contains(ch)) {
                builder.append("A-F");
            } else if ("GHIJKLMN".contains(ch)) {
                builder.append("G-N");
            } else if ("OPQRSTU".contains(ch)) {
                builder.append("O-U");
            } else if ("VWXYZ".contains(ch)) {
                builder.append("V-Z");
            } else {
                builder.append("other");
            }
        } else {
            builder.append("other");
        }
        return builder.toString();
    }

    public static void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        String section = library.get(new Book(title, author, year));
        if (section != null) {
            System.out.println("Book is in " + section + ".");
        } else {
            System.out.println("There is no such book in this library!");
        }
    }

    public static void listOfAllBooks() {
        int count = 1;
        for (Map.Entry<Book, String> book : library.entrySet()) {
            Book currentBook = book.getKey();
            System.out.println(String.format("%d. The book \"%s\" by %s of year %d is in %s.", count, currentBook.getTitle(),
                    currentBook.getAuthor(), currentBook.getYear(), book.getValue()));
            count++;
        }
    }
}
