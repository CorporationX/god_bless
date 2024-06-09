package faang.school.godbless.vesteros_library;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static HashMap<Book, String> books = new HashMap<>();
    static Book voina_i_mir = new Book("Война и мир", "Толстой Л.Н.", 2001);
    static Book mciry = new Book("Мцири", "Лермонтов М.Ю.", 2002);
    static Book prest_i_nakaz = new Book("Преступление и наказание", "Достоевский Ф.",
            2003);
    static Book peterFirst = new Book("Пётр I", "Толсной А.Н.", 1999);

    public static void main(String[] args) {

        books.put(voina_i_mir, "1");
        books.put(mciry, "2");
        books.put(prest_i_nakaz, "3");

        Book.getAllBooksAndItsPlaces(books);
        System.out.println();
        Book.addNewBook(mciry, "4", books);
        Book.getAllBooksAndItsPlaces(books);
        System.out.println();
        Book.addNewBook(peterFirst, "4", books);
        Book.getAllBooksAndItsPlaces(books);
        System.out.println();
        Book.deleteBookByItsTitleAuthorYear("Мцири", "Лермонтов М.Ю.", 2002, books);
        Book.getAllBooksAndItsPlaces(books);
        System.out.println();
        Book.findBookPlaceByTitleAuthorYear("Пётр I", "Толсной А.Н.", 1999, books);
    }

}
