package faang.school.godbless.JHMWesterosLibrary1999;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        addBookToLibrary("The Red Book", "Elkin", 298);
        addBookToLibrary("The Fires of the Freehold", "Galendro", 285);
        addBookToLibrary("Remnants of the Dragonlords", "Gramyon", 307);
        addBookToLibrary("Fire Upon the Grass", "Terrio Erastes", 209);
        printBookPlacement("Fire Upon the Grass", "Terrio Erastes", 209);
        printBookPlacement("The Fires of the Freehold", "Galendro", 285);
        addBookToLibrary("Lives of Four Kings", "Kaeth", 248);
        printAllBooksInfo();
        removeBookFromLibrary("The Fires of the Freehold", "Galendro", 285);
        printAllBooksInfo();


    }

    public static void addBookToLibrary(String title, String author, int year) {
        String section = whichSectionToAdd(author);
        library.put(new Book(title, author, year), section);
    }

    // group by authors
    private static String whichSectionToAdd(String author) {
        char section = author.charAt(0);
        switch (section) {
            case 'A', 'B', 'C', 'D', 'E', 'F', 'G':
                return BookStorages.SECTION_AG;
            case 'H', 'I', 'J', 'K', 'L':
                return BookStorages.SECTION_HL;
            case 'M', 'N', 'O', 'P':
                return BookStorages.SECTION_MP;
            case 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z':
                return BookStorages.SECTION_QZ;
            default:
                throw new IllegalArgumentException("Use english alphabet / First letter of a name should be upper case");
        }
    }

    public static void removeBookFromLibrary(String title, String author, int year) {
        library.remove(searchBook(title, author, year));
    }

    public static void printBookPlacement(String title, String author, int year) {
        System.out.println(library.get(searchBook(title, author, year)));
    }

    private static Book searchBook(String title, String author, int year) {
        for (Map.Entry<Book, String> book : library.entrySet()) {
            if (book.getKey().getTitle() == title &&
                    book.getKey().getAuthor() == author &&
                    book.getKey().getYear() == year) {
                return book.getKey();
            }
        }
        throw new IllegalArgumentException(String.format("There's no book such as %s by %s released in %d in our library",
                title, author, year));
    }

    public static void printAllBooksInfo() {
        int count = 1;
        for (Map.Entry<Book, String> book : library.entrySet()) {
            System.out.printf("%d. %s by %s released in %d%n",
                    count, book.getKey().getTitle(), book.getKey().getAuthor(), book.getKey().getYear());
            count++;
        }
    }
}
