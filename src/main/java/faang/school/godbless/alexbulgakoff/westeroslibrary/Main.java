package faang.school.godbless.alexbulgakoff.westeroslibrary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        final LibraryService libraryService = new LibraryService();

        Book book1 = new Book("The red book", "Mister Elkin", "100");
        Book book2 = new Book("Children of Summer", "Mister Gallard", "105");
        Book book3 = new Book("The End of the Tall Men", "Bello", "97");

        libraryService.addBook(book1, "Section E");
        libraryService.addBook(book2, "Section G");
        libraryService.addBook(book3, "Section B");

        System.out.println(libraryService.getAllBooks());
        System.out.println();

        System.out.println(libraryService.searchBook("97"));
        System.out.println();

        libraryService.removeBookByKey("105");
        System.out.println();

        System.out.println(library);


    }

    static class LibraryService {

        public void addBook(Book newBook, String section) {
            library.put(newBook, section);
        }

        public Map<Book, String> getAllBooks() {
            return library;
        }

        public String searchBook(String str) {
            String result = null;

            for (Map.Entry<Book, String> entry: library.entrySet()) {
                if (checkEntry(entry, str)) {
                    result = entry.getValue();
                }
            }
            return result;
        }

        public void removeBookByKey(String str) {
            Iterator<Map.Entry<Book, String>> iterator = library.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<Book, String> entry = iterator.next();

                if(checkEntry(entry, str)) {
                    iterator.remove();
                }
            }
        }

        private boolean checkEntry(Map.Entry<Book, String> entry, String str) {
            return entry.getKey().getTitle().equalsIgnoreCase(str) ||
                    entry.getKey().getAuthor().equalsIgnoreCase(str) ||
                    entry.getKey().getYear().equalsIgnoreCase(str);
        }
    }

}
