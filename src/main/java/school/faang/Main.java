package school.faang;

import school.faang.library.Book;
import school.faang.library.Library;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> map = new HashMap<>();
        map.put(new Book("To Kill a Mockingbird", "Harper Lee", 1960), "Полка номер 1");
        map.put(new Book("War and Peace", "Лев Толстой", 1869), "Полка номер 2");
        map.put(new Book("Bruce Eckel", "Философия Java", 1998), "Полка номер 3");

        Library library = new Library();
        library.addBook(new Book("Мастер и Маргарита", "М.Булгаков", 1966), "Полка номер 4");
        library.addBook(new Book("Ромео и Джульетта", "У.Шекспир", 1591), "Полка номер 5");
        library.addBook(new Book("Божественная комедия", "Данте Алигьери", 1308), "Полка номер 6");

        library.printAllBooks();
        library.deleteBook("Ромео и Джульетта", "У.Шекспир", 1591);
        library.searchBook("Мастер и Маргарита", "М.Булгаков", 1966);
    }
}
