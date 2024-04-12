package faang.school.godbless.hashmap.third;

import java.util.HashMap;
import java.util.Map;

public class Main {
    HashMap<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.addBook("War and Peace", "L.Tolstoy", 1865, "1 floor, 3 room, 1 rack, 7 shelf");
        main.addBook("The Idiot", "F.Dostoevsky", 1868, "1 floor, 3 room, 2 rack, 3 shelf");
        main.addBook("Three Comrades", "E.Remarque", 1936, "2 floor, 1 room, 5 rack, 2 shelf");
        main.addBook("Time to live and time to die", "E.Remarque", 1954, "2 floor, 1 room, 5 rack, 3 shelf");
        main.writeLibrary(main.library);
        System.out.println("*****");
        main.deleteBook("The Idiot", "F.Dostoevsky", 1868);
        System.out.println("*****");
        System.out.println(main.searchBook("Time to live and time to die", "E.Remarque", 1954));
        System.out.println("*****");
        main.writeLibrary(main.library);
    }

    public void addBook(String title, String author, int year, String place) {
        Book book = new Book(title, author, year);
        library.put(book, place);
    }

    public void deleteBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public String searchBook(String title, String author, int year) {
        return library.get(new Book(title, author, year));
    }

    public void writeLibrary(HashMap<Book, String> library) {
        for (Map.Entry entry : library.entrySet()) {
            System.out.println(entry);
        }
    }
}
